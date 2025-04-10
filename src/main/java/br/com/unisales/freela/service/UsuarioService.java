package br.com.unisales.freela.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.dto.UsuarioDTO;
import br.com.unisales.freela.model.Usuario;
import br.com.unisales.freela.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public UsuarioDTO cadastrarUsuario (UsuarioDTO usuario) {
        Usuario usuarioNovo = new Usuario();
        usuarioNovo.setNome(usuario.getNome());
        usuarioNovo.setEmail(usuario.getEmail());
        usuarioNovo.setTelefone(usuario.getTelefone());
        usuarioNovo.setFotoPerfil(usuario.getFotoPerfil());
        usuarioNovo.setCpf(usuario.getCpf());
        usuarioNovo.setTipoUsuario(Usuario.TipoUsuario.valueOf(usuario.getTipoUsuario()));

        usuarioNovo= repo.save(usuarioNovo);
        return converterParaDTO(usuarioNovo);
    }
    public UsuarioDTO converterParaDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setTelefone(usuario.getTelefone());
        usuarioDTO.setFotoPerfil(usuario.getFotoPerfil());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setTipoUsuario(usuario.getTipoUsuario().name());

        return usuarioDTO;
    }
    public UsuarioDTO buscarPorEmail (String email) {
        Optional<Usuario> usuario = Optional.ofNullable(repo.findByEmail(email));
        if (usuario.isPresent()) {
            return converterParaDTO(usuario.get());
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }

    public UsuarioDTO buscarPorId (Long id) {
        Optional<Usuario> usuario = repo.findById(id);
        if (usuario.isPresent()) {
            return converterParaDTO(usuario.get());
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }
    public UsuarioDTO atualizarUsuario (UsuarioDTO usuario) {
        Optional<Usuario> usuarioExistente = repo.findById(usuario.getId());
        if (usuarioExistente.isPresent()) {
            Usuario usuarioNovo = usuarioExistente.get();
            usuarioNovo.setNome(usuario.getNome());
            usuarioNovo.setEmail(usuario.getEmail());
            usuarioNovo.setTelefone(usuario.getTelefone());
            usuarioNovo.setFotoPerfil(usuario.getFotoPerfil());
            usuarioNovo.setCpf(usuario.getCpf());
            usuarioNovo.setTipoUsuario(Usuario.TipoUsuario.valueOf(usuario.getTipoUsuario()));

            usuarioNovo= repo.save(usuarioNovo);
            return converterParaDTO(usuarioNovo);
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }
    public void deletarUsuario (Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }
    public List<UsuarioDTO> listarUsuarios() {
        return repo.findAll().stream()
                .map(this::converterParaDTO) 
                .collect(Collectors.toList());
    }
}
