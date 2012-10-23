package br.com.athat.core.entity.produto.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import br.com.athat.core.entity.produto.ProdutoType;

@Entity
public class Categoria  extends AbstractCategoria{

	private static final long serialVersionUID = 1L;

	@Column(length = 100,nullable = false)
    private String descricao;
    
    @Enumerated
    private UnidadeMedidaType unidadeMedidaType;
    
    @Enumerated
	private ProdutoType produtoType;
    
    @Enumerated
    private IdentificacaoType identificacaoType;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public UnidadeMedidaType getUnidadeMedidaType() {
		return unidadeMedidaType;
	}

	public void setUnidadeMedidaType(UnidadeMedidaType unidadeMedidaType) {
		this.unidadeMedidaType = unidadeMedidaType;
	}

	public ProdutoType getProdutoType() {
		return produtoType;
	}

	public void setProdutoType(ProdutoType produtoType) {
		this.produtoType = produtoType;
	}

	public IdentificacaoType getIdentificacaoType() {
		return identificacaoType;
	}

	public void setIdentificacaoType(IdentificacaoType identificacaoType) {
		this.identificacaoType = identificacaoType;
	}
}
