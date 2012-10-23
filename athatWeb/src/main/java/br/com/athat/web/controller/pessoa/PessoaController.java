package br.com.athat.web.controller.pessoa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.athat.core.cadastro.pessoa.entity.Endereco;
import br.com.athat.core.cadastro.pessoa.entity.Pessoa;
import br.com.athat.core.cadastro.pessoa.entity.Telefone;
import br.com.athat.core.cadastro.pessoa.entity.endereco.Cidade;
import br.com.athat.core.cadastro.pessoa.entity.endereco.EstadoType;
import br.com.athat.core.cadastro.pessoa.entity.enuns.EnderecoType;
import br.com.athat.core.cadastro.pessoa.entity.enuns.PessoaType;
import br.com.athat.core.cadastro.pessoa.manager.CidadeManager;
import br.com.athat.core.cadastro.pessoa.manager.PessoaManager;
import br.com.athat.utils.validators.CpfCnpjValidator;
import br.com.athat.web.utils.AbstractController;

public class PessoaController extends AbstractController{
    
	private static final long serialVersionUID = 1L;

	private PessoaType tipoPessoa = PessoaType.FISICA;
    private String cpfCnpj = null;
    private Pessoa pessoa;
    private Endereco endereco;
    private Telefone telefone;
    private boolean renderCadEndereco;
    private boolean renderCadTelefone;
    private EstadoType estadoType;
    private boolean validar;
    private List<Cidade> cidades;
    
    @Autowired
    private PessoaManager pessoaManager;
    
    @Autowired
    private CidadeManager cidadeManager;

    public PessoaController() {
    	endereco = new Endereco();
    	endereco.setCidade(new Cidade());
    	telefone = new Telefone();
    	cidades = new ArrayList<Cidade>();
    }
    
    @PostConstruct
    public void init(){
		String id = getParametro("pessoaId");
		if (getParametro("pessoaId") != null) {
			pessoa = pessoaManager.buscarPorIdCompleto(Long.valueOf(id));
			cpfCnpj = pessoa.getCpfCnpj();
			tipoPessoa = pessoa.getPessoaType();
		}
    }

    
    public void buscaCpfCnpj(){
        if(CpfCnpjValidator.isValid(cpfCnpj)){   
            pessoa = pessoaManager.findByCpfCnpj(cpfCnpj);

            if(pessoa == null){
                pessoa = new Pessoa();
                pessoa.setEnderecos(new ArrayList<Endereco>());
                pessoa.setTelefones(new ArrayList<Telefone>());
                pessoa.setCpfCnpj(cpfCnpj);
                pessoa.setPessoaType(tipoPessoa);
            	}
            renderizaCadastros();
        }else{
            setMessage(FacesMessage.SEVERITY_WARN, null, "CPF / CNPJ inválido.");
        }
    }
    
    public void adicionarEndereco(){
    	pessoa.getEnderecos().add(endereco);
    	endereco = new Endereco();
    }
    
    public void adicionarTelefone(){
    	pessoa.getTelefones().add(telefone);
    	telefone = new Telefone();
    }
    
    public void removerEndereco(ActionEvent event){
    	pessoa.getEnderecos().remove(
    			event.getComponent().getAttributes().get("endereco"));
    	renderizaCadastros();
    }
    
    public void removerTelefone(ActionEvent event){
    	pessoa.getTelefones().remove(
    			event.getComponent().getAttributes().get("telefone"));
    	renderizaCadastros();
    }
    
    private void renderizaCadastros(){
    	if(pessoa == null || pessoa.getEnderecos().isEmpty())
    		renderCadEndereco = true;
    	if(pessoa == null || pessoa.getTelefones().isEmpty())
    		renderCadTelefone = true;
    }
    
    public void buscarCidades(){
    	cidades  = cidadeManager.buscarPorEstado(estadoType);
    }
    
    public List<SelectItem> getCidadeItens(){
    	List<SelectItem> itens = new LinkedList<SelectItem>();
    	for(Cidade cidade : cidades)
    		itens.add(new SelectItem(cidade,cidade.getNome()));
    	return itens;
    }
    
    public void validaListas(Pessoa p){
    	validar = false;
    	
    	validaEndereco(p);
    	validaTelefone(p);
    	
    	if(!validar)
    		return;
    }
    
    private void validaEndereco(Pessoa p){
    	if(p.getEnderecos().isEmpty()){
    		validar = false;
    		setMessage("Lista de Endereço não pode ser vazia.");
    	}else{
    		int principal = 0;
    		for(Endereco e : p.getEnderecos()){
    			if(e.getEnderecoType().equals(EnderecoType.PRINCIPAL)){
    				validar = true;
    				principal++;
    			}
    		}
    		if(principal > 1){
    			validar = false;
    			setMessage("Apenas deve conter 1 Endereco Principal.");
    		}	
    	}
    }
    
    private void validaTelefone(Pessoa p){
    	if(p.getTelefones().isEmpty()){
    		validar = false;
    		setMessage("Lista de Telefone não pode ser vazia.");
    	}else{
    		int principal = 0;
    		for(Telefone t : p.getTelefones()){
    			if(t.getEnderecoType().equals(EnderecoType.PRINCIPAL)){
    				validar = true;
    				principal++;
    			}
    		}
    		if(principal > 1){
    			validar = false;
    			setMessage("Apenas deve conter 1 Telefone Principal.");
    		}	
    	}	
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }
   
    public Pessoa getPessoa() {
        return pessoa;
    }

    public PessoaType getTipoPessoa() {
        return tipoPessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setTipoPessoa(PessoaType tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public boolean isRenderCadEndereco() {
		return renderCadEndereco;
	}

	public void setRenderCadEndereco(boolean renderCadEndereco) {
		this.renderCadEndereco = renderCadEndereco;
	}

	public boolean isRenderCadTelefone() {
		return renderCadTelefone;
	}

	public void setRenderCadTelefone(boolean renderCadTelefone) {
		this.renderCadTelefone = renderCadTelefone;
	}  
	
	public EstadoType getEstadoType() {
		return estadoType;
	}
	
	public void setEstadoType(EstadoType estadoType) {
		this.estadoType = estadoType;
	}
}
