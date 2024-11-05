package br.com.alura.codechella.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Endereco {
    private String cep;
    private String numero;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String cep, String numero, String complemento) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }



}
