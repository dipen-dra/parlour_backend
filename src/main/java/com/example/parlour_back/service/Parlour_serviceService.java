package com.example.parlour_back.service;

import com.example.parlour_back.entity.Parlour_service;
import com.example.parlour_back.pojo.Parlour_servicePojo;

import java.util.List;
import java.util.Optional;

public interface Parlour_serviceService {
    List<Parlour_service> getAllParlourServices();
    Optional<Parlour_service> getParlourServiceById(Long parlour_service_id);
    Parlour_service createParlourService(Parlour_servicePojo parlourServicePojo);
    Parlour_service updateParlourServiceById(Long parlour_service_id, Parlour_servicePojo parlourServicePojo);
    void deleteParlourServiceById(Long parlour_service_id);
}
