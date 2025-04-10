package br.com.unisales.freela.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.dto.ServicoDTO;
import br.com.unisales.freela.model.Servico;
import br.com.unisales.freela.repository.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repo;

    public ServicoDTO cadastrarServico (ServicoDTO servico) {
        Servico servicoNovo = new Servico();
        servicoNovo.setNome(servico.getNome());
        servicoNovo.setDescricao(servico.getDescricao());
        servicoNovo.setCategoria(Servico.Categoria.valueOf(servico.getCategoria()));
        servicoNovo.setValor(servico.getValor());
        servicoNovo.setId_prestador(servico.getId_prestador());

        servicoNovo = repo.save(servicoNovo);
        return converterParaDTO(servicoNovo);
    }
    public ServicoDTO converterParaDTO(Servico servico) {
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setId(servico.getId());
        servicoDTO.setNome(servico.getNome());
        servicoDTO.setDescricao(servico.getDescricao());
        servicoDTO.setCategoria(servico.getCategoria().name());
        servicoDTO.setValor(servico.getValor());
        servicoDTO.setId_prestador(servico.getId_prestador());

        return servicoDTO;
    }
    public ServicoDTO buscarPorId (Long id) {
        Servico servico = repo.findById(id).orElseThrow(() -> new RuntimeException("Servico não encontrado!"));
        return converterParaDTO(servico);
    }
    public ServicoDTO atualizarServico (ServicoDTO servico) {
        Servico servicoAtualizado = repo.findById(servico.getId()).orElseThrow(() -> new RuntimeException("Servico não encontrado!"));
        servicoAtualizado.setNome(servico.getNome());
        servicoAtualizado.setDescricao(servico.getDescricao());
        servicoAtualizado.setCategoria(Servico.Categoria.valueOf(servico.getCategoria()));
        servicoAtualizado.setValor(servico.getValor());
        servicoAtualizado.setId_prestador(servico.getId_prestador());

        return converterParaDTO(repo.save(servicoAtualizado));
    }
    public void deletarServico (Long id) {
        Servico servico = repo.findById(id).orElseThrow(() -> new RuntimeException("Servico não encontrado!"));
        repo.delete(servico);
    }

    public List<ServicoDTO> listarServicos() {
        return repo.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    public List<ServicoDTO> listarServicosPorPrestador(Long idPrestador) {
        return repo.findById_prestador(idPrestador).stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    public List<ServicoDTO> listarServicosPorCategoria(Servico.Categoria categoria) {
        return repo.findByCategoria(categoria).stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    public List<ServicoDTO> listarServicosPorNome(String nome) {
        return repo.findByNomeContainingIgnoreCase(nome).stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    
}