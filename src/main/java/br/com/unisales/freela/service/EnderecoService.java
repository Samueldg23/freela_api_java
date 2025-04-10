package br.com.unisales.freela.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.dto.EnderecoDTO;
import br.com.unisales.freela.model.Endereco;
import br.com.unisales.freela.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repo;

    public EnderecoDTO cadastrarEndereco(EnderecoDTO endereco) {
        Endereco enderecoNovo = new Endereco();
        enderecoNovo.setRua(endereco.getRua());
        enderecoNovo.setNumero(endereco.getNumero());
        enderecoNovo.setBairro(endereco.getBairro());
        enderecoNovo.setCidade(endereco.getCidade());
        enderecoNovo.setEstado(endereco.getEstado());
        enderecoNovo.setCep(endereco.getCep());

        enderecoNovo = repo.save(enderecoNovo);
        return converterParaDTO(enderecoNovo);
    }
    public EnderecoDTO converterParaDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(endereco.getId());
        enderecoDTO.setRua(endereco.getRua());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setCep(endereco.getCep());

        return enderecoDTO;
    }
    public EnderecoDTO buscarPorId(Long id) {
        Optional<Endereco> enderecoOpt = repo.findById(id);
        if (enderecoOpt.isPresent()) {
            return converterParaDTO(enderecoOpt.get());
        } else {
            throw new RuntimeException("Endereco não encontrado!");
        }
    }
    public EnderecoDTO atualizarEndereco(EnderecoDTO endereco) {
        Optional<Endereco> enderecoOpt = repo.findById(endereco.getId());
        if (enderecoOpt.isPresent()) {
            Endereco enderecoAtualizado = enderecoOpt.get();
            enderecoAtualizado.setRua(endereco.getRua());
            enderecoAtualizado.setNumero(endereco.getNumero());
            enderecoAtualizado.setBairro(endereco.getBairro());
            enderecoAtualizado.setCidade(endereco.getCidade());
            enderecoAtualizado.setEstado(endereco.getEstado());
            enderecoAtualizado.setCep(endereco.getCep());

            return converterParaDTO(repo.save(enderecoAtualizado));
        } else {
            throw new RuntimeException("Endereco não encontrado!");
        }
    }
    public void deletarEndereco(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Endereco não encontrado!");
        }
    }
    
}
