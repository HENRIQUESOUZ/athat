package br.com.athat.test.pessoa.endereco.cidade;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.entity.pessoa.endereco.Cidade;
import br.com.athat.core.entity.pessoa.endereco.EstadoType;
import br.com.athat.core.manager.pessoa.CidadeManager;

public class CidadeManagerTest extends AbstractTest{

	@Autowired 
	private CidadeManager cidadeManager;
	
	@Test
	public void salvar(){
		Cidade cidade = Populate.populateCidade();
		
		cidadeManager.salvar(cidade);
		
		Assert.assertNotNull(cidade.getId());
	    Assert.assertEquals(1, find(Cidade.class).size());
	}
	
	@Test
	public void buscar(){
		populate();
		Cidade cidade = new Cidade();
		cidade.setEstadoType(EstadoType.PR);
		
		Assert.assertEquals(3, find(Cidade.class).size());
		for(Cidade c : find(Cidade.class)){
			System.out.println(">>>>>>>>>>" + c.getIbge());
			System.out.println(">>>>>>>>>>" + c.getNome());
			System.out.println(">>>>>>>>>>" + c.getEstadoType());
			System.out.println("-------------");
		}
		
		cidade.setNome("Ma");
		Assert.assertEquals(1, cidadeManager.buscarTodos(cidade).size());
	}
	
	@Test
	public void buscarPorEstado(){
		populate();
		
		Assert.assertEquals(2, cidadeManager.buscarPorEstado(EstadoType.PR).size());
		
		Assert.assertEquals(1, cidadeManager.buscarPorEstado(EstadoType.RS).size());
	}
	
	@Test
	public void buscarPorId(){
		Cidade cidade = PopulateBD.populateCidade(entityManager);
		
		Assert.assertNotNull(cidade);
	    Assert.assertNotNull(cidadeManager.buscarPorId(cidade.getId()));
	}
	
	private void populate(){
		Cidade cidade1 = Populate.populateCidade();
		cidade1.setNome("Maringa");
		cidade1.setIbge("");
		cidadeManager.salvar(cidade1);
		
		Cidade cidade2 = Populate.populateCidade();
		cidade2.setIbge("222");
		cidadeManager.salvar(cidade2);
		
		Cidade cidade3 = Populate.populateCidade();
		cidade2.setIbge("");
		cidade2.setNome("");
		cidade3.setEstadoType(EstadoType.RS);
		cidadeManager.salvar(cidade3);
	}
}
