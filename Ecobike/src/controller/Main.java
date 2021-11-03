package controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public SQLServerDataSource getConnect(){
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("Meyeuthuong123");
        ds.setServerName("DESKTOP-ORQBGO8\\SQLEXPRESS");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Ecobike");
        return ds;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/viewMuonXe/EnterBarcode.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mượn sách");
        primaryStage.show();
    }
}
