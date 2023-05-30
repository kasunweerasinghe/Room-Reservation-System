package controller;

import db.MealDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Meal;
import view.tm.MealTM;

import java.io.IOException;

public class ReceptionistOrderMealForm1Controller {
    public AnchorPane receptionistOrderMealContext;
    public TableView<MealTM> tblReceptionistOrderMeal;
    public TableColumn coldishcode;
    public TableColumn colname;
    public TableColumn colquantity;
    public TableColumn colprice;
    public TableColumn colaction;


    public void initialize(){
        coldishcode.setCellValueFactory(new PropertyValueFactory("dishCode"));
        colname.setCellValueFactory(new PropertyValueFactory("name"));
        colquantity.setCellValueFactory(new PropertyValueFactory("qty"));
        colprice.setCellValueFactory(new PropertyValueFactory("price"));
        colaction.setCellValueFactory(new PropertyValueFactory("btn2"));


        loadAllMeal();
    }

    private void loadAllMeal() {
        ObservableList<MealTM> obList = FXCollections.observableArrayList();
        for (Meal m: MealDatabase.mealTable
             ) {
            Button btn1 = new Button("Delete");
            Button btn2 = new Button("Order");
            MealTM tm=new MealTM(m.getDishCode(),m.getName(),m.getQty(),m.getPrice(),btn1,btn2);
            obList.add(tm);
        }
        tblReceptionistOrderMeal.setItems(obList);
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionistOrderMealContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistLogForm.fxml"))));
        stage.centerOnScreen();
    }

    public void OpenBookRoomOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionistOrderMealContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReseptionistBookRoomForm1.fxml"))));
    }
}
