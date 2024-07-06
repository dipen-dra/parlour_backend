package com.example.parlour_back.controller;

import com.example.parlour_back.entity.Beautician;
import com.example.parlour_back.pojo.BeauticianPojo;
import com.example.parlour_back.service.BeauticianService;
import com.example.parlour_back.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beauticians")
@RequiredArgsConstructor
public class BeauticianController {

    private final BeauticianService beauticianService;

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Beautician>> createBeautician(@RequestBody BeauticianPojo beauticianPojo) {
        Beautician beautician = beauticianService.createBeautician(beauticianPojo);
        GlobalApiResponse<Beautician> response = new GlobalApiResponse<>("Beautician created successfully", HttpStatus.CREATED.value(), beautician);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Beautician>>> getAllBeauticians() {
        List<Beautician> beauticians = beauticianService.getAllBeauticians();
        GlobalApiResponse<List<Beautician>> response = new GlobalApiResponse<>("All beauticians retrieved successfully", HttpStatus.OK.value(), beauticians);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Beautician>> getBeauticianById(@PathVariable("id") Long beauticianId) {
        Beautician beautician = beauticianService.getBeauticianById(beauticianId);
        if (beautician == null) {
            return ResponseEntity.notFound().build();
        }
        GlobalApiResponse<Beautician> response = new GlobalApiResponse<>("Beautician retrieved successfully", HttpStatus.OK.value(), beautician);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Beautician>> updateBeauticianById(@PathVariable("id") Long beauticianId, @RequestBody BeauticianPojo beauticianPojo) {
        Beautician updatedBeautician = beauticianService.updateBeauticianById(beauticianId, beauticianPojo);
        if (updatedBeautician == null) {
            return ResponseEntity.notFound().build();
        }
        GlobalApiResponse<Beautician> response = new GlobalApiResponse<>("Beautician updated successfully", HttpStatus.OK.value(), updatedBeautician);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteBeauticianById(@PathVariable Long id) {
        beauticianService.deleteBeauticianById(id);
        GlobalApiResponse<Void> response = new GlobalApiResponse<>("Beautician deleted successfully", HttpStatus.NO_CONTENT.value(), null);
        return ResponseEntity.ok(response);
    }
}
