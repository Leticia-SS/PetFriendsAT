package com.example.petfriends.almoxarifado.repository;

import com.example.petfriends.almoxarifado.model.ReservaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaEstoqueRepository extends JpaRepository<ReservaEstoque, Long> {
}
