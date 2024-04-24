package com.dcollins.mobileapplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId()))
            throw new IllegalArgumentException("Appointment already exists or is null");
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId))
            throw new IllegalArgumentException("Appointment does not exist");
        appointments.remove(appointmentId);
    }

    public void updateAppointment(String appointmentId, Date appointmentDate, String description) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment == null) throw new IllegalArgumentException("Appointment does not exist");
        if (appointmentDate != null) appointment.setAppointmentDate(appointmentDate);
        if (description != null) appointment.setDescription(description);
    }

    public Appointment getAppointmentById(String id) {
        return appointments.get(id);
    }

}
