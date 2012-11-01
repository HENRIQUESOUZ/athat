package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.Conta;
import br.com.athat.core.entity.conta.ContaAPagar;
import br.com.athat.core.entity.conta.ContaAReceber;
import br.com.athat.core.entity.conta.ContaType;
import br.com.athat.core.entity.conta.SituacaoContaType;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.venda.Venda;
import br.com.athat.core.manager.AbstractManager;

public class ContaManagerImpl extends AbstractManager implements ContaManager {


	private static final long serialVersionUID = 1L;

	private Conta conta;
	private ParcelaManager parcelaManager;

	public ContaManagerImpl(Compra movimentacao, ContaType tipoConta){
		if(movimentacao.getConta() == null){
		this.conta = new ContaAPagar();
		this.conta.setValorTotal(movimentacao.getValorTotal());
		this.conta.setSituacao(SituacaoContaType.ABERTA);
		this.conta.setMovimentacao(movimentacao);
		this.conta.setTipoConta(tipoConta);
		movimentacao.setConta(this.conta);
		
		} else{
			this.conta = movimentacao.getConta();
		}
//		if(conta.getParcelas() == null){
//			 parcelaManager = new ParcelaManagerImpl(conta);
//		}
	}
	public ContaManagerImpl(Venda movimentacao, ContaType tipoConta){
		if(movimentacao.getConta() == null){
		this.conta = new ContaAReceber();
		this.conta.setValorTotal(movimentacao.getValorTotal());
		this.conta.setSituacao(SituacaoContaType.ABERTA);
		this.conta.setMovimentacao(movimentacao);
		this.conta.setTipoConta(tipoConta);
		movimentacao.setConta(this.conta);
		
		} else{
			this.conta = movimentacao.getConta();
		}
//		if(conta.getParcelas() == null){
//			 parcelaManager = new ParcelaManagerImpl(conta);
//		}
	}
	
	
	public void salvar() {
		if(conta.getId() == null)
            getEntityManager().persist(conta);
        else
            getEntityManager().merge(conta);

	}

	
	public void gerarParcelas(int numeroParcelas) {
		
	}

	
	public ParcelaManager getParcelas() {
		// TODO Auto-generated method stub
		return null;
	}

}
