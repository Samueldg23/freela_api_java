package br.com.unisales.freela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
    private String valor;
    private Long id_prestador;
}
