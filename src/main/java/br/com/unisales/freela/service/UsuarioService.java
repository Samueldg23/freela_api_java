package br.com.unisales.freela.service;

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
        repo.save(usuarioNovo);
    }
}
