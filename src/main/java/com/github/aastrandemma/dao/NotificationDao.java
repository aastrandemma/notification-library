package com.github.aastrandemma.dao;

import java.util.List;

public interface NotificationDao<T> {
    T save(T t);
    T update(T t);
    T find(String id);
    List<T> findAll();
}