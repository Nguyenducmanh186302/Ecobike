package view.viewMuonXe;

import controller.DataController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Bike;


import java.io.IOException;



public class EnterBarcodeHandle {
    @FXML
    private TextField barcodeTextField = new TextField();

    private DataController dataController = new DataController();

    public void enterBarcode(ActionEvent event) throws IOException {
        String barcode = barcodeTextField.getText();
        if(barcode.trim().isEmpty()){
            displayError("Hãy nhập thông tin barcode !");
        } else{
            Bike bike = dataController.getBikeFromBarcode(barcode);
            System.out.println(barcode);
            if(bike != null){
                if(bike.getStationId() != 0){
                    int deposit = dataController.calculateDeposit(bike);
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/view/viewMuonXe/BikeDetails.fxml"));
                    Parent view = loader.load();
                    Scene scene = new Scene(view);
                    BikeDetailsHandle controller = loader.getController();
                    controller.setInfoBike(bike,deposit);
                    stage.setScene(scene);
                } else{
                    displayError("Xe đã có người mượn !");
                }
            } else{
                displayError("Barcode không hợp lệ !");
            }
        }
    }

    public void displayError(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }
}
