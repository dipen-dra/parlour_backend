package com.example.parlour_back.service.impl;

import com.example.parlour_back.entity.Parlour_service;
import com.example.parlour_back.pojo.Parlour_servicePojo;
import com.example.parlour_back.repository.Parlour_serviceRepository;
import com.example.parlour_back.service.Parlour_serviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Parlour_serviceServiceImpl implements Parlour_serviceService {

    private final Parlour_serviceRepository parlourServiceRepository;

    @Override
    public List<Parlour_service> getAllParlourServices() {
        return parlourServiceRepository.findAll();
    }

    @Override
    public Optional<Parlour_service> getParlourServiceById(Long parlour_service_id) {
        return parlourServiceRepository.findById(parlour_service_id);
    }

    @Override
    public Parlour_service createParlourService(Parlour_servicePojo parlourServicePojo) {
        Parlour_service parlourService = new Parlour_service();
        // Set necessary fields from Parlour_servicePojo to Parlour_service
        parlourService.setStatus(parlourServicePojo.getStatus());
        // Add more fields if necessary
        return parlourServiceRepository.save(parlourService);
    }

    @Override
    public Parlour_service updateParlourServiceById(Long parlour_service_id, Parlour_servicePojo parlourServicePojo) {
        Optional<Parlour_service> optionalParlourService = parlourServiceRepository.findById(parlour_service_id);
        if (optionalParlourService.isPresent()) {
            Parlour_service parlourService = optionalParlourService.get();
            parlourService.setStatus(parlourServicePojo.getStatus());
            // Update more fields if necessary
            return parlourServiceRepository.save(parlourService);
        }
        return null; // Or throw an exception if the service with the given id is not found
    }

    @Override
    public void deleteParlourServiceById(Long parlour_service_id) {
        parlourServiceRepository.deleteById(parlour_service_id);
    }
}
