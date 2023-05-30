package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.RoomDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Room;
import view.tm.RoomTM;

import java.io.IOException;
import java.util.Optional;

public class AdminAddRoomForm1Controller {
    public TableView<RoomTM> tblRoom;
    public TableColumn colRoomNo;
    public TableColumn colCapacity;
    public TableColumn colStatus;
    public TableColumn colPrice;
    public TableColumn colOption;
    public TableColumn colAction;
    public AnchorPane addRoomFormContext;
    public JFXTextField txtRoomNo;
    public JFXTextField txtCapacity;
    public JFXTextField txtStatus;
    public JFXTextField txtPrice;
    public JFXButton btnSave;

    public void initialize(){

        colRoomNo.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colCapacity.setCellValueFactory(new PropertyValueFactory("capacity"));
        colStatus.setCellValueFactory(new PropertyValueFactory("status"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn1"));
        colAction.setCellValueFactory(new PropertyValueFactory("btn2"));

        tblRoom.getSelectionModel().selectedItemProperty()
                .addListener((observableValue, oldValue, newValue) -> {
                    if(newValue !=null){
                        setData(newValue);
                    }

                });

        loadAllRooms();
    }

    private void setData(RoomTM tm) {
        btnSave.setText("Update");
        txtRoomNo.setText(tm.getRoomNo());
        txtCapacity.setText(String.valueOf(tm.getCapacity()));
        txtStatus.setText(tm.getStatus());
        txtPrice.setText(String.valueOf(tm.getPrice()));

    }

    private void loadAllRooms() {
        ObservableList<RoomTM> obList = FXCollections.observableArrayList();

        for (Room r : RoomDatabase.roomTable
             ) {
            Button btn1 = new Button("Delete");
                Button btn2 = new Button("Book Now");
                RoomTM tm = new RoomTM(r.getRoomNo(), r.getCapacity(), r.getStatus(), r.getPrice(), btn1, btn2);
                obList.add(tm);

            btn1.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if(buttonType.get().equals(ButtonType.YES)){
                    RoomDatabase.roomTable.remove(r);
                    obList.remove(tm);
                }
            });
        }
        tblRoom.setItems(obList);
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) addRoomFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdministratorLogForm.fxml"))));
        stage.centerOnScreen();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        if(btnSave.getText().equals("Save Room")){
            Room r1 = new Room(
                    txtRoomNo.getText(),
                    Integer.parseInt(txtCapacity.getText()),
                    txtStatus.getText(),
                    Integer.parseInt(txtPrice.getText())
            );
            RoomDatabase.roomTable.add(r1);
            loadAllRooms();
        }else{
            for (Room tm:RoomDatabase.roomTable
                 ) {
                if(tm.getRoomNo().equals(txtRoomNo.getText())){
                    tm.setCapacity(Integer.parseInt(txtCapacity.getText()));
                    tm.setStatus(txtStatus.getText());
                    tm.setPrice(Integer.parseInt(txtPrice.getText()));
                    loadAllRooms();
                    return;
                }
            }
        }
        
    }

    public void btnNewRoomOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Room");
    }

    public void openMealFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) addRoomFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminAddMealForm1.fxml"))));
    }


}
