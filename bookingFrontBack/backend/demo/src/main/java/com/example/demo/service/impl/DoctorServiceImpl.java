package com.example.demo.service.impl;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAllDoctorByServiceId(Long serviceId) {
        return doctorRepository.findAllDoctorByServiceId(serviceId);
    }
}
