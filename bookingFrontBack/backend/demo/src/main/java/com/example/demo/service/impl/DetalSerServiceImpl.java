package com.example.demo.service.impl;

import com.example.demo.dto.DetalServiceDTO;
import com.example.demo.repository.DetalServiceRepository;
import com.example.demo.service.DetalSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalSerServiceImpl implements DetalSerService {
    @Autowired
    private DetalServiceRepository detalServiceRepository;
    @Override
    public List<DetalServiceDTO> findAllDetalServiceDTO() {
        return detalServiceRepository.findAllDTO();
    }
}
