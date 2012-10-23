package br.com.athat.core.entity.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public abstract class Categoria  extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Column(length = 100,nullable = false)
    private String descricao;
    
    @ManyToOne
    private Categoria categoria;

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
