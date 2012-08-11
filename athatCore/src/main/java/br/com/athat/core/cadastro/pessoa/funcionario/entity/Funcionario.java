package br.com.athat.core.cadastro.pessoa.funcionario.entity;

import java.util.Date;

import javax.persistence.Entity;

import br.com.athat.core.cadastro.pessoa.entity.Papel;

@Entity
public class Funcionario extends Papel{
    
	private static final long serialVersionUID = 1L;

	private Date dataContratacao;

        
    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    
    
    
}
