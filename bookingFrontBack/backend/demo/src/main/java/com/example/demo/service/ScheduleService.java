package com.example.demo.service;

import com.example.demo.model.Schedule;
import java.util.List;

public interface ScheduleService {
    public List<String> findDateByServiceIdDoctorId(Long serviceId, Long doctorId);
    public List<String> findTimeHMByServiceIdDoctorIdDate(Long serviceId, Long doctorId, String date);
    public Schedule findByServiceIdDoctorIdDateTimeHM(Long serviceId, Long doctorId, String date, String timeHM);
}
