package com.example.parlour_back.service;

import com.example.parlour_back.entity.Parlour_service;
import com.example.parlour_back.pojo.Parlour_servicePojo;

import java.util.List;
import java.util.Optional;

public interface Parlour_serviceService {
    List<Parlour_service> getAllBarberService();
    Optional<Parlour_service> getBarberServiceById(Long barber_service_id);
    Parlour_service createBarberService(Parlour_servicePojo barberServicePojo);
    Parlour_service updateBarberServiceById(Long barber_service_id, Parlour_servicePojo barberServicePojo);
    void deleteBarberServiceById(Long barber_service_id);

}
