package com.example;

import java.sql.*;

public class PersonDAO {
    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection connection;

    public PersonDAO() {
        System.out.println("no arg constructor called...");
    }

    public void setDriver(String driver) {
        System.out.println("setDriver called...");
        this.driver = driver;
    }

    public void setUrl(String url) {
        System.out.println("setUrl called...");
        this.url = url;
    }

    public void setUser(String user) {
        System.out.println("setUser called...");
        this.user = user;
    }

    public void setPassword(String password) {
        System.out.println("setPassword called...");
        this.password = password;
    }

    public void init() throws ClassNotFoundException {
        System.out.println("init method called...");
        createConnection();
    }

    public void destroy() {
        System.out.println("destroy method called...");
        closeConnection();
    }

    public void createConnection() throws ClassNotFoundException {
        Class.forName(driver);
        System.out.println("createConnection called...");

        try {
            connection = DriverManager.getConnection(String.format("%s?user=%s&password=%s&serverTimezone=UTC", url, user, password));

            System.out.println("createConnection successful...");
        } catch (SQLException e) {
            System.out.println("createConnection failed...");
        }
    }

    public void closeConnection() {
        System.out.println("closeConnection called...");

        try {
            connection.close();
            System.out.println("closeConnection successful...");
        } catch (SQLException e) {
            System.out.println("closeConnection failed...");
        }
    }

    public void findAll() throws SQLException {
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3));
            }
            System.out.println("findAll personal data successful...");
        } catch (SQLException e) {
            System.out.println("findAll personal data failed...");
        } finally {
            assert statement != null;
            statement.close();
        }
    }

    public void insert(String name, String address) throws SQLException {
        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO person (name, address) VALUES ('" + name + "', '" + address + "')");

            System.out.println("insert personal data successful...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("insert personal data failed...");
        } finally {
            assert statement != null;
            statement.close();
        }
    }
}
