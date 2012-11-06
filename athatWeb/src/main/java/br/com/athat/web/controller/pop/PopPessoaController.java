package br.com.athat.web.controller.pop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.pessoa.Papel;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.core.entity.pessoa.funcionario.Funcionario;
import br.com.athat.core.manager.pessoa.PessoaManager;
import br.com.athat.utils.validators.ValidatorUtils;
import br.com.athat.web.utils.AbstractController;

public class PopPessoaController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
		private String id;
	    private String cpfCnpj;
	    private String razaoSocial;
	   
	    private String papel;
	    
	    private boolean disableCliente;
	    private boolean disableFornecedor;
	    private boolean disableFuncionario;
	    private boolean selectCliente;
	    private boolean selectFornecedor;
	    private boolean selectFuncionario;
	    
	    private Papel pessoa;
	    
	    private List<Papel> pessoas;
	    
	    @Autowired
	    private PessoaManager pessoaManager;

	    public PopPessoaController() {
	    	pessoas = new ArrayList<Papel>();
	    	limpar();
		}
	    
	    public void buscarPessoa() {
	    	if (papel.equals("cliente")) {
	    		pessoas = pessoaManager.buscaGenericaPop(ValidatorUtils.convertStringToLong(id), cpfCnpj, razaoSocial, new Cliente());
	    	} else if (papel.equals("fornecedor")) {
	    		pessoas = pessoaManager.buscaGenericaPop(ValidatorUtils.convertStringToLong(id), cpfCnpj, razaoSocial, new Fornecedor());
	    	} else if (papel.equals("funcionario")) {
	    		pessoas = pessoaManager.buscaGenericaPop(ValidatorUtils.convertStringToLong(id), cpfCnpj, razaoSocial, new Funcionario());
	    	} else {
	    		setMessage("Selecione um tipo de pessoa!");
	    	}	
	    }

	    public void limpar() {
	    	papel = "";
	    	id = "";
		    cpfCnpj = "";
		    razaoSocial = "";
	    }
	    
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCpfCnpj() {
			return cpfCnpj;
		}

		public void setCpfCnpj(String cpfCnpj) {
			this.cpfCnpj = cpfCnpj;
		}

		public String getRazaoSocial() {
			return razaoSocial;
		}

		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}

		public boolean isDisableCliente() {
			return disableCliente;
		}

		public void setDisableCliente(boolean disableCliente) {
			this.disableCliente = disableCliente;
		}

		public boolean isDisableFornecedor() {
			return disableFornecedor;
		}

		public void setDisableFornecedor(boolean disableFornecedor) {
			this.disableFornecedor = disableFornecedor;
		}

		public boolean isDisableFuncionario() {
			return disableFuncionario;
		}

		public void setDisableFuncionario(boolean disableFuncionario) {
			this.disableFuncionario = disableFuncionario;
		}

		public List<Papel> getPessoas() {
			return pessoas;
		}

		public void setPessoas(List<Papel> pessoas) {
			this.pessoas = pessoas;
		}

		public PessoaManager getPessoaManager() {
			return pessoaManager;
		}

		public void setPessoaManager(PessoaManager pessoaManager) {
			this.pessoaManager = pessoaManager;
		}

		public String getPapel() {
			return papel;
		}
		
		public void setPapel(String papel) {
			this.papel = papel;
		}
		
		public Papel getPessoa() {
			return pessoa;
		}
		
		public void setPessoa(Papel pessoa) {
			this.pessoa = pessoa;
		}

		public boolean isSelectCliente() {
			return selectCliente;
		}

		public void setSelectCliente(boolean selectCliente) {
			this.selectCliente = selectCliente;
		}

		public boolean isSelectFornecedor() {
			return selectFornecedor;
		}

		public void setSelectFornecedor(boolean selectFornecedor) {
			this.selectFornecedor = selectFornecedor;
		}

		public boolean isSelectFuncionario() {
			return selectFuncionario;
		}

		public void setSelectFuncionario(boolean selectFuncionario) {
			this.selectFuncionario = selectFuncionario;
		}
}
