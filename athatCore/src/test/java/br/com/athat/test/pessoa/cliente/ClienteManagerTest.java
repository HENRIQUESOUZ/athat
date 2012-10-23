package br.com.athat.test.pessoa.cliente;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
import br.com.athat.core.entity.pessoa.endereco.Cidade;
import br.com.athat.core.manager.pessoa.cliente.ClienteManager;

public class ClienteManagerTest extends AbstractTest{
    
	private Cidade cidade;
	
    @Autowired
    private ClienteManager clienteManager;
    
    @Before
    public void before(){
    	cidade = PopulateBD.populateCidade(entityManager);
    }
    	
    @Test
    public void save(){
        Cliente cliente = Populate.populateCliente(cidade);
        
        clienteManager.salvar(cliente);
        
        Assert.assertNotNull(cliente);
        Assert.assertEquals(1, find(Cliente.class).size());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Assert.assertEquals(dateFormat.format(new Date()), dateFormat.format(cliente.getDataAniversario()));
    }
    
    @Test
    public void buscar(){
    	populate();
    	Cliente cliente = new Cliente();
    	cliente.setPessoa(new Pessoa());
    	
    	Assert.assertEquals(2, clienteManager.buscarTodos(cliente).size());
    	
    	cliente.getPessoa().setNomeRazao("Jose");
    	cliente.getPessoa().setCpfCnpj("");
    	Assert.assertEquals(1, clienteManager.buscarTodos(cliente).size());
    	
    	cliente.getPessoa().setNomeRazao("");
    	cliente.getPessoa().setCpfCnpj("999999");
    	Assert.assertEquals(1, clienteManager.buscarTodos(cliente).size());
    }
    
    private void populate(){
    	Cliente cliente1 = new Cliente();
    	cliente1 = Populate.populateCliente(cidade);
    	cliente1.getPessoa().setNomeRazao("Jose");
    	cliente1.getPessoa().setCpfCnpj("123");
    	clienteManager.salvar(cliente1);
    	
    	Cliente cliente2 = new Cliente();
    	cliente2 = Populate.populateCliente(cidade);
    	cliente2.getPessoa().setNomeRazao("Maria");
    	cliente2.getPessoa().setCpfCnpj("999999");
    	clienteManager.salvar(cliente2);
    }
    
    @Test
    public void buscarPorId(){
    	Cliente cliente = PopulateBD.populateCliente(entityManager, cidade);
    	
    	Assert.assertNotNull(clienteManager.buscarPorId(cliente.getId()));
    }
}
