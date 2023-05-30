package controller;

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
import model.Room;
import view.tm.RoomTM;

import java.io.IOException;
import java.util.Optional;

public class ReseptionistBookRoomForm1Controller {
    public AnchorPane receptionistBookRoomFormContext;
    public TableView<RoomTM> tblreceptionistBook;
    public TableColumn colroomno;
    public TableColumn colcapacity;
    public TableColumn colstatus;
    public TableColumn colprice;
    public TableColumn colaction;

    public void initialize(){
        colroomno.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colcapacity.setCellValueFactory(new PropertyValueFactory("capacity"));
        colstatus.setCellValueFactory(new PropertyValueFactory("status"));
        colprice.setCellValueFactory(new PropertyValueFactory("price"));
        colaction.setCellValueFactory(new PropertyValueFactory("btn2"));

        loadAllRoom();
    }

    private void loadAllRoom() {
        ObservableList<RoomTM> obList= FXCollections.observableArrayList();
        for (Room r: RoomDatabase.roomTable
             ) {
            Button btn1 =new Button("delete");

            Button btn2 = new Button("Book Now");

            RoomTM tm=new RoomTM(r.getRoomNo(),r.getCapacity(),r.getStatus(),r.getPrice(),btn1,btn2);
            obList.add(tm);


            btn2.setOnAction((e)->{
                Stage stage = (Stage) receptionistBookRoomFormContext.getScene().getWindow();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistBookRoomForm2.fxml"))));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                stage.centerOnScreen();
            });
        }
        tblreceptionistBook.setItems(obList);
    }




    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionistBookRoomFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistLogForm.fxml"))));
        stage.centerOnScreen();
    }

    public void openOrderMealFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionistBookRoomFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistOrderMealForm1.fxml"))));
    }
}
