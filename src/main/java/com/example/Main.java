package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        PersonDAO personDAO = context.getBean("personDAO", PersonDAO.class);
        personDAO.createConnection();
    }
}
