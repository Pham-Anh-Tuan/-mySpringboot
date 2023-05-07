package com.example.demo.controller;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/schedules")
@CrossOrigin(origins="*")
public class ScheduleController {
    @Autowired
    private ScheduleService appointmentService;

    @GetMapping(path = "dateMeet/serviceId/{serviceId}/doctorId/{doctorId}")
    public List<String> getDateByServiceIdDoctorId(@PathVariable("serviceId") Long serviceId, @PathVariable("doctorId") Long doctorId) {
        return appointmentService.findDateByServiceIdDoctorId(serviceId, doctorId);
    }
    @GetMapping(path = "timeHM/serviceId/{serviceId}/doctorId/{doctorId}/date/{date}")
    public List<String> getTimeHMByServiceIdDoctorIdDate(@PathVariable("serviceId") Long serviceId, @PathVariable("doctorId") Long doctorId, @PathVariable("date") String date) {
        return appointmentService.findTimeHMByServiceIdDoctorIdDate(serviceId, doctorId, date);
    }

    @GetMapping(path = "schedule/serviceId/{serviceId}/doctorId/{doctorId}/date/{date}/timeHM/{timeHM}")
    public Schedule getByServiceIdDoctorIdDateTimeHM(@PathVariable("serviceId") Long serviceId, @PathVariable("doctorId") Long doctorId, @PathVariable("date") String date, @PathVariable("timeHM") String timeHM) {
        return appointmentService.findByServiceIdDoctorIdDateTimeHM(serviceId, doctorId, date, timeHM);
    }
}
