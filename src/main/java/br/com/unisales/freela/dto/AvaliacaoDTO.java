package br.com.unisales.freela.dto;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDTO {
    private Long id;
    private String comentario;
    private int nota;
    private Long id_pedido;
    private Long id_cliente;
    private LocalDateTime data_avaliacao;
}
