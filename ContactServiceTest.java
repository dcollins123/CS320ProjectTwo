package com.dcollins.mobileapplication.test;
import com.dcollins.mobileapplication.Contact;
import com.dcollins.mobileapplication.ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        contact = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
    }

    @Test
    void addContact() {
        Contact newContact = new Contact("ID87654321", "Jane", "Doe", "0987654321", "456 Main St");
        assertDoesNotThrow(() -> contactService.addContact(newContact));
    }

    @Test
    void deleteContact() {
        assertDoesNotThrow(() -> contactService.deleteContact(contact.getContactId()));
    }

    @Test
    void updateContact() {
        assertDoesNotThrow(() -> contactService.updateContact(contact.getContactId(), "UpdatedName", "UpdatedLast", "0987654321", "456 Main St"));
        Contact updatedContact = contactService.getContactById(contact.getContactId());
        assertAll("Check contact update",
            () -> assertEquals("UpdatedName", updatedContact.getFirstName()),
            () -> assertEquals("UpdatedLast", updatedContact.getLastName())
        );
    }

    // Additional tests...
}
