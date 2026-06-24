package com.example.petfriends.transporte.repository;

import com.example.petfriends.transporte.model.OrdemTransporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOrdemTransporteRepository extends JpaRepository<OrdemTransporte, Long> {
    Optional<OrdemTransporte> findByPedidoId(Long pedidoId);


}