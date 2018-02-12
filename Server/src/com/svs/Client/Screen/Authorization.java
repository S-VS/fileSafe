package com.svs.Client.Screen;

import com.svs.Client.Client;

import com.svs.Common.DataBaseFS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Authorization implements Initializable {
    Client client = new Client();
    DataBaseFS dataBaseFS = new DataBaseFS();
    private String user;
    private String password;

    @FXML
    private Button btnSignIn;
    @FXML
    private TextField loginUser;
    @FXML
    private PasswordField passUser;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void btnSignInClick(ActionEvent event) {
        user = loginUser.getText();
        password = passUser.getText();
        if (dataBaseFS.checkUserPass(user, password) != null) {
            System.out.println("Добро пожаловать");
            client.connect();
        }else{
            System.out.println("Неверный логин или пароль.");
        }

    }

    public void passUser(MouseEvent mouseEvent) {
    }

    public void loginUserClick(MouseEvent mouseEvent) {
        loginUser.clear();
    }

    public void loginUserReleased(TouchEvent touchEvent) {
        loginUser.setText("Enter email");
    }

}