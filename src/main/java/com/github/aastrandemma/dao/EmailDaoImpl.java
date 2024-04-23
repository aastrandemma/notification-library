package com.github.aastrandemma.dao;

import com.github.aastrandemma.exception.DataNotFoundException;
import com.github.aastrandemma.model.Email;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmailDaoImpl implements  EmailDao {
    private List<Email> emailList = new ArrayList<>();
    @Override
    public Email save(Email email) {
        if (email == null) throw new IllegalArgumentException("E-mail is null.");
        email.setId(UUID.randomUUID().toString().substring(0, 12));
        email.setCreateDateTime(LocalDateTime.now());
        emailList.add(email);
        return email;
    }

    @Override
    public void update(Email email) {
        if (email == null) throw new IllegalArgumentException("E-mail is null.");
        if (email.getId() == null) throw new IllegalArgumentException("E-mail id is null.");

        Email existingEmail = find(email.getId());
        existingEmail.setRecipient(email.getRecipient());
        existingEmail.setSubject(email.getSubject());
        existingEmail.setContent(email.getContent());
    }

    @Override
    public Email find(String id) {
        if (id == null) throw new IllegalArgumentException("Id is null.");
        return emailList.stream()
                .filter(email -> email.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException("E-mail data with id: " + id + " not found."));
    }

    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emailList);
    }

    @Override
    public List<Email> findBySubject(String subject) {
        if (subject == null) throw new IllegalArgumentException("Subject is null.");
        return emailList.stream()
                .filter(email -> email.getSubject().equalsIgnoreCase(subject))
                .collect(Collectors.toList());
    }
}