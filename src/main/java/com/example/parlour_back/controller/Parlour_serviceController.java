package com.example.parlour_back.controller;

import com.example.parlour_back.entity.Parlour_service;
import com.example.parlour_back.pojo.Parlour_servicePojo;
import com.example.parlour_back.service.Parlour_serviceService;
import com.example.parlour_back.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/parlour_services")
@RequiredArgsConstructor
public class Parlour_serviceController {

    private final Parlour_serviceService parlourServiceService;

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Parlour_service>> createParlourService(@RequestBody Parlour_servicePojo parlour_servicePojo) {
        Parlour_service parlourService = parlourServiceService.createParlourService(parlour_servicePojo);
        GlobalApiResponse<Parlour_service> response = new GlobalApiResponse<>("Successfully added", 200, parlourService);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Parlour_service>>> getAllParlourServices() {
        List<Parlour_service> parlourServices = parlourServiceService.getAllParlourServices();
        GlobalApiResponse<List<Parlour_service>> response = new GlobalApiResponse<>("Parlour services retrieved successfully", 200, parlourServices);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Parlour_service>> getParlourServiceById(@PathVariable("id") Long parlour_service_id) {
        Optional<Parlour_service> parlourService = parlourServiceService.getParlourServiceById(parlour_service_id);
        if (parlourService.isEmpty()) {
            GlobalApiResponse<Parlour_service> response = GlobalApiResponse.<Parlour_service>builder()
                    .message("Parlour service not found with id " + parlour_service_id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Parlour_service> response = GlobalApiResponse.<Parlour_service>builder()
                .message("Parlour service retrieved successfully")
                .statusCode(HttpStatus.OK.value())
                .data(parlourService.get())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Parlour_service>> updateParlourServiceById(@PathVariable("id") Long parlour_service_id, @RequestBody Parlour_servicePojo parlour_servicePojo) {
        Parlour_service updatedParlourService = parlourServiceService.updateParlourServiceById(parlour_service_id, parlour_servicePojo);
        if (updatedParlourService == null) {
            GlobalApiResponse<Parlour_service> response = GlobalApiResponse.<Parlour_service>builder()
                    .message("Parlour service not found with id " + parlour_service_id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Parlour_service> response = GlobalApiResponse.<Parlour_service>builder()
                .message("Parlour service updated successfully")
                .statusCode(HttpStatus.OK.value())
                .data(updatedParlourService)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteParlourServiceById(@PathVariable("id") Long parlour_service_id) {
        parlourServiceService.deleteParlourServiceById(parlour_service_id);
        GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                .message("Parlour service deleted successfully")
                .statusCode(HttpStatus.NO_CONTENT.value())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
