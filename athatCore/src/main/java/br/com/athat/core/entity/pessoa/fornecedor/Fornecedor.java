package br.com.athat.core.entity.pessoa.fornecedor;

import javax.persistence.Entity;

import br.com.athat.core.entity.pessoa.Papel;
import br.com.athat.core.entity.pessoa.enuns.FornecedorType;

@Entity
public class Fornecedor extends Papel {
    
	private static final long serialVersionUID = 1L;

	private FornecedorType fornecedorType;

    public FornecedorType getFornecedorType() {
        return fornecedorType;
    }

    public void setFornecedorType(FornecedorType fornecedorType) {
        this.fornecedorType = fornecedorType;
    }
    
    
    
}
