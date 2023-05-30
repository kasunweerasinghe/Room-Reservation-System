package controller;

import com.jfoenix.controls.JFXTextField;
import db.CustomerDatabase;
import db.RoomDatabase;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;
import model.Room;
import view.tm.CustomerTM;
import view.tm.RoomTM;

import java.io.IOException;
import java.util.Optional;

public class ReceptionistBookRoomForm2Controller {
    public AnchorPane receptionistBookRoomForm2Context;
    public TableView tblCustomer;
    public TableColumn colName;
    public TableColumn colTelNo;
    public TableColumn colEmail;
    public TableColumn colNicNo;
    public TableColumn colAddress;
    public TableColumn colAction;
    public JFXTextField txtName;
    public JFXTextField txtNicNo;
    public JFXTextField txtTelNo;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtNight;
    public TableColumn colRoomNo;
    public TableColumn colPrice;

    public void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colTelNo.setCellValueFactory(new PropertyValueFactory("telNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colNicNo.setCellValueFactory(new PropertyValueFactory("nicNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colAction.setCellValueFactory(new PropertyValueFactory("btn"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory("roomNo"));

        loadAllCustomer();
        loadRoomDetailToCustomer();
    }

    private void loadRoomDetailToCustomer() {
        ObservableList obList1 = FXCollections.observableArrayList();

        for (Room r:RoomDatabase.roomTable
             ) {
            Button btn1 = new Button();
            Button btn2 = new Button();
            RoomTM tm = new RoomTM(r.getRoomNo(),r.getCapacity(),r.getStatus(),r.getPrice(),btn1,btn2);
            obList1.add(tm);

        }
        tblCustomer.setItems(obList1);
    }

    private void loadAllCustomer() {
        ObservableList obList = FXCollections.observableArrayList();

        for (Customer c: CustomerDatabase.customerTable
             ) {
            Button btn = new Button("Cancel");
            CustomerTM tm = new CustomerTM(c.getName(),c.getTelNo(),c.getEmail(),c.getNicNo(),c.getAddress(),btn);
            obList.add(tm);

            btn.setOnAction((e) ->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?",
                        ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if(buttonType.get().equals(ButtonType.YES)){
                    CustomerDatabase.customerTable.remove(c);
                    obList.remove(tm);
                }else{

                }
            });

        }
        tblCustomer.setItems(obList);


    }



    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionistBookRoomForm2Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistLogForm.fxml"))));
        stage.centerOnScreen();
    }


    public void btnSaveOnAction(ActionEvent actionEvent) {
        Customer c1 = new Customer(
                txtName.getText(),
                txtTelNo.getText(),
                txtEmail.getText(),
                txtNicNo.getText(),
                txtAddress.getText()
        );
        CustomerDatabase.customerTable.add(c1);
        loadAllCustomer();
    }

    public void goBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionistBookRoomForm2Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReseptionistBookRoomForm1.fxml"))));

    }
}
