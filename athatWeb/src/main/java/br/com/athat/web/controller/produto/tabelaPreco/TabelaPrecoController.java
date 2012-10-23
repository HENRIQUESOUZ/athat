package br.com.athat.web.controller.produto.tabelaPreco;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.produto.tabelaPreco.TabelaPreco;
import br.com.athat.core.manager.produto.tabelaPreco.TabelaPrecoManager;
import br.com.athat.web.utils.AbstractController;

public class TabelaPrecoController extends AbstractController{

	private static final long serialVersionUID = 1L;
	
	private TabelaPreco tabelaPreco;
	private List<TabelaPreco> tabelaPrecos;
	
	@Autowired
	private TabelaPrecoManager tabelaPrecoManager;
	
	public TabelaPrecoController() {
		tabelaPreco = new TabelaPreco();
		tabelaPrecos = new ArrayList<TabelaPreco>();
	}
	
	@PostConstruct
    public void init(){
		String id = getParametro("id");
		if (id != null) 
			tabelaPreco = tabelaPrecoManager.buscarPorId(Long.valueOf(id));
    }
	
	public String salvar() {
		tabelaPrecoManager.salvar(tabelaPreco);
        getMessageCadastroSucesso();
        
        return "cadastroTabelaPreco";
    }
	
    public void buscar() {
        tabelaPrecos = tabelaPrecoManager.buscar(tabelaPreco);
    }
    
    public String limpar() {
    	tabelaPreco = new TabelaPreco();
    	
    	return "cadastroTabelaPreco?faces-redirect=true";
    }
	
	public TabelaPreco getTabelaPreco() {
		return tabelaPreco;
	}
	
	public void setTabelaPreco(TabelaPreco tabelaPreco) {
		this.tabelaPreco = tabelaPreco;
	}
	
	public List<TabelaPreco> getTabelaPrecos() {
		return tabelaPrecos;
	}
	
	public void setTabelaPrecos(List<TabelaPreco> tabelaPrecos) {
		this.tabelaPrecos = tabelaPrecos;
	}
}
