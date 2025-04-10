package br.com.unisales.freela.model;

import java.math.BigDecimal;

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
@Table(name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;
    @Column(name = "nome", nullable = false, length = 155)
    private String nome;
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    @Column(name = "categoria", nullable = false, length = 155)
    private Categoria categoria;
    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    @Column(name = "id_prestador", nullable = false)
    private Usuario id_prestador;

    public enum Categoria {
        ELETRICISTA,
        ENCANADOR,
        PEDREIRO,
        PINTOR,
        MONTADOR_MOVEIS,
        TECNICO_REFRIGERACAO,
        REPAROS_ELETRONICOS,
        JARDINAGEM,
        DETETIZACAO,
        MECANICO,
        MOTORISTA,
        FUNILARIA_PINTURA,
        LAVAGEM_CARROS,
        CHAVEIRO,
        CABELEIREIRO,
        BARBEIRO,
        MANICURE_PEDICURE,
        TRANCISTA,
        MAQUIADOR,
        DESIGNER_SOBRANCELHAS,
        DEPILACAO,
        MASSAGISTA,
        PERSONAL_TRAINER,
        DIARISTA,
        COZINHEIRO,
        BABA,
        CUIDADOR_IDOSOS,
        SUPORTE_TECNICO,
        DESENVOLVIMENTO_SITES
    }
}
