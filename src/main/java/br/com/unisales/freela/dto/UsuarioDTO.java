package br.com.unisales.freela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String fotoPerfil;
    private String cpf;
    private String tipoUsuario;
}
