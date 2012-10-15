package br.com.athat.core.movimentacao.venda.manager;

import br.com.athat.core.movimentacao.venda.entity.Venda;
import java.util.List;

public interface VendaManager {
    
    Venda salvar(Venda venda);
    
    List<Venda> buscarTodas(Venda venda);
    
}
