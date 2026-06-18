package com.example.petfriends.transporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.petfriends.transporte.model.OrdemTransporte;

public interface IOrdemTransporteRepository extends JpaRepository<OrdemTransporte, Long> {
}
