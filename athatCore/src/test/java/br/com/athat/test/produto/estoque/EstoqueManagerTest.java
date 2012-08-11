package br.com.athat.test.produto.estoque;

import java.math.BigDecimal;
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
//		ItemEstoque itemEstoque = new ItemEstoque();
//		itemEstoque.setValorCusto(BigDecimal.valueOf(100));
//		
//		Estoque estoque = produto.getEstoque();
//		estoque.setItemEstoqueList(new ArrayList<ItemEstoque>());
//		estoque.setQuantidade(10);
//		estoque.getItemEstoqueList().add(itemEstoque);
//		
//		estoqueManager.entrar(estoque);
//		
//		Produto p = find(Produto.class).get(0);
//		Assert.assertEquals(new Integer(10), p.getEstoque().getQuantidade());
	}
	
	@Test
	public void saidaTeste(){
//		entradaTest();
//		
//		Estoque estoque = produto.getEstoque();
//		estoque.setQuantidade(5);
//		
//		estoqueManager.entrar(estoque);
//		
//		Produto p = find(Produto.class).get(0);
//		Assert.assertEquals(new Integer(5), p.getEstoque().getQuantidade());
		
	}
	
}
