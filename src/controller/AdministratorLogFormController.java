package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AdministratorLogFormController {
    public AnchorPane adminLoginFormContext;
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) adminLoginFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainLogForm.fxml"))));
        stage.centerOnScreen();

    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String tempUserName=txtUserName.getText();
        String tempPassword=pwdPassword.getText();

        if(tempUserName.equals("admin") && tempPassword.equals("1234")){
            setUi("AdminAddRoomForm1");
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
        }
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) adminLoginFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
