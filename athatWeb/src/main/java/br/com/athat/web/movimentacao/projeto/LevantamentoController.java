package br.com.athat.web.movimentacao.projeto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.projeto.Levantamento;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.funcionario.Funcionario;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.manager.movimentacao.projeto.LevantamentoManager;
import br.com.athat.web.utils.AbstractController;

public class LevantamentoController extends AbstractController {

	private static final long serialVersionUID = 1L;

	private Levantamento levantamento;
	private ItemProduto itemProduto;
	private List<Produto> produtos;
	
	@Autowired
	private LevantamentoManager levantamentoManager;
	
	public LevantamentoController() {
		init();
	}

	private void init() {
		levantamento = new Levantamento();
		levantamento.setFuncionario(new Funcionario());
		levantamento.getFuncionario().setPessoa(new Pessoa());
		levantamento.setItensMovimentacao(new ArrayList<ItemProduto>());
		itemProduto = new ItemProduto();
		produtos = new ArrayList<Produto>();
	}
	
	public String salvar() {
		try {
			if(validade()) {
				levantamentoManager.salvar(levantamento);
				getMessageCadastroSucesso();
			}
		} catch(Exception e) {
			getMessageInstabilidade();
			e.printStackTrace();
		}
		
		return "/pages/projeto/levantamento";
	}
	
	public String finalizar() {
		try {
			if(validade()) {
				levantamento.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.FECHADA);
				levantamentoManager.salvar(levantamento);
			setMessage("Levantamento Finalizada com Sucesso!");
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
		return "/pages/projeto/levantamento?faces-redirect=true";
	}
	
	public void validaFuncionario(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Funcionario funcionario = (Funcionario) event.getComponent().getAttributes().get("pessoa");
    	if (funcionario == null) {
    		context.addCallbackParam("confirmar", false);
    		setMessage("Funcionário não selecionado.");
    	} else {
    		context.addCallbackParam("confirmar", true);                
    		levantamento.setFuncionario(funcionario);
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
    		levantamento.getItensMovimentacao().add(itemProduto);
    		itemProduto = new ItemProduto();
    	}
    }
	
	public void removerProduto() {
		levantamento.getItensMovimentacao().remove(itemProduto);
		itemProduto = new ItemProduto();
	}
	
	public void prepararProduto() {
		itemProduto = new ItemProduto();
	}
	
	private boolean validade() {
		if(levantamento.getItensMovimentacao().size() == 0 ) {
			setMessage(FacesMessage.SEVERITY_INFO, null, "Levantamento sem produtos.");
			return false;
		}
		
		return true;
	}

	public Levantamento getLevantamento() {
		return levantamento;
	}

	public void setLevantamento(Levantamento levantamento) {
		this.levantamento = levantamento;
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
}
