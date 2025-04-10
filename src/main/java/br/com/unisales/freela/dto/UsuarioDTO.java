package br.com.unisales.freela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String fotoPerfil;
    private String cpf;
    private String tipoUsuario;
}
