package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.UserRepositories;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryJPA extends UserRepositories {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;

    public UserRepositoryJPA(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioEntityMapper = usuarioEntityMapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioEntityMapper.toEntity(usuario);
        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuarioEntity);
        return usuarioEntityMapper.toDomain(usuarioSalvo);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuarioEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
