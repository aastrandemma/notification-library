package com.github.aastrandemma.model;

import java.time.LocalDate;

public abstract class Notification {
    private String id;
    private LocalDate createDateTime;
    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDate createDateTime) {
        this.createDateTime = createDateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public abstract String summary();

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", createDateTime=" + createDateTime +
                ", status=" + status +
                '}';
    }
}