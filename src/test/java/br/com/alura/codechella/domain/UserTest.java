package br.com.alura.codechella.domain;

import br.com.alura.codechella.domain.entities.usuario.FabricaDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;



class UserTest {

    @Test
    @DisplayName("Testa se o cpf esta no formato válido")
    void testCpf() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(
                        "123456.789-10",
                        "Fulano",
                        LocalDate.parse("1999-08-01"),
                        "maria@gmail.com"));
    }

    @Test
    @DisplayName("deve criar um usuario com cpf, nome, nascimento usando a fabrica de usuarios")
    void testeFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.criarUsuarioComNomeCpfNascimento(
                "123.456.779-10",
                "karen",
                LocalDate.parse("2005-08-01"));
        Assertions.assertEquals( "karen", usuario.getNome());

        usuario = fabrica.incluirEndereco(
                "12345-678",
                "56",
                "casa");
        Assertions.assertEquals("12345-678", usuario.getEndereco().getCep());
    }
}

