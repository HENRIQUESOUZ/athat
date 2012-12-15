package br.com.athat.core.manager.movimentacao.venda;

import java.util.List;

import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.entity.movimentacao.venda.Venda;
import br.com.athat.core.manager.AbstractManager;

public interface VendaManager extends AbstractManager {
    
    Venda salvar(Venda venda);
    
    List<Venda> buscarTodas(Venda venda);
    
    void salvarPedidoVenda(Orcamento pedidoVenda);
    
}
