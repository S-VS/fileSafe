package com.svs.client;

import com.svs.client.screen.auth.Authorization;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartClient extends Application {
    private Authorization authorization = new Authorization();

    @Override
    public void start(Stage stage) throws Exception {
        authorization.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
