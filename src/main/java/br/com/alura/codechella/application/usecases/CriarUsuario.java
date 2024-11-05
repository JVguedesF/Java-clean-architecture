package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.domain.entities.usuario.*;
import br.com.alura.codechella.application.gateways.UserRepositories;
import org.springframework.stereotype.Service;


public class CriarUsuario {

        private final UserRepositories repository;

        public CriarUsuario(UserRepositories repository) {
            this.repository = repository;
        }

        public Usuario cadastrarUsuario(Usuario usuario) {
            return repository.cadastrarUsuario(usuario);
        }

}
