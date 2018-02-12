package com.svs.Common;

import java.sql.*;

public class DataBaseFS {
    private static Connection connection;
    private static Statement statement;
    private static final String URL = "jdbc:mysql://localhost:3306/dbfilesafe?useSSL=false";
    private static final String USERNAMEDB = "root";
    private static final String PASSWORDDB = "123456";
    private String login;
    private String password;


    public DataBaseFS() {
        this.login = login;
        this.password = password;
    }

    public String checkUserPass(String login, String password) {
        try {
            connect();
            ResultSet resultSetLogin = statement.executeQuery("SELECT id, login, password FROM user WHERE login = '" + login + "' AND password = '" + password + "';");
            while (resultSetLogin.next()) {
                return "Добро пожаловать";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAMEDB, PASSWORDDB);
        statement = connection.createStatement();
        System.out.println("Подключились");
    }

    public static void disconnect() {
        try {
            statement.close();
            connection.close();
            System.out.println("Отключились");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
