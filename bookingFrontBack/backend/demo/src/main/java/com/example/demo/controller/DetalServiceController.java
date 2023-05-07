package com.example.demo.controller;
import com.example.demo.dto.DetalServiceDTO;
import com.example.demo.model.Doctor;
import com.example.demo.service.DetalSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detalservices")
@CrossOrigin
public class DetalServiceController {
    @Autowired
    private DetalSerService detalSerService;

    @GetMapping(path = "/dto")
    public List<DetalServiceDTO> getAllDetalServiceDTO() {
        return detalSerService.findAllDetalServiceDTO();
    }

}
