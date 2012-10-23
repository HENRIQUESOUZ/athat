package br.com.athat.test.produto;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.entity.produto.categoria.Categoria;
import br.com.athat.core.manager.produto.ProdutoManager;

public class ProdutoManagerTest extends AbstractTest{
	
	private Categoria categoria;
	
	@Autowired
	private ProdutoManager produtoManager;

	@Before
	public void before(){
		categoria = PopulateBD.populateCategoria(entityManager);
	}
	
	@Test
	public void save(){
		Produto produto = Populate.populateProduto(categoria);
		
		produtoManager.salvar(produto);
		
	    Assert.assertNotNull(produto.getId());
	    Assert.assertEquals(1, find(Produto.class).size());
	}
	
	@Test
	public void buscar(){
		popalate();
		
		Produto produto = new Produto();
		
		produtoManager.buscar(produto);
		Assert.assertEquals(2, produtoManager.buscar(produto).size());
		
		produto.setDescricao("Placa Mãe");
		Assert.assertEquals(1, produtoManager.buscar(produto).size());
	}
	
	private void popalate(){
		Produto produtoDb1 = Populate.populateProduto(categoria);
		produtoDb1.setDescricao("Placa Mãe");
		produtoManager.salvar(produtoDb1);
		
		Produto produtoBd2 = Populate.populateProduto(categoria);
		produtoManager.salvar(produtoBd2);
	}

}
