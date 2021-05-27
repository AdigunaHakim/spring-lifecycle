package com.example;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        PersonDAO personDAO = context.getBean("personDAO", PersonDAO.class);
        personDAO.findAll();

        context.registerShutdownHook();
        System.out.println("Call again : " + context.getBean("personDAO", PersonDAO.class));
    }
}
