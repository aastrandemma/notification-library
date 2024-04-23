package com.github.aastrandemma.dao;

import com.github.aastrandemma.exception.DataNotFoundException;
import com.github.aastrandemma.model.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailDaoTest {
    private EmailDaoImpl testObject;
    private Email savedEmail;

    @BeforeEach
    public void setUp() {
        testObject = EmailDaoImpl.getInstance();
        Email email = new Email("recipient@example.se", "Test subject", "Test content.");
        savedEmail = testObject.save(email);

        assertNotNull(savedEmail);
    }

    @Test
    @DisplayName("Test save e-mail")
    public void testSave() {
        assertNotNull(savedEmail);
        assertEquals(savedEmail, testObject.find(savedEmail.getId()));
    }

    @Test
    @DisplayName("Test find e-mail by id")
    public void testFind() {
        Email foundEmail = testObject.find(savedEmail.getId());
        assertNotNull(foundEmail);
        assertEquals(savedEmail, foundEmail);
    }

    @Test
    @DisplayName("Test find by id with non existing id")
    public void testFindNonExistingId() {
        assertThrows(DataNotFoundException.class, () -> testObject.find("non-existing-id"),
                "We are expecting an error message regarding id not existing.");
        // assertThrows(DataNotFoundException.class, () -> testObject.find("non existing id") );
    }
}