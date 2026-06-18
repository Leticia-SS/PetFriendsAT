package com.example.petfriends.transporte.model;

import jakarta.persistence.*;
import com.example.petfriends.transporte.model.enums.StatusEntregaEnum;

import java.time.LocalDateTime;

@Entity
@Table(name = "ordem_transporte")
public class OrdemTransporte {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long pedidoId;
    @Column(nullable = false, unique = true)
    private String codigoRastreio;
    @Enumerated(EnumType.STRING)
    private StatusEntregaEnum status;
    @Embedded
    private EnderecoDestino endereco;
    private LocalDateTime dataPrevisaoEntrega;

}
