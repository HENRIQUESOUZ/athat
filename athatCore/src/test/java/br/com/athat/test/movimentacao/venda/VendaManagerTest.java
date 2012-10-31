package br.com.athat.test.movimentacao.venda;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.venda.Venda;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
import br.com.athat.core.entity.pessoa.endereco.Cidade;
import br.com.athat.core.manager.movimentacao.venda.VendaManager;

import org.junit.Before;
import org.junit.Ignore;
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
    @Ignore
    @Test
    public void salvar(){
        Venda venda = new Venda();
        venda.setCliente(cliente);
    }
  
    
}
