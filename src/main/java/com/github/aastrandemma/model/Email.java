package com.github.aastrandemma.model;

public class Email extends Notification {
    private String recipient;
    private String subject;
    private String content;
    // private byte[] attachments;

    public Email(String recipient, String subject, String content) {
        super();
        setRecipient(recipient);
        setSubject(subject);
        setContent(content);
    }

    public String getRecipient() {
        return recipient;
    }

    /**
     * Set the recipient of the e-mail.
     * @param recipient The recipient who going to receive the email.
     * @throws IllegalArgumentException if recipient is null.
     */
    public void setRecipient(String recipient) {
        if (recipient == null) throw new IllegalArgumentException("Recipient e-mail is null.");
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String summary() {
        return super.toString() + " -> e-mail sent to: " + recipient + " with subject: " + subject;
    }
}