package br.com.unisales.freela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private Long id_servico;
    private Long id_cliente;
    private Long id_prestador;
    private String status;
    private String data_pedido;
    private String data_conclusao;
    private Long id_avaliacao;
}
