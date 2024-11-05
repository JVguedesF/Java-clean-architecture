package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuario listarUsuario;


    public UsuarioController(CriarUsuario criarUsuario, ListarUsuario listarUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuario = listarUsuario;
    }


    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(),
                dto.email()));

        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());

    }

    @GetMapping
    public List<UsuarioDto> listarTodos() {
        return listarUsuario.ObterTodosOsUsuarios().stream()
                .map(usuario -> new UsuarioDto(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(),
                        usuario.getEmail()))
                .toList();
    }

}
