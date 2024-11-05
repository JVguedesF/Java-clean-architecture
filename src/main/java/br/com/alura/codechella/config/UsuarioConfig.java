package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserRepositories;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuario;
import br.com.alura.codechella.infra.gateways.UserRepositoryJPA;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(UserRepositories userRepositories) {
        return new CriarUsuario(userRepositories);
    }

    @Bean
    ListarUsuario listarUsuario(UserRepositories userRepositories) {
        return new ListarUsuario(userRepositories);
    }

    @Bean
    UserRepositoryJPA userRepositoryJPA(UsuarioRepository repositories, UsuarioEntityMapper mapper) {
        return new UserRepositoryJPA(repositories , mapper);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }
}
