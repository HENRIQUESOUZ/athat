package br.com.athat.test.pessoa.funcionario;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.endereco.Cidade;
import br.com.athat.core.entity.pessoa.funcionario.Funcionario;
import br.com.athat.core.manager.pessoa.funcionario.FuncionarioManager;

public class FuncionarioManagerTest extends AbstractTest{

	private Cidade cidade;
	
    @Autowired
    private FuncionarioManager funcionarioManager;
    
    @Before
    public void before(){
    	cidade = PopulateBD.populateCidade(entityManager);
    }
    	
    @Test
    public void save(){
        Funcionario Funcionario = Populate.populateFuncionario(cidade);
        
        funcionarioManager.salvar(Funcionario);
        
        Assert.assertNotNull(Funcionario);
        Assert.assertEquals(1, find(Funcionario.class).size());
    }
    
    @Test
    public void buscar(){
    	populate();
    	Funcionario funcionario = new Funcionario();
    	funcionario.setPessoa(new Pessoa());
    	
    	Assert.assertEquals(2, funcionarioManager.buscarTodos(funcionario).size());
    	
    	funcionario.getPessoa().setNomeRazao("Jose");
    	funcionario.getPessoa().setCpfCnpj("");
    	Assert.assertEquals(1, funcionarioManager.buscarTodos(funcionario).size());
    	
    	funcionario.getPessoa().setNomeRazao("");
    	funcionario.getPessoa().setCpfCnpj("999999");
    	Assert.assertEquals(1, funcionarioManager.buscarTodos(funcionario).size());
    }
    
    private void populate(){
    	Funcionario funcionario1 = new Funcionario();
    	funcionario1 = Populate.populateFuncionario(cidade);
    	funcionario1.getPessoa().setNomeRazao("Jose");
    	funcionario1.getPessoa().setCpfCnpj("123");
    	funcionarioManager.salvar(funcionario1);
    	
    	Funcionario funcionario2 = new Funcionario();
    	funcionario2 = Populate.populateFuncionario(cidade);
    	funcionario2.getPessoa().setNomeRazao("Maria");
    	funcionario2.getPessoa().setCpfCnpj("999999");
    	funcionarioManager.salvar(funcionario2);
    }
    
    @Test
    public void buscarPorId(){
    	Funcionario funcionario = PopulateBD.populateFuncionario(entityManager, cidade);
    	
    	Assert.assertNotNull(funcionarioManager.buscarPorId(funcionario.getId()));
    }
	
}
