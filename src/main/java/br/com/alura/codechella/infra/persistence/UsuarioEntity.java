package br.com.alura.codechella.infra.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    public UsuarioEntity(String cpf, String nome, LocalDate nascimento, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public UsuarioEntity() {
    }
}
