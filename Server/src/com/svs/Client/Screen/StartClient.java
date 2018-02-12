package com.svs.Client.Screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartClient extends Application {

    private Button btnSignIn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Authorization.fxml"));
        primaryStage.setTitle("File Safe");
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("css/styles.css");
        primaryStage.setResizable(false);


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
