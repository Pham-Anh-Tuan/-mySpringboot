package com.example.demo.controller;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "/serviceId/{id}")
    public List<Doctor> getAllDoctorByServiceId(@PathVariable("id") Long serviceId) {
        return doctorService.findAllDoctorByServiceId(serviceId);
    }
}
