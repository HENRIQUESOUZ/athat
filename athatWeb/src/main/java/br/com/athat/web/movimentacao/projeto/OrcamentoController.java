package br.com.athat.web.movimentacao.projeto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.entity.movimentacao.projeto.Projeto;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.funcionario.Funcionario;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.entity.produto.tabelaPreco.TabelaPreco;
import br.com.athat.core.manager.movimentacao.projeto.LevantamentoManager;
import br.com.athat.core.manager.produto.tabelaPreco.TabelaPrecoManager;
import br.com.athat.web.utils.AbstractController;
import javax.annotation.PostConstruct;

public class OrcamentoController extends AbstractController {

	private static final long serialVersionUID = 1L;

	private Orcamento orcamento;
	private ItemProduto itemProduto;
	private List<Produto> produtos;
	private Projeto projeto;
        private TabelaPreco tabelaPreco;
	
	@Autowired
	private LevantamentoManager levantamentoManager;
        
        @Autowired
	private TabelaPrecoManager tabelaPrecoManager;
	
	public OrcamentoController() {
            projeto = new Projeto();
		init();
	}
        
         @PostConstruct
	public void carregarTabelaPreço() {
		tabelaPreco = tabelaPrecoManager.buscarTabelaVigente(new Date());
	}

	private void init() {
		orcamento = new Orcamento();
		orcamento.setFuncionario(new Funcionario());
		orcamento.getFuncionario().setPessoa(new Pessoa());
		orcamento.setItensMovimentacao(new ArrayList<ItemProduto>());
		itemProduto = new ItemProduto();
		produtos = new ArrayList<Produto>();
	}
	
	public String salvar() {
		try {
			if(validade()) {
				orcamento.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.ABERTA);
				levantamentoManager.salvar(orcamento);
				projeto = orcamento.getProjeto();
				getMessageCadastroSucesso();
			}
		} catch(Exception e) {
			getMessageInstabilidade();
			e.printStackTrace();
		}
		
		return "/pages/projeto/orcamento";
	}
	
	public String finalizar() {
		try {
			if(validade()) {
				orcamento.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.FECHADA);
				orcamento.setDataFinalizacao(new Date());
				levantamentoManager.finalizarOrcamento(orcamento);
				projeto = orcamento.getProjeto();
			setMessage("Orçamento Finalizada com Sucesso!");
			init();
			}	
		}catch(Exception e) {
			getMessageInstabilidade();
			e.printStackTrace();
		}
		return "/pages/projeto/projeto?faces-redirect=true";
	}
	
	public String limpar() {
		init();
		return "/pages/projeto/orcamento?faces-redirect=true";
	}
	
	public void validaFuncionario(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Funcionario funcionario = (Funcionario) event.getComponent().getAttributes().get("pessoa");
    	if (funcionario == null) {
    		context.addCallbackParam("confirmar", false);
    		setMessage("Funcionário não selecionado.");
    	} else {
    		context.addCallbackParam("confirmar", true);                
    		orcamento.setFuncionario(funcionario);
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
    		orcamento.getItensMovimentacao().add(itemProduto);
    		itemProduto = new ItemProduto();
                calculaValorTotal();
    	}
    }
	
	public void removerProduto() {
		orcamento.getItensMovimentacao().remove(itemProduto);
		itemProduto = new ItemProduto();
                calculaValorTotal();
	}
	
	public void prepararProduto() {
		itemProduto = new ItemProduto();
	}
	
	public void calculaValorTotal() {
            BigDecimal valor = BigDecimal.ZERO;
            for(ItemProduto it : orcamento.getItensMovimentacao()){
                valor = valor.add(it.getValorTotal());
            }
            orcamento.setValorTotal(valor);
	}
	
	private boolean validade() {
		if(orcamento.getValorTotal().compareTo(BigDecimal.ZERO) <= 0) {
			setMessage(FacesMessage.SEVERITY_INFO, null, "Orçamento com valor total zero.");
			return false;
		}
		
		if(orcamento.getItensMovimentacao().size() <= 0 ) {
			setMessage(FacesMessage.SEVERITY_INFO, null, "Orçamento sem produtos.");
			return false;
		}
		
		return true;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
