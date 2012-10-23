package br.com.athat.test.pessoa.fornecedor;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.endereco.Cidade;
import br.com.athat.core.entity.pessoa.enuns.FornecedorType;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.core.manager.pessoa.fornecedor.FornecedorManager;

public class FornecedorManagerTest extends AbstractTest {
	
private Cidade cidade;
	
    @Autowired
    private FornecedorManager fornecedorManager;
    
    @Before
    public void before(){
    	cidade = PopulateBD.populateCidade(entityManager);
    }
    	
    @Test
    public void save(){
        Fornecedor fornecedor = Populate.populateFornecedor(cidade);
        
        fornecedorManager.salvar(fornecedor);
        
        Assert.assertNotNull(fornecedor);
        Assert.assertEquals(1, find(Fornecedor.class).size());
    }
    
    @Test
    public void buscar(){
    	populate();
    	Fornecedor fornecedor = new Fornecedor();
    	fornecedor.setPessoa(new Pessoa());
    	
    	Assert.assertEquals(3, fornecedorManager.buscarTodos(fornecedor).size());
    	
    	fornecedor.getPessoa().setNomeRazao("Jose");
    	fornecedor.getPessoa().setCpfCnpj("");
    	Assert.assertEquals(1, fornecedorManager.buscarTodos(fornecedor).size());
    	
    	fornecedor.getPessoa().setNomeRazao("");
    	fornecedor.getPessoa().setCpfCnpj("999999");
    	Assert.assertEquals(1, fornecedorManager.buscarTodos(fornecedor).size());
    	
    	fornecedor.getPessoa().setNomeRazao("");
    	fornecedor.getPessoa().setCpfCnpj("");
    	fornecedor.setFornecedorType(FornecedorType.INFORMATICA);
    	Assert.assertEquals(1, fornecedorManager.buscarTodos(fornecedor).size());
    }
    
    private void populate(){
    	Fornecedor fornecedor1 = new Fornecedor();
    	fornecedor1 = Populate.populateFornecedor(cidade);
    	fornecedor1.getPessoa().setNomeRazao("Jose");
    	fornecedor1.getPessoa().setCpfCnpj("123");
    	fornecedorManager.salvar(fornecedor1);
    	
    	Fornecedor fornecedor2 = new Fornecedor();
    	fornecedor2 = Populate.populateFornecedor(cidade);
    	fornecedor2.getPessoa().setNomeRazao("Maria");
    	fornecedor2.getPessoa().setCpfCnpj("999999");
    	fornecedorManager.salvar(fornecedor2);
    	
    	Fornecedor fornecedor3 = new Fornecedor();
    	fornecedor3 = Populate.populateFornecedor(cidade);
    	fornecedor3.getPessoa().setNomeRazao("");
    	fornecedor3.getPessoa().setCpfCnpj("");
    	fornecedor3.setFornecedorType(FornecedorType.INFORMATICA);
    	fornecedorManager.salvar(fornecedor3);
    }
    
    @Test
    public void buscarPorId(){
    	Fornecedor fornecedor = PopulateBD.populateFornecedor(entityManager, cidade);
    	
    	Assert.assertNotNull(fornecedorManager.buscarPorId(fornecedor.getId()));
    }

}
