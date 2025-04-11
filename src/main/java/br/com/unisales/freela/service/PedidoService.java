package br.com.unisales.freela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.dto.PedidoDTO;
import br.com.unisales.freela.model.Pedido;
import br.com.unisales.freela.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    public PedidoRepository repo;

    public PedidoDTO cadastrarPedido (PedidoDTO pedido) {
        PedidoDTO pedidoNovo = new PedidoDTO();
        pedidoNovo.setId_servico(pedido.getId_servico());
        pedidoNovo.setId_cliente(pedido.getId_cliente());
        pedidoNovo.setId_prestador(pedido.getId_prestador());
        pedidoNovo.setStatus(pedido.getStatus());
        pedidoNovo.setData_conclusao(pedido.getData_conclusao());
        pedidoNovo.setData_pedido(pedido.getData_pedido());
        pedidoNovo.setId_avaliacao(pedido.getId_avaliacao());

        pedidoNovo = repo.save(pedidoNovo);
        return converterParaDTO(pedidoNovo);
    }
    public PedidoDTO converterParaDTO(PedidoDTO pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setId_servico(pedido.getId_servico());
        pedidoDTO.setId_cliente(pedido.getId_cliente());
        pedidoDTO.setId_prestador(pedido.getId_prestador());
        pedidoDTO.setStatus(pedido.getStatus());
        pedidoDTO.setData_conclusao(pedido.getData_conclusao());
        pedidoDTO.setData_pedido(pedido.getData_pedido());
        pedidoDTO.setId_avaliacao(pedido.getId_avaliacao());

        return pedidoDTO;
    }
    public PedidoDTO buscarPedidoPorId(Long id) {
        PedidoDTO pedido = repo.findById(id).orElse(null);
        return converterParaDTO(pedido);
    }
    public void deletarPedido(Long id) {
        Pedido pedido = repo.findById(id).orElse(null);
        if (pedido != null) {
            repo.delete(pedido);
        } else {
            throw new RuntimeException("Pedido não encontrado");
        }
    }
}
