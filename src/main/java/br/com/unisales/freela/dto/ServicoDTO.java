package br.com.unisales.freela.dto;

import java.math.BigDecimal;

import br.com.unisales.freela.model.Usuario;
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
    private BigDecimal valor;
    private Usuario id_prestador;
}
