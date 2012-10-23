package br.com.athat.core.manager.movimentacao.venda;

import br.com.athat.core.entity.movimentacao.venda.Venda;

import java.util.List;

public interface VendaManager {
    
    Venda salvar(Venda venda);
    
    List<Venda> buscarTodas(Venda venda);
    
}
