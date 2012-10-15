package br.com.athat.test.movimentacao.venda;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.cadastro.pessoa.cliente.entity.Cliente;
import br.com.athat.core.cadastro.pessoa.entity.endereco.Cidade;
import br.com.athat.core.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.movimentacao.venda.entity.Venda;
import br.com.athat.core.movimentacao.venda.manager.VendaManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class VendaManagerTest extends AbstractTest{
    
    private Cliente cliente;
    private Cidade cidade;
    
    @Autowired
    private VendaManager vendaManager;
    
    @Before
    public void before(){
        cidade = PopulateBD.populateCidade(entityManager);
        cliente = PopulateBD.populateCliente(entityManager, cidade);
    }
    
    @Test
    public void salvar(){
        Venda venda = new Venda();
        venda.setCliente(cliente);
    }
  
    
}
