package br.com.unisales.freela.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;
    @Column(name = "id_servico", nullable = false)
    private Servico servico;
    @Column(name = "id_cliente", nullable = false)
    private Usuario cliente;
    @Column(name = "id_prestador", nullable = false)
    private Usuario prestador;
    @Column(name = "status", nullable = false, length = 20)
    private Status status;
    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;
    @Column(name = "data_conclusao", nullable = true)
    private LocalDateTime dataConclusao;
    @Column(name = "id_avaliacao", nullable = true)
    private Avaliacao avaliacao;

    public enum Status {
        PENDENTE,
        ACEITO,
        EM_ANDAMENTO,
        FINALIZADO,
        REJEITADO,
        CANCELADO
    }
    
}
