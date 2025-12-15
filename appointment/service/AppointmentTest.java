package com.appointment.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

class AppointmentTest {

    @Test
    void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor Appointment");
        
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor Appointment", appointment.getDescription());
    }

    @Test
    void testAppointmentIdTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    void testAppointmentIdNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
    }

    @Test
    void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Description");
        });
    }

    @Test
    void testAppointmentDateInPast() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1); // Yesterday
        Date pastDate = cal.getTime();
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Description");
        });
    }

    @Test
    void testDescriptionNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, null);
        });
    }

    @Test
    void testDescriptionTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, 
                           "This description is way too long and exceeds fifty characters");
        });
    }
}
