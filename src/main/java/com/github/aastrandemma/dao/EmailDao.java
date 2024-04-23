package com.github.aastrandemma.dao;

import com.github.aastrandemma.model.Email;

import java.util.List;

public interface EmailDao extends  NotificationDao<Email> {
    List<Email> findBySubject(String subject);
}