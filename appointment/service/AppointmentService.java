package com.appointment.service;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    // Add appointment with unique ID
    public boolean addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        
        appointments.put(appointment.getAppointmentId(), appointment);
        return true;
    }

    // Delete appointment by ID
    public boolean deleteAppointment(String appointmentId) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            return false;
        }
        
        appointments.remove(appointmentId);
        return true;
    }

    // Get appointment by ID (useful for testing)
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
