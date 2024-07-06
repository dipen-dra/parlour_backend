package com.example.parlour_back.service;

import com.example.parlour_back.entity.Beautician;
import com.example.parlour_back.pojo.BeauticianPojo;

import java.util.List;

public interface BeauticianService {

    Beautician createBeautician(BeauticianPojo beauticianPojo);

    Beautician getBeautician(BeauticianPojo beauticianPojo);

    List<Beautician> getAllBeauticians();

    Beautician getBeauticianById(Long beauticianId);

    Beautician updateBeauticianById(Long beauticianId, BeauticianPojo beauticianPojo);

    void deleteBeauticianById(Long beauticianId);
}
