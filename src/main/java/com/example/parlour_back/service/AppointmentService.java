package com.example.parlour_back.service;


import com.example.parlour_back.entity.Appointment;
import com.example.parlour_back.pojo.AppointmentPojo;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(AppointmentPojo appointmentPojo);
    List<Appointment> getAllAppointment();
    Appointment getAppointmentById(Long appointment_id);
    Appointment updateAppointmentById(Long appointment_id,AppointmentPojo appointmentPojo);
    void deleteAppointmentById(Long appointment_id);



}