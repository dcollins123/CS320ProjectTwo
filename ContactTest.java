package com.dcollins.mobileapplication.test;
import com.dcollins.mobileapplication.Contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void testContactCreation() {
        assertAll("Ensure correct contact creation",
            () -> assertEquals("John", contact.getFirstName()),
            () -> assertEquals("Doe", contact.getLastName()),
            () -> assertEquals("1234567890", contact.getPhone()),
            () -> assertEquals("123 Main St", contact.getAddress())
        );
    }

    @Test
    void testContactIdNotNullAndUpdatable() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Contact(null, "Jane", "Doe", "1234567890", "123 Main St")
        );
        assertTrue(exception.getMessage().contains("Invalid contact ID"));
    }

    // Additional tests...
}
