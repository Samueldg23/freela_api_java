package br.com.unisales.freela.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.freela.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByCategoria(Servico.Categoria categoria);

    List<Servico> findByNomeContainingIgnoreCase(String nome); // Busca por nome do serviço

    Optional<Servico> findById_prestador(Long idPrestador);
}