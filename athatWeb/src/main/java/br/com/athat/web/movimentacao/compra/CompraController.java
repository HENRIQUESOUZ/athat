package br.com.athat.web.movimentacao.compra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.core.manager.produto.ProdutoManager;
import br.com.athat.web.utils.AbstractController;

public class CompraController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Compra compra;
	private Produto produto;
	private ItemProduto itemProduto;
	private List<Produto> produtos;
	
	
	@Autowired
	private CompraManager compraManager;
	
	@Autowired
	private ProdutoManager produtoManager;
	
	public CompraController() {
		compra = new Compra();
		compra.setItensMovimentacao(new ArrayList<ItemProduto>());
		inicializeProduto();
		produtos = new ArrayList<Produto>();
	}
	
	public void buscarProdutos(){
		produtos = produtoManager.buscar(produto);
	}
	
	public void adicionarProduto(){
		itemProduto.setProduto(produto);
		compra.getItensMovimentacao().add(itemProduto);
		inicializeProduto();
	}
	
	public void removerProduto(){
		compra.getItensMovimentacao().remove(itemProduto);
		inicializeProduto();
	}
	
	public String salvar(){
		compraManager.salvar(compra);
		return "/pages/movimentacao/compra";
	}
	
	private void inicializeProduto(){
		itemProduto = new ItemProduto();
		produto = new Produto();
	}
	
}
