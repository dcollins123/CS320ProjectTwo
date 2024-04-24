package com.dcollins.mobileapplication.test;

import com.dcollins.mobileapplication.Appointment;
import com.dcollins.mobileapplication.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    private AppointmentService service;

    @BeforeEach
    void setup() {
        service = new AppointmentService();
        // Assuming 'addAppointment' method is correctly implemented
        service.addAppointment(new Appointment("A12345", new Date(), "Meeting with client"));
    }

    @Test
    void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 24 hours in the future
        assertDoesNotThrow(() -> service.addAppointment(new Appointment("A54321", futureDate, "Project discussion")));
        assertNotNull(service.getAppointmentById("A54321"));
    }

    @Test
    void testAddDuplicateAppointment() {
        Date futureDate = new Date();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(new Appointment("A12345", futureDate, "Meeting with client"));
        });
        assertTrue(exception.getMessage().contains("Appointment already exists or is null"));
    }

    @Test
    void testDeleteAppointment() {
        service.deleteAppointment("A12345");
        assertNull(service.getAppointmentById("A12345"));
    }

    @Test
    void testDeleteNonexistentAppointment() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("nonexistent");
        });
        assertTrue(exception.getMessage().contains("Appointment does not exist"));
    }

    @Test
    void testUpdateAppointment() {
        Date newDate = new Date(System.currentTimeMillis() + 86400000); // 24 hours in the future
        assertDoesNotThrow(() -> service.updateAppointment("A12345", newDate, "Updated meeting with client"));
        Appointment appointment = service.getAppointmentById("A12345");
        assertAll("Validating updated appointment details",
                () -> assertEquals(newDate, appointment.getAppointmentDate()),
                () -> assertEquals("Updated meeting with client", appointment.getDescription())
        );
    }

    // Additional tests...
}
