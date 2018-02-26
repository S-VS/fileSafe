package com.svs.client.screen.main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void start() throws Exception {

        Parent mainScreen = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

        Scene scene = new Scene(mainScreen,600,400);
        Stage mainStage = new Stage();
        mainStage.setTitle("File Safe");
        mainStage.setScene(scene);
        mainStage.initModality(Modality.WINDOW_MODAL);

        mainStage.show();
    }
}
