package com.example.parlour_back.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parlour_servicePojo {

    private Long barberServiceId;
    private String status;
    private Long barberId;
    private Long serviceId;
    private Long appointmentId;

    // Constructors can be added if necessary, but lombok may handle them implicitly
}