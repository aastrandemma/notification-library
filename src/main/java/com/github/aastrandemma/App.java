package com.github.aastrandemma;

import com.github.aastrandemma.dao.EmailDao;
import com.github.aastrandemma.dao.EmailDaoImpl;
import com.github.aastrandemma.model.Email;

public class App {
    public static void main(String[] args) {
        EmailDao dao = EmailDaoImpl.getInstance(); // emailList is empty

        Email email1 = dao.save(new Email("john@doe.se", "Test Subject", "Test content."));
        System.out.println(email1.summary());
        System.out.println("----------------------");

        System.out.println(dao.findAll().size()); // emailList has one element
        System.out.println("----------------------");

        EmailDao dao2 = EmailDaoImpl.getInstance(); // emailList has one element
        System.out.println(dao2.findAll().size()); // emailList has one element
        System.out.println("----------------------");
    }
}