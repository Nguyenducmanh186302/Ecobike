package view.viewMuonXe;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Bike;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;


public class BikeDetailsHandle implements Initializable {
    @FXML
    Label Barcode = new Label();

    @FXML
    Label Name = new Label();

    @FXML
    Label Type = new Label();

    @FXML
    Label Weight = new Label();

    @FXML
    Label LicensePlate = new Label();

    @FXML
    Label ManufacturingDate = new Label();

    @FXML
    Label Producer = new Label();

    @FXML
    Label Cost = new Label();

    @FXML
    Label Description = new Label();

    @FXML
    Label Deposit = new Label();

    @FXML
    ImageView ViewBike = new ImageView();

    private Bike bike;

    public void setInfoBike(Bike bike, int deposit) throws MalformedURLException {
        this.bike = bike;
        System.out.println("Details : "+bike.getBarcode());
        Barcode.setText(bike.getBarcode());
        Name.setText(bike.getName());
        Type.setText(bike.getType());
        Weight.setText(String.valueOf(bike.getWeight()));
        LicensePlate.setText(bike.getLicensePlate());
        ManufacturingDate.setText(String.valueOf(bike.getManufacturingDate()));
        Producer.setText(bike.getProducer());
        Cost.setText(String.valueOf(bike.getCost()));
        Description.setText(bike.getDescription());
        Deposit.setText(deposit+" VNĐ");
        File file = new File(bike.getImgPath());
        Image image = new Image(file.toURI().toURL().toString());
        ViewBike.setImage(image);
    }


    public void back(ActionEvent actionEvent) throws IOException {
        System.out.println("Click back");
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/viewMuonXe/EnterBarcode.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void requestRentbike(ActionEvent actionEvent) {
        System.out.println(bike.getBarcode());
    }
}
