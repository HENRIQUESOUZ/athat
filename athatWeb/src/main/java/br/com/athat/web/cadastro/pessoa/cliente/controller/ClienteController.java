package br.com.athat.web.cadastro.pessoa.cliente.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.athat.core.cadastro.pessoa.cliente.entity.Cliente;
import br.com.athat.core.cadastro.pessoa.cliente.manager.ClienteManager;
import br.com.athat.core.cadastro.pessoa.entity.Pessoa;
import br.com.athat.web.utils.AbstractController;

public class ClienteController extends AbstractController{
    
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
    private Pessoa pessoa;
    private List<Cliente> clientes;
    
    @Autowired
    private ClienteManager clienteManager;

    public ClienteController() {
        cliente = new Cliente();
        cliente.setPessoa(new Pessoa());
        pessoa = new Pessoa();
        clientes = new ArrayList<Cliente>();
    }
    
    @PostConstruct
    public void init(){
		String id = getParametro("clienteId");
		if (getParametro("clienteId") != null) {
			cliente = clienteManager.buscarPorId(Long.valueOf(id));
		}
    }
                
    public String salvar(){
        try{  
            cliente.setPessoa(pessoa);
            clienteManager.salvar(cliente);
            getMessageCadastroSucesso();
        }catch(Exception e){
            getMessageInstabilidade();
        }    
     
        return "/pages/cadastro/cadastroCliente";
    }
    
     public void buscar(){
         clientes = clienteManager.buscarTodos(cliente);
    }
    
    public String limpar(){
        cliente = new Cliente();
        cliente.setPessoa(new Pessoa());

        return "/pages/cadastro/cadastroCliente";
    } 
   
    public Cliente getCliente() {
        return cliente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
 
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
