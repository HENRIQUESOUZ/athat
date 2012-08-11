package br.com.athat.web.cadastro.pessoa.fornecedor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.athat.core.cadastro.pessoa.entity.Pessoa;
import br.com.athat.core.cadastro.pessoa.fornecedor.entity.Fornecedor;
import br.com.athat.core.cadastro.pessoa.fornecedor.manager.FornecedorManager;
import br.com.athat.web.utils.AbstractController;

public class FornecedorController extends AbstractController{

	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;
    private Pessoa pessoa;
    private List<Fornecedor> fornecedores;
    
    @Autowired
    private FornecedorManager fornecedorManager;

    public FornecedorController() {
        fornecedor = new Fornecedor();
        fornecedor.setPessoa(new Pessoa());
        pessoa = new Pessoa();
        fornecedores = new ArrayList<Fornecedor>();
    }
    
    @PostConstruct
    public void init(){
		String id = getParametro("id");
		if (getParametro("id") != null) 
			fornecedor = fornecedorManager.buscarPorId(Long.valueOf(id));
    }
         
    public String salvar(){
        try{
            fornecedor.setPessoa(pessoa);
            fornecedorManager.salvar(fornecedor); 
            getMessageCadastroSucesso();
        }catch(Exception e){
            getMessageInstabilidade();
        }
       
        
        return "/pages/cadastro/cadastroFornecedor";
    }
    
     public void buscar(){
                
         fornecedores = fornecedorManager.buscarTodos(fornecedor);
         
    }
    
   
     public String limpar(){
        
        fornecedor = new Fornecedor();
        fornecedor.setPessoa(new Pessoa());

        return "/pages/cadastro/cadastroFornecedor";
    } 

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }
}
