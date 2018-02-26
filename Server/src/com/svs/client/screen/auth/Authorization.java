package com.svs.client.screen.auth;

import com.svs.client.Client;
import com.svs.client.screen.main.MainScreen;
import com.svs.common.DataBaseFS;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Authorization implements Initializable {
    private Stage authStage = new Stage();


    @FXML
    protected Button btnSignIn;
    @FXML
    private TextField loginUser;
    @FXML
    private PasswordField passUser;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void start() throws Exception {
        Parent authScreen = FXMLLoader.load(getClass().getResource("Authorization.fxml"));
        authStage.setTitle("File Safe");
        Scene scene = new Scene(authScreen,600,400);
        authStage.setScene(scene);
        scene.getStylesheets().add("css/styles.css");
        authStage.setResizable(false);
        authScreen.setOnKeyPressed(onClickKey);

        authStage.show();
    }
    public void btnSignInClick(ActionEvent actionEvent) {
        btnSignIn.setOnAction(onClickMouse);
    }

    private final EventHandler<ActionEvent> onClickMouse = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            checkAuthorization();
        }
    };

    private final EventHandler<KeyEvent> onClickKey = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode() == KeyCode.ENTER) checkAuthorization();
        }
    };

    public void passUser(MouseEvent mouseEvent) {
    }

    public void loginUserClick(MouseEvent mouseEvent) {
        loginUser.clear();
    }

    public void loginUserReleased(TouchEvent touchEvent) {
        loginUser.setText("Enter email");
    }

    private void checkAuthorization() {
        String user = loginUser.getText();
        String password = passUser.getText();
        String select = "SELECT id, login, password FROM user WHERE login = '" + user + "' AND password = '" + password + "';";
        String answer = "Добро пожаловать";
        if (new DataBaseFS().selectDataBase(select, answer) != null) {
            closeAuthScreen();
            System.out.println(answer);
            new Client().connect();
            try {
                new MainScreen().start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Неверный логин или пароль.");
        }
    }
    private void closeAuthScreen() {
        authStage = (Stage) btnSignIn.getScene().getWindow();
        authStage.close();
    }


}