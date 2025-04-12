package br.com.unisales.freela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.dto.AvaliacaoDTO;
import br.com.unisales.freela.model.Avaliacao;
import br.com.unisales.freela.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    public AvaliacaoRepository repo;

    public AvaliacaoDTO cadastrarAvaliacao (AvaliacaoDTO avaliacao) {
        Avaliacao avaliacaoNovo = new Avaliacao();
        avaliacaoNovo.setComentario(avaliacao.getComentario());
        avaliacaoNovo.setNota(avaliacao.getNota());
        avaliacaoNovo.setPedido(null);       

        avaliacaoNovo = repo.save(avaliacaoNovo);
        return converterParaDTO(avaliacaoNovo);
    }
    public AvaliacaoDTO converterParaDTO(AvaliacaoDTO avaliacao) {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setId(avaliacao.getId());
        avaliacaoDTO.setId_avaliador(avaliacao.getId_avaliador());
        avaliacaoDTO.setId_avaliado(avaliacao.getId_avaliado());
        avaliacaoDTO.setNota(avaliacao.getNota());
        avaliacaoDTO.setComentario(avaliacao.getComentario());

        return avaliacaoDTO;
    }
    public AvaliacaoDTO converterParaDTO(Avaliacao avaliacao) {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setId(avaliacao.getId());
        avaliacaoDTO.setId_avaliador(avaliacao.getId_avaliador());
        avaliacaoDTO.setId_avaliado(avaliacao.getId_avaliado());
        avaliacaoDTO.setNota(avaliacao.getNota());
        avaliacaoDTO.setComentario(avaliacao.getComentario());

        return avaliacaoDTO;
}
