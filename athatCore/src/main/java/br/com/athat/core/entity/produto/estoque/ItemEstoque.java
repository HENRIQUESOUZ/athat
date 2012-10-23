package br.com.athat.core.entity.produto.estoque;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import br.com.athat.core.entity.AbstractEntity;

@Entity
public class ItemEstoque extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
    private BigDecimal valorCusto;
	
	@Column(length=70)
	private String identificacao;
	
	private Integer quantidadeDesmenbrada = 0;
    
    public BigDecimal getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(BigDecimal valorCusto) {
        this.valorCusto = valorCusto;
    }

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public Integer getQuantidadeDesmenbrada() {
		return quantidadeDesmenbrada;
	}

	public void setQuantidadeDesmenbrada(Integer quantidadeDesmenbrada) {
		this.quantidadeDesmenbrada = quantidadeDesmenbrada;
	}
}
