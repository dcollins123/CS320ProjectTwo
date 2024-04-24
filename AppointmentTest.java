package com.dcollins.mobileapplication.test;

import com.dcollins.mobileapplication.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    private Appointment appointment;

    @BeforeEach
    public void setup() {
        appointment = new Appointment("A12345", new Date(), "Meeting with client");
    }

    @Test
    public void testAppointmentCreation() {
        assertEquals("Meeting with client", appointment.getDescription());
    }

    @Test
    public void testPastAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", new Date(System.currentTimeMillis() - 10000), "Meeting with client");
        });
    }
}
