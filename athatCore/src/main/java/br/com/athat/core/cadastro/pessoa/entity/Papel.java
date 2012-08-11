package br.com.athat.core.cadastro.pessoa.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import br.com.athat.core.entity.AbstractEntity;

@MappedSuperclass
public abstract class Papel extends AbstractEntity{
    
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional=false, cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
