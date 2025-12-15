package com.appointment.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentServiceTest {
    
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor Appointment");
        
        assertTrue(appointmentService.addAppointment(appointment));
        assertEquals(appointment, appointmentService.getAppointment("1234567890"));
    }

    @Test
    void testAddDuplicateAppointmentId() {
        Date futureDate1 = new Date(System.currentTimeMillis() + 100000);
        Date futureDate2 = new Date(System.currentTimeMillis() + 200000);
        
        Appointment appointment1 = new Appointment("1234567890", futureDate1, "First Appointment");
        Appointment appointment2 = new Appointment("1234567890", futureDate2, "Second Appointment");
        
        appointmentService.addAppointment(appointment1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor Appointment");
        appointmentService.addAppointment(appointment);
        
        assertTrue(appointmentService.deleteAppointment("1234567890"));
        assertNull(appointmentService.getAppointment("1234567890"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        assertFalse(appointmentService.deleteAppointment("9999999999"));
    }

    @Test
    void testAddNullAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(null);
        });
    }
}