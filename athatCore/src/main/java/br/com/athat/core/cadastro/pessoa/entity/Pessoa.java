package br.com.athat.core.cadastro.pessoa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.com.athat.core.cadastro.pessoa.entity.enuns.PessoaType;
import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Pessoa extends AbstractEntity{
    
	private static final long serialVersionUID = 1L;

	@Column(length = 20, nullable=false)
    private String cpfCnpj;
    
    @Column(length = 100, nullable=false)
    private String nomeRazao;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos;
    
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefone> telefones;

	@Enumerated(EnumType.STRING )
    private PessoaType pessoaType;
   
    public String getCpfCnpj() {
        return cpfCnpj;
    }
   
    public String getNomeRazao() {
        return nomeRazao;
    }
    
    public PessoaType getPessoaType() {
        return pessoaType;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public void setPessoaType(PessoaType pessoaType) {
        this.pessoaType = pessoaType;
    }

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
}
