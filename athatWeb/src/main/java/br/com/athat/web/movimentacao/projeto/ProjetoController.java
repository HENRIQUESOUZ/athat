package br.com.athat.web.movimentacao.projeto;

import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.projeto.Projeto;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
import br.com.athat.core.manager.movimentacao.projeto.ProjetoManager;
import br.com.athat.web.utils.AbstractController;

public class ProjetoController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Projeto projeto;
	
	public ProjetoController() {
		init();
	}
	
	@Autowired
	private ProjetoManager projetoManager;
	
	public String salvar() {
		try {
			projetoManager.salvar(projeto);
			getMessageCadastroSucesso();
			init();
		} catch(Exception e){
			getMessageInstabilidade();
			e.printStackTrace();
		}
		return "/pages/projeto/cadastroProjeto?faces-redirect=true";
	}
	
	public String limpar() {
		init();
		
		return "/pages/projeto/cadastroProjeto?faces-redirect=true";
	}
	
	public void validaCliente(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Cliente cliente = (Cliente) event.getComponent().getAttributes().get("pessoa");
    	if (cliente == null) {
    		context.addCallbackParam("confirmar", false);
    		setMessage("Cliente não selecionado.");
    	} else {
    		context.addCallbackParam("confirmar", true);                
    		projeto.setCliente(cliente);
    	}
    }
	
	private void init() {
		projeto = new Projeto();
	}
	
	public Projeto getProjeto() {
		return projeto;
	}
	
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
