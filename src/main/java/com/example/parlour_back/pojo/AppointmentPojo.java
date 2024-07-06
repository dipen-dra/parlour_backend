package com.example.parlour_back.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppointmentPojo {

    private Long appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Long customerId;


}