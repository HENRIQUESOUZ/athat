package br.com.athat.core.entity.pessoa.funcionario;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.athat.core.entity.pessoa.Papel;

@Entity
public class Funcionario extends Papel{
    
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date dataContratacao;
        
    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
