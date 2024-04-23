package com.github.aastrandemma.service;

import com.github.aastrandemma.exception.EmailException;
import com.github.aastrandemma.model.Email;

import java.util.List;

public interface EmailService {
    Email createAndSend(String recipient, String subject, String message) throws EmailException;
    List<Email> findAll();
}