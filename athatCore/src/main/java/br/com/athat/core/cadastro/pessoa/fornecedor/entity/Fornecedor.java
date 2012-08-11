package br.com.athat.core.cadastro.pessoa.fornecedor.entity;

import javax.persistence.Entity;

import br.com.athat.core.cadastro.pessoa.entity.Papel;
import br.com.athat.core.cadastro.pessoa.entity.enuns.FornecedorType;

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
