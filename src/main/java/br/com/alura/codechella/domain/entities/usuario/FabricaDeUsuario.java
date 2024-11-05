package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;
import java.time.LocalDate;

public class FabricaDeUsuario {
    private Usuario user;

    public Usuario criarUsuarioComNomeCpfNascimento(String cpf, String nome, LocalDate nascimento) {
        this.user = new Usuario(cpf, nome, nascimento, "");
        return this.user;
    }

    public Usuario criarUsuarioComNomeCpfNascimentoEmail(String cpf, String nome, LocalDate nascimento, String email) {
        this.user = new Usuario(cpf, nome, nascimento, email);
        return this.user;
    }

    public Usuario incluirEndereco(String cep, String numero, String complemento) {
        this.user.setEndereco(new Endereco(cep, numero, complemento));
        return this.user;
    }
}
