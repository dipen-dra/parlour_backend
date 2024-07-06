package com.example.parlour_back.service.impl;

import com.example.parlour_back.entity.Beautician;
import com.example.parlour_back.pojo.BeauticianPojo;
import com.example.parlour_back.repository.BeauticianRepository;
import com.example.parlour_back.service.BeauticianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeauticianServiceImpl implements BeauticianService {

    private final BeauticianRepository beauticianRepository;

    @Override
    public Beautician createBeautician(BeauticianPojo beauticianPojo) {
        Beautician beautician = new Beautician();
        beautician.setFullName(beauticianPojo.getFullName());
        beautician.setEmail(beauticianPojo.getEmail());
        beautician.setPhoneNumber(beauticianPojo.getPhone());
        beautician.setPassword(beauticianPojo.getPassword());
        return beauticianRepository.save(beautician);
    }

    @Override
    public Beautician getBeautician(BeauticianPojo beauticianPojo) {
        Beautician beautician = new Beautician();
        beautician.setFullName(beauticianPojo.getFullName());
        beautician.setEmail(beauticianPojo.getEmail());
        beautician.setPhoneNumber(beauticianPojo.getPhone());
        beautician.setPassword(beauticianPojo.getPassword());
        return beautician;
    }

    @Override
    public List<Beautician> getAllBeauticians() {
        return beauticianRepository.findAll();
    }

    @Override
    public Beautician getBeauticianById(Long beauticianId) {
        Optional<Beautician> optionalBeautician = beauticianRepository.findById(beauticianId);
        return optionalBeautician.orElse(null); // Handle optional if necessary
    }

    @Override
    public Beautician updateBeauticianById(Long beauticianId, BeauticianPojo beauticianPojo) {
        Optional<Beautician> optionalBeautician = beauticianRepository.findById(beauticianId);
        if (optionalBeautician.isPresent()) {
            Beautician beautician = optionalBeautician.get();
            beautician.setFullName(beauticianPojo.getFullName());
            beautician.setEmail(beauticianPojo.getEmail());
            beautician.setPhoneNumber(beauticianPojo.getPhone());
            beautician.setPassword(beauticianPojo.getPassword());
            return beauticianRepository.save(beautician);
        }
        return null; // Handle not found scenario appropriately
    }

    @Override
    public void deleteBeauticianById(Long beauticianId) {
        beauticianRepository.deleteById(beauticianId);
    }
}
