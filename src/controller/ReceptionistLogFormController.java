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

public class ReceptionistLogFormController {
    public AnchorPane receptionistLogFormContext;
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String tempUserName=txtUserName.getText();
        String tempPassword=pwdPassword.getText();

        if(tempUserName.equals("rec") && tempPassword.equals("1234")){
            setUi("ReseptionistBookRoomForm1");
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) receptionistLogFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainLogForm.fxml"))));
        stage.centerOnScreen();
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) receptionistLogFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
