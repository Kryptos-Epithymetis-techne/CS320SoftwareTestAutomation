package com.contact.service;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add contact with unique ID
    public boolean addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    // Delete contact by ID
    public boolean deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            return false;
        }
        
        contacts.remove(contactId);
        return true;
    }

    // Update contact fields by ID
    public boolean updateFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        contact.setFirstName(firstName);
        return true;
    }

    public boolean updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        contact.setLastName(lastName);
        return true;
    }

    public boolean updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        contact.setPhone(phone);
        return true;
    }

    public boolean updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        contact.setAddress(address);
        return true;
    }

    // Get contact by ID (useful for testing)
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}