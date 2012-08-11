package br.com.athat.core.cadastro.pessoa.cliente.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.athat.core.cadastro.pessoa.entity.Papel;

@Entity
public class Cliente extends Papel{
    
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
    private Date dataAniversario;

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    
}
