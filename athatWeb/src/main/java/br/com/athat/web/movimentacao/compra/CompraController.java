package br.com.athat.web.movimentacao.compra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.core.manager.produto.ProdutoManager;
import br.com.athat.web.utils.AbstractController;

public class CompraController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Compra compra;
	private ItemProduto itemProduto;
	private List<Produto> produtos;
	private BigDecimal valorTotal;
	
	private final String COMPRA_PAGE = "/pages/movimentacao/compra";
	
	@Autowired
	private CompraManager compraManager;
	
	@Autowired
	private ProdutoManager produtoManager;
	
	public CompraController() {
		init();
	}
	
	public void removerProduto(){
		compra.getItensMovimentacao().remove(itemProduto);
		valorTotal.subtract(itemProduto.getValorTotal());
		itemProduto = new ItemProduto();
	}
	
	public String salvar(){
		compraManager.salvar(compra);
		return "COMPRA_PAGE";
	}
	
	public String finalizar(){
		compra.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.FECHADA);
		compraManager.salvar(compra);
		return "COMPRA_PAGE";
	}
	
	public void validaFornecedor(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Fornecedor fornecedor = (Fornecedor) event.getComponent().getAttributes().get("pessoa");
    	if (fornecedor == null) {
    		context.addCallbackParam("confirmar", false);
    		setMessage("Fornecedor não selecionado.");
    	} else {
    		context.addCallbackParam("confirmar", true);                
    		compra.setFornecedor(fornecedor);
    	}
    }
	
	public void adicionarProduto(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Produto produto = (Produto) event.getComponent().getAttributes().get("produto");
    	if (produto == null) {
    		context.addCallbackParam("confirmar", false);
    		setMessage("Produto não selecionada.");
    	} else {
    		context.addCallbackParam("confirmar", true);                
    		itemProduto.setProduto(produto);
    		compra.getItensMovimentacao().add(itemProduto);
    		valorTotal.add(itemProduto.getValorTotal());
    		itemProduto = new ItemProduto();
    	}
    }
	
	public String limpar(){
		init();
		return "COMPRA_PAGE";
	}
	
	private void init(){
		compra = new Compra();
		compra.setFornecedor(new Fornecedor());
		compra.getFornecedor().setPessoa(new Pessoa());
		compra.setItensMovimentacao(new ArrayList<ItemProduto>());
		produtos = new ArrayList<Produto>();
		valorTotal = BigDecimal.ZERO;
		itemProduto = new ItemProduto();
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public ItemProduto getItemProduto() {
		return itemProduto;
	}

	public void setItemProduto(ItemProduto itemProduto) {
		this.itemProduto = itemProduto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public CompraManager getCompraManager() {
		return compraManager;
	}

	public void setCompraManager(CompraManager compraManager) {
		this.compraManager = compraManager;
	}

	public ProdutoManager getProdutoManager() {
		return produtoManager;
	}

	public void setProdutoManager(ProdutoManager produtoManager) {
		this.produtoManager = produtoManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
