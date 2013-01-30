package br.com.athat.web.movimentacao.venda;

import br.com.athat.core.entity.conta.SituacaoContaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.venda.Venda;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.entity.produto.tabelaPreco.TabelaPreco;
import br.com.athat.core.manager.movimentacao.venda.VendaManager;
import br.com.athat.core.manager.produto.ProdutoManager;
import br.com.athat.core.manager.produto.tabelaPreco.TabelaPrecoManager;
import br.com.athat.web.utils.AbstractController;

public class VendaController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Venda venda;
	private ItemProduto itemProduto;
	private List<Produto> produtos;
	private TabelaPreco tabelaPreco;
	
	@Autowired
	private VendaManager vendaManager;
	
	@Autowired
	private ProdutoManager produtoManager;
	
	@Autowired
	private TabelaPrecoManager tabelaPrecoManager;
	
	public VendaController() {
		init();
	}
	
	@PostConstruct
	public void carregarTabelaPreço() {
		tabelaPreco = tabelaPrecoManager.buscarTabelaVigente(new Date());
	}
	
	private void init() {
		venda = new Venda();
		venda.setCliente(new Cliente());
		venda.getCliente().setPessoa(new Pessoa());
		venda.setItensMovimentacao(new ArrayList<ItemProduto>());
		venda.setValorTotal(BigDecimal.ZERO);
		itemProduto = new ItemProduto();
		produtos = new ArrayList<Produto>();
	}
	
    public String finalizar() {
        try {
            if (validade()) {
                venda.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.FECHADA);
                setMessage("Venda Finalizada com Sucesso!");
                init();
            }
        } catch (Exception e) {
            getMessageInstabilidade();
            e.printStackTrace();
        }
        return "/pages/conta/contaAReceber";
    }
	
	public void validaCliente(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Cliente cliente = (Cliente) event.getComponent().getAttributes().get("pessoa");
        if (cliente == null) {
            context.addCallbackParam("confirmar", false);
            setMessage("Cliente não selecionado.");
        } else {
            context.addCallbackParam("confirmar", true);
            venda.setCliente(cliente);
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
    		itemProduto.setValor(produto.getEstoque().calcularValorVenda(tabelaPreco));
    		venda.getItensMovimentacao().add(itemProduto);
    		itemProduto = new ItemProduto();
    		calculaValorTotal();
    	}
    }
	
	public void removerProduto() {
		venda.getItensMovimentacao().remove(itemProduto);
		itemProduto = new ItemProduto();
		calculaValorTotal();
	}
	
	public String limpar(){
		init();
		return "/pages/movimentacao/venda";
	}
	
	public void calculaValorTotal() {
		BigDecimal valor = BigDecimal.ZERO;
		for(ItemProduto it : venda.getItensMovimentacao()){
			valor = valor.add(it.getValorTotal());
		}
		venda.setValorTotal(valor);
	}
	
	private boolean validade() {
		if(venda.getValorTotal().compareTo(BigDecimal.ZERO) <= 0) {
			setMessage(FacesMessage.SEVERITY_INFO, null, "Venda com valor total zero.");
			return false;
		}
		
		for(ItemProduto it : venda.getItensMovimentacao()) {
			if(it.getValorTotal().compareTo(BigDecimal.ZERO) <= 0) {
				setMessage(FacesMessage.SEVERITY_INFO, null, "Produto(s) com valor total zero.");
				return false;
			}
		}
		
		return true;
	}
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
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

	public VendaManager getVendaManager() {
		return vendaManager;
	}

	public void setVendaManager(VendaManager vendaManager) {
		this.vendaManager = vendaManager;
	}

	public ProdutoManager getProdutoManager() {
		return produtoManager;
	}

	public void setProdutoManager(ProdutoManager produtoManager) {
		this.produtoManager = produtoManager;
	}
	
	public TabelaPreco getTabelaPreco() {
		return tabelaPreco;
	}
}
