package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MainLogFormController {
    public AnchorPane MainLogContext;

    public void openAdminLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdministratorLogForm");
    }

    public void openReceptionistLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ReceptionistLogForm");

    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) MainLogContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();


    }

}
