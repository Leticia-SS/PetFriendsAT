package com.example.petfriends.almoxarifado.repository;

import com.example.petfriends.almoxarifado.model.ReservaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IReservaEstoqueRepository extends JpaRepository<ReservaEstoque, Long> {
    Optional<ReservaEstoque> findByPedidoId(Long pedidoId);


}