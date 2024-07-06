package com.example.parlour_back.controller;

import com.example.parlour_back.entity.Appointment;
import com.example.parlour_back.pojo.AppointmentPojo;
import com.example.parlour_back.service.AppointmentService;
import com.example.parlour_back.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appointments")
@RequiredArgsConstructor

public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Appointment>> createAppointment(@RequestBody AppointmentPojo appointmentPojo) {
        Appointment appointment = appointmentService.createAppointment(appointmentPojo);
        GlobalApiResponse<Appointment> response = new GlobalApiResponse<>("successfully added", 200, appointment);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Appointment>>> getAllAppointment() {
        List<Appointment> appointment = appointmentService.getAllAppointment();
        GlobalApiResponse<List<Appointment>> response = new GlobalApiResponse<>("appointment retrieved successfully",200,appointment);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Appointment>> getAppointmentById(@PathVariable("id") Long appointment_id) {
        Appointment appointment = appointmentService.getAppointmentById(appointment_id);
        if (appointment == null) {
            GlobalApiResponse<Appointment> response = GlobalApiResponse.<Appointment>builder()
                    .message("Appointment not found with id " + appointment_id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Appointment> response = GlobalApiResponse.<Appointment>builder()
                .message("Appointment retrieved successfully")
                .statusCode(HttpStatus.OK.value())
                .data(appointment)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Appointment>> updateAppointmentById(@PathVariable("id") Long appointment_id, @RequestBody AppointmentPojo appointmentPojo) {
        Appointment updatedAppointment = appointmentService.updateAppointmentById(appointment_id, appointmentPojo);
        if (updatedAppointment == null) {
            GlobalApiResponse<Appointment> response = GlobalApiResponse.<Appointment>builder()
                    .message("Appointment not found with id " + appointment_id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Appointment> response = GlobalApiResponse.<Appointment>builder()
                .message("Appointment updated successfully")
                .statusCode(HttpStatus.OK.value())
                .data(updatedAppointment)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
        GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                .message("appointment deleted successfully")
                .statusCode(HttpStatus.NO_CONTENT.value())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }





}