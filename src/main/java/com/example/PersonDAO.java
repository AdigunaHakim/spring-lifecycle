package com.example;

import java.sql.*;

public class PersonDAO {
    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection connection;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void createConnection() throws ClassNotFoundException {
        Class.forName(driver);

        try {
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("createConnection successful...");
        } catch (SQLException e) {
            System.out.println("createConnection failed...");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("closeConnection successful...");
        } catch (SQLException e) {
            System.out.println("closeConnection failed...");
        }
    }

    public void getAll(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM person");

            while (rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }
            System.out.println("getAll personal data successful...");
        } catch (SQLException e) {
            System.out.println("getAll personal data failed...");
        }
    }
}
