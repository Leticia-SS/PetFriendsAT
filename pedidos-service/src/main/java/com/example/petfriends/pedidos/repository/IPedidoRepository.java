package com.example.petfriends.pedidos.repository;

import com.example.petfriends.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<Pedido, Long> {
}