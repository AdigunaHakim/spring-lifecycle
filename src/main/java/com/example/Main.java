package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        PersonDAO personDAO = context.getBean("personDAO", PersonDAO.class);
        personDAO.createConnection();
        personDAO.findAll();
    }
}
