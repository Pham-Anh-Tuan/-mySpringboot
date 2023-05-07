package com.example.demo.repository;

import com.example.demo.dto.DetalServiceDTO;
import com.example.demo.model.DetalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalServiceRepository extends JpaRepository<DetalService, Long> {
    @Query("SELECT new com.example.demo.dto.DetalServiceDTO(d.id, d.name) FROM DetalService d")
    List<DetalServiceDTO> findAllDTO();
}
