package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.MealDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Meal;
import view.tm.MealTM;

import java.io.IOException;
import java.util.Optional;

public class AdminAddMealForm1Controller {
    public TableView<MealTM> tblMeal;
    public TableColumn colDishCode;
    public TableColumn colName;
    public TableColumn colQuantity;
    public TableColumn colPrice;
    public TableColumn colOption;
    public TableColumn colAction;
    public JFXTextField txtDishCode;
    public JFXTextField txtName;
    public JFXTextField txtQuantity;
    public JFXTextField txtPrice;
    public JFXButton btnSave;
    public AnchorPane AdminAddMealFormContext;

    public void initialize(){
        colDishCode.setCellValueFactory(new PropertyValueFactory("dishCode"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn1"));
        colAction.setCellValueFactory(new PropertyValueFactory("btn2"));

        loadAllMeal();

        tblMeal.getSelectionModel().selectedItemProperty()
                .addListener((observableValue, oldValue, newValue) -> {
                    if(newValue !=null){
                        setData(newValue);
                    }

        });
    }

    private void setData(MealTM tm) {
        btnSave.setText("Update");
        txtDishCode.setText(tm.getDishCode());
        txtName.setText(tm.getName());
        txtQuantity.setText(String.valueOf(tm.getQty()));
        txtPrice.setText(String.valueOf(tm.getPrice()));
    }

    private void loadAllMeal() {
        ObservableList<MealTM> obList= FXCollections.observableArrayList();

        for (Meal m: MealDatabase.mealTable
             ) {
            Button btn1 = new Button("Delete");
            Button btn2 = new Button("Order");

            MealTM tm = new MealTM(m.getDishCode(),m.getName(),m.getQty(),m.getPrice(),btn1,btn2);
            obList.add(tm);

            btn1.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?",
                        ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if(buttonType.get().equals(ButtonType.YES)){
                    MealDatabase.mealTable.remove(m);
                    obList.remove(tm);
                }
                
            });
        }
        tblMeal.setItems(obList);
    }

    public void btnSaveMealOnAction(ActionEvent actionEvent) {
        if(btnSave.getText().equals("Save Meal")){
            Meal m1 = new Meal(
                    txtDishCode.getText(),
                    txtName.getText(),
                    Integer.parseInt(txtQuantity.getText()),
                    Integer.parseInt(txtPrice.getText())
            );

            MealDatabase.mealTable.add(m1);
            loadAllMeal();
        }else{
            for (Meal tm :MealDatabase.mealTable
                 ) {
                if(tm.getDishCode().equals(txtDishCode.getText())){
                    tm.setDishCode(txtDishCode.getText());
                    tm.setName(txtName.getText());
                    tm.setQty(Integer.parseInt(txtQuantity.getText()));
                    tm.setPrice((Integer.parseInt(txtPrice.getText())));
                    loadAllMeal();
                    return;

                }
            }
        }

    }

    public void btnNewMealOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Meal");
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) AdminAddMealFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainLogForm.fxml"))));
        stage.centerOnScreen();
    }

    public void openAddRoomOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) AdminAddMealFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminAddRoomForm1.fxml"))));
    }
}
