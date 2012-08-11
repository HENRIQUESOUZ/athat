package br.com.athat.web.cadastro.pessoa.funcionario.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.athat.core.cadastro.pessoa.entity.Pessoa;
import br.com.athat.core.cadastro.pessoa.funcionario.entity.Funcionario;
import br.com.athat.core.cadastro.pessoa.funcionario.manager.FuncionarioManager;
import br.com.athat.web.utils.AbstractController;

public class FuncionarioController extends AbstractController{

	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
    private Pessoa pessoa;
    private List<Funcionario> funcionarios;
     
    @Autowired
    private FuncionarioManager funcionarioManager;

    public FuncionarioController() {
        funcionario = new Funcionario();
        funcionario.setPessoa(new Pessoa());
        pessoa = new Pessoa();
    }
    
    @PostConstruct
    public void init(){
		String id = getParametro("id");
		if (getParametro("id") != null) 
			funcionario = funcionarioManager.buscarPorId(Long.valueOf(id));
    }

         
    public String salvar(){
        try{
            funcionario.setPessoa(pessoa);
            funcionarioManager.salvar(funcionario);
            getMessageCadastroSucesso();
        }catch(Exception e){
            getMessageInstabilidade();
        }    
        
        return "/pages/cadastro/cadastroFuncionario";
    }
    
     public void buscar(){
                
         funcionarios = funcionarioManager.buscarTodos(funcionario);
         
    }
   
     public String limpar(){
        
        funcionario = new Funcionario();
        funcionario.setPessoa(new Pessoa());

        return "/pages/cadastro/cadastroFuncionario";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
