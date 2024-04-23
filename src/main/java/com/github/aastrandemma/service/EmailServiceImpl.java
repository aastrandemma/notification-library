package com.github.aastrandemma.service;

import com.github.aastrandemma.dao.EmailDao;
import com.github.aastrandemma.dao.EmailDaoImpl;
import com.github.aastrandemma.exception.EmailException;
import com.github.aastrandemma.model.Email;
import com.github.aastrandemma.util.EmailSender;

import java.util.List;

public class EmailServiceImpl implements EmailService {
    private final EmailDao emailDao;

    public EmailServiceImpl() {
        emailDao = EmailDaoImpl.getInstance();
    }

    @Override
    public Email createAndSend(String recipient, String subject, String message) throws EmailException {
        if (recipient == null) throw new IllegalArgumentException("Recipient is null.");
        Email savedEmail = emailDao.save(new Email(recipient, subject, message));
        EmailSender.sendEmail(savedEmail.getRecipient(), savedEmail.getSubject(), savedEmail.getContent());
        savedEmail.setStatus(true);
        emailDao.update(savedEmail);
        return savedEmail;
    }

    @Override
    public List<Email> findAll() {
        return emailDao.findAll();
    }
}