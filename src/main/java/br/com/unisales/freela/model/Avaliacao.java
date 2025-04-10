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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;
    @Column(name = "comentario", nullable = false, length = 500)
    private String comentario;
    @Column(name = "nota", nullable = false)
    private int nota;
    @Column(name = "id_pedido", nullable = false)
    private Pedido pedido;
    @Column(name = "data_avaliacao", nullable = false)
    private LocalDateTime dataAvaliacao;
}
