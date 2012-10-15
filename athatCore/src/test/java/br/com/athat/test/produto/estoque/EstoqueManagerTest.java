package br.com.athat.test.produto.estoque;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.athat.core.AbstractTest;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.cadastro.produto.categoria.entity.Categoria;
import br.com.athat.core.cadastro.produto.entity.Produto;
import br.com.athat.core.cadastro.produto.estoque.EstoqueManager;
import br.com.athat.core.cadastro.produto.estoque.entity.Estoque;
import br.com.athat.core.cadastro.produto.estoque.entity.ItemEstoque;
import br.com.athat.core.movimentacao.ItemProduto;
import java.math.BigDecimal;

public class EstoqueManagerTest extends AbstractTest{

	private Produto produto;
	private Categoria categoria;
	
	@Autowired
	private EstoqueManager estoqueManager;

	@Before
	public void init(){
		categoria = PopulateBD.populateCategoria(entityManager);
		produto = PopulateBD.populateProduto(entityManager, categoria);
	}
	
	@Test
	public void entradaTest(){
		ItemProduto itemProduto = new ItemProduto();
                itemProduto.setProduto(produto);
                itemProduto.setQuantidade(10);
                itemProduto.setValor(BigDecimal.valueOf(100));
		
		estoqueManager.entrar(itemProduto);
		
		Produto p = find(Produto.class).get(0);
		Assert.assertEquals(new Integer(10), p.getEstoque().getQuantidade());
	}
	
	@Test
	public void saidaTeste(){
                entradaTest();
            
		ItemProduto itemProduto = new ItemProduto();
                itemProduto.setProduto(produto);
                itemProduto.setQuantidade(5);
                itemProduto.setValor(BigDecimal.valueOf(100));
		
		estoqueManager.sair(itemProduto);
		
		Produto p = find(Produto.class).get(0);
		Assert.assertEquals(new Integer(5), p.getEstoque().getQuantidade());
		
	}
	
}
