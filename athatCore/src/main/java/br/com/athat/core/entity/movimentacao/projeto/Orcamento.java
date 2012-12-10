package br.com.athat.core.entity.movimentacao.projeto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import br.com.athat.core.entity.movimentacao.enuns.OrcamentoType;
import br.com.athat.core.entity.pessoa.funcionario.Funcionario;

public class Orcamento extends Levantamento {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Funcionario funcionario;
	
	@Column(length = 2000)
	private String observacao;
	
	public Orcamento() {
		this.orcamentoType = OrcamentoType.ORCAMENTO;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
