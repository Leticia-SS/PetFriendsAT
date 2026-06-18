package com.example.petfriends.transporte.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class EnderecoDestino {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

}
