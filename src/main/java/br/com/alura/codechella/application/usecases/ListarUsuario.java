package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepositories;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuario {

    private final UserRepositories repository;

    public ListarUsuario(UserRepositories repository) {
        this.repository = repository;
    }

    public List<Usuario> ObterTodosOsUsuarios() {
        return this.repository.listarTodos();
    }
}
