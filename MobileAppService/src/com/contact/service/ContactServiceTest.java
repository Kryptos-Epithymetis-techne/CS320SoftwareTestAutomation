package com.contact.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertTrue(contactService.addContact(contact));
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test
    void testAddDuplicateContactId() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "5559876543", "456 Oak Ave");
        
        contactService.addContact(contact1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.deleteContact("1234567890"));
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    void testDeleteNonExistentContact() {
        assertFalse(contactService.deleteContact("9999999999"));
    }

    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.updateFirstName("1234567890", "Jane"));
        assertEquals("Jane", contactService.getContact("1234567890").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.updateLastName("1234567890", "Smith"));
        assertEquals("Smith", contactService.getContact("1234567890").getLastName());
    }

    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.updatePhone("1234567890", "5559876543"));
        assertEquals("5559876543", contactService.getContact("1234567890").getPhone());
    }

    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertTrue(contactService.updateAddress("1234567890", "456 Oak Ave"));
        assertEquals("456 Oak Ave", contactService.getContact("1234567890").getAddress());
    }

    @Test
    void testUpdateNonExistentContact() {
        assertFalse(contactService.updateFirstName("9999999999", "Jane"));
    }
}
