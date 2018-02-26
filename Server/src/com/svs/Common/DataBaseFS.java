package com.svs.common;

import java.sql.*;

public class DataBaseFS implements Credentials {
    private static Connection connection;
    private static Statement statement;

    private String select;
    private String answer;

    public DataBaseFS() {
        this.select = select;
        this.answer = answer;
    }

    public String selectDataBase(String select, String answer) {
        try {
            connect();
            ResultSet resultSelect = statement.executeQuery(select);
            while (resultSelect.next()) {
                return answer;
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
