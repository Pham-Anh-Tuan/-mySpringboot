package com.example.demo.repository;

import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT DISTINCT a.doctor FROM Schedule a WHERE a.detalService.id =?1")
    public List<Doctor> findAllDoctorByServiceId(Long serviceId);
}
