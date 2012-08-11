package br.com.athat.core.cadastro.pessoa.entity.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Cidade extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Column(length=100,nullable=false)
    private String nome;
    
    @Column(length=20,nullable=false)
    private String ibge;
    
    @Enumerated
    private EstadoType estadoType;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

	public EstadoType getEstadoType() {
		return estadoType;
	}

	public void setEstadoType(EstadoType estadoType) {
		this.estadoType = estadoType;
	}
}
