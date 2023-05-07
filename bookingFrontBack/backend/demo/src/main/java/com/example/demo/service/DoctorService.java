package com.example.demo.service;

import com.example.demo.model.Doctor;

import java.util.List;

public interface DoctorService {
    public List<Doctor> findAllDoctorByServiceId(Long serviceId);
}
