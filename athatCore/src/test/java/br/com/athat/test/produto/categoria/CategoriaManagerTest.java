package br.com.athat.test.produto.categoria;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.PopulateBD;
import br.com.athat.core.cadastro.produto.categoria.entity.Categoria;
import br.com.athat.core.cadastro.produto.categoria.entity.IdentificacaoType;
import br.com.athat.core.cadastro.produto.categoria.entity.UnidadeMedidaType;
import br.com.athat.core.cadastro.produto.categoria.manager.CategoriaManager;
import br.com.athat.core.cadastro.produto.entity.ProdutoType;

public class CategoriaManagerTest extends AbstractTest{
	
	@Autowired
	private CategoriaManager categoriaManager;
	
	@Test
	public void save(){
		Categoria categoria = Populate.populateCategoria();
		Categoria subCategoria = PopulateBD.populateCategoria(entityManager);
		
		categoria.setCategoria(subCategoria);
		
		categoriaManager.salvar(categoria);
		
	    Assert.assertNotNull(categoria.getId());
	    Assert.assertEquals(2, find(Categoria.class).size());
	}
	
	@Test
	public void buscar(){
		popalate();
		
		Categoria categoria = new Categoria();
		
		categoriaManager.buscar(categoria);
		Assert.assertEquals(5, categoriaManager.buscar(categoria).size());
		
		categoria.setDescricao("Rede");
		Assert.assertEquals(1, categoriaManager.buscar(categoria).size());
		
		categoria.setDescricao(null);
		categoria.setUnidadeMedidaType(UnidadeMedidaType.HORA);
		categoriaManager.buscar(categoria);
		Assert.assertEquals(1, categoriaManager.buscar(categoria).size());
		
		categoria.setUnidadeMedidaType(null);
		categoria.setProdutoType(ProdutoType.SERViCO);
		categoriaManager.buscar(categoria);
		Assert.assertEquals(1, categoriaManager.buscar(categoria).size());
		
		categoria.setUnidadeMedidaType(null);
		categoria.setProdutoType(null);
		categoria.setDescricao(null);
		categoria.setIdentificacaoType(IdentificacaoType.SEMIDENTIFICACAO);
		categoriaManager.buscar(categoria);
		Assert.assertEquals(1, categoriaManager.buscar(categoria).size());
		
	}
	
	private void popalate(){
		Categoria categoriaBd1 = Populate.populateCategoria();
		categoriaBd1.setDescricao("Rede");
		categoriaBd1.setUnidadeMedidaType(UnidadeMedidaType.LOTE);
		categoriaManager.salvar(categoriaBd1);
		
		Categoria categoriaBd2 = Populate.populateCategoria();
		categoriaBd2.setDescricao("Serviço");
		categoriaBd2.setUnidadeMedidaType(UnidadeMedidaType.HORA);
		categoriaManager.salvar(categoriaBd2);
		
		Categoria categoriaBd3 = Populate.populateCategoria();
		categoriaBd3.setDescricao("Hardware");
		categoriaBd3.setUnidadeMedidaType(UnidadeMedidaType.UNIDADE);
		categoriaManager.salvar(categoriaBd3);
		
		Categoria categoriaBd4 = Populate.populateCategoria();
		categoriaBd4.setProdutoType(ProdutoType.SERViCO);
		categoriaManager.salvar(categoriaBd4);
		
		Categoria categoriaBd5 = Populate.populateCategoria();
		categoriaBd5.setIdentificacaoType(IdentificacaoType.SEMIDENTIFICACAO);
		categoriaManager.salvar(categoriaBd5);
	}

}
