package com.example.parlour_back.service.impl;

import com.example.parlour_back.entity.Appointment;
import com.example.parlour_back.pojo.AppointmentPojo;
import com.example.parlour_back.repository.AppointmentRepository;
import com.example.parlour_back.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(AppointmentPojo appointmentPojo) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentTime(appointmentPojo.getAppointmentTime());
        appointment.setAppointmentDate(appointmentPojo.getAppointmentDate());
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long appointment_id) {
        if(appointmentRepository.findById(appointment_id).isPresent()){
            return appointmentRepository.findById(appointment_id).get();
        }else{
            return null;
        }

    }

    @Override
    public Appointment updateAppointmentById(Long appointment_id, AppointmentPojo appointmentPojo) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointment_id);
        if(appointment.isPresent()){
            Appointment appointment1 = appointment.get();
            appointment1.setAppointmentTime(appointmentPojo.getAppointmentTime());
            appointment1.setAppointmentDate(appointmentPojo.getAppointmentDate());
            appointmentRepository.save(appointment1);
            return appointment1;

        }else{
            return null;
        }


    }

    @Override
    public void deleteAppointmentById(Long appointment_id) {
        appointmentRepository.deleteById(appointment_id);

    }
}