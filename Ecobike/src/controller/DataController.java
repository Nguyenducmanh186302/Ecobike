package controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import controller.CalculatorLogic.FeesCalculator01;
import controller.CalculatorLogic.FeesCalculatorInterface;
import model.Bike;
import model.EBike;
import model.SingleBike;
import model.TwinBike;
import java.sql.*;
import java.util.ArrayList;

public class DataController {
    private SQLServerDataSource ds = new Main().getConnect();

    public ArrayList<Bike> getListBike(){
        ArrayList<Bike> bikes = new ArrayList<>();
        try {
            Connection cnn = ds.getConnection();
            Statement statement = cnn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Bike");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3));
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bikes;
    }

    public Bike getBikeFromBarcode(String barcode){
        Bike bike = null;
        try {
            Connection cnn = ds.getConnection();
            Statement statement = cnn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from bike where barcode = '"+barcode+"'");

            while (resultSet.next()) {
                String typeBike = resultSet.getString(3);
                if(typeBike.equals("EBike")){
                    bike = new EBike();
                }else if(typeBike.equals("TwinBike")){
                    bike = new TwinBike();
                }else{
                    bike = new SingleBike();
                }
                bike.setBarcode(resultSet.getString(1));
                bike.setName(resultSet.getString(2));
                bike.setWeight(resultSet.getInt(4));
                bike.setLicensePlate(resultSet.getString(5));
                bike.setManufacturingDate(resultSet.getDate(6));
                bike.setProducer(resultSet.getString(7));
                bike.setCost(resultSet.getInt(8));
                bike.setDescription(resultSet.getString(9));
                bike.setImgPath(resultSet.getString(10));
                bike.setStationId(resultSet.getInt(11));
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bike;
    }
    public int calculateDeposit(Bike bike){
        FeesCalculatorInterface feesCalculatorInterface = new FeesCalculator01();
        return feesCalculatorInterface.getDeposit(bike.getType());
    }

    /**
     * Mở khóa xe thì trường stationId lúc này được gắn bằng 0
     * @param bike xe cần mở khó
     */
    public void unlockBike(Bike bike){
        try {
            Connection cnn = ds.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement("update Bike set stationId = '0' where barcode = '"+bike.getBarcode()+"'");
            preparedStatement.execute();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
