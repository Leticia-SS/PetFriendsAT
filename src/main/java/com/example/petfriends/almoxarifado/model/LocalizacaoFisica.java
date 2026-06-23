package com.example.petfriends.almoxarifado.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class LocalizacaoFisica {
    private String corredor;
    private String prateleira;
    private String posicao;

    public LocalizacaoFisica(String corredor, String prateleira, String posicao) {
        this.corredor = corredor;
        this.prateleira = prateleira;
        this.posicao = posicao;
    }

    protected LocalizacaoFisica() {

    }
}
