package com.example.parlour_back.repository;

import com.example.parlour_back.entity.Beautician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BeauticianRepository extends JpaRepository<Beautician, Long> {
}