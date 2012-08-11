package br.com.athat.web.cadastro.cidade.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.cadastro.pessoa.entity.endereco.Cidade;
import br.com.athat.core.cadastro.pessoa.manager.CidadeManager;
import br.com.athat.web.utils.AbstractController;

public class CidadeController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Cidade cidade;
    private List<Cidade> cidades;
    private Cidade teste;
    
    @Autowired
    private CidadeManager cidadeManager;

    public CidadeController() {
        cidade = new Cidade();
        cidades = new ArrayList<Cidade>();
    }
    
	@PostConstruct
    public void init(){
		String id = getParametro("id");
		if (id != null) 
        	cidade = cidadeManager.buscarPorId(Long.valueOf(id));
    }
    
    public String salvar (){
        cidadeManager.salvar(cidade);
        getMessageCadastroSucesso();
        
        return "cadastroCidade";
    }
    public void buscar(){
        cidades = cidadeManager.buscarTodos(cidade);
    }
    
    public String limpar(){
    	cidade = new Cidade();
    	
    	return "cadastroCidade?faces-redirect=true";
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public CidadeManager getCidadeManager() {
        return cidadeManager;
    }

    public void setCidadeManager(CidadeManager cidadeManager) {
        this.cidadeManager = cidadeManager;
    }

    public Cidade getTeste() {
        return teste;
    }

    public void setTeste(Cidade teste) {
        this.teste = teste;
    }
    
    
    
}
