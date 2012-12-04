package br.com.athat.web.controller.conta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.conta.ContaAPagar;
import br.com.athat.core.entity.conta.Parcela;
import br.com.athat.core.entity.conta.SituacaoContaType;
import br.com.athat.core.entity.conta.financeiro.Lancamento;
import br.com.athat.core.entity.conta.financeiro.MovimentoType;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.manager.conta.ContaAPagarManager;
import br.com.athat.core.manager.conta.ContaAPagarManagerImpl;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.web.utils.AbstractController;

public class ContaAPagarController extends AbstractController {

	private static final long serialVersionUID = 1L;

	private ContaAPagar contaAPagar;
	private Compra compra;
	private List<Parcela> parcelas;
	private Integer numParcelas;
	private Calendar dataInicial;
	@Autowired
	private CompraManager compraManager;
	private ContaAPagarManager contaAPagarManager;

	private ContaAPagarController() {
		init();
	}

	private void init() {
		contaAPagarManager = new ContaAPagarManagerImpl();
		contaAPagar = new ContaAPagar();
		contaAPagar.setMovimentacao(compra);
		contaAPagar.setSituacao(SituacaoContaType.ABERTA);
		contaAPagar.setValorTotal(compra.getValorTotal());
		parcelas = new ArrayList<Parcela>();
		contaAPagar.setParcelas(parcelas);

	}
	public void gerarParcelas(){
		BigDecimal valorParcela;
		if(validateParcelas()){
			valorParcela = contaAPagar.getValorTotal().divide(BigDecimal.valueOf(numParcelas),2);
			for(int i=0;i<numParcelas;i++){
				Parcela parcela = new Parcela();
				Lancamento lancamento = new Lancamento();
				Calendar dtPgto=dataInicial;
				dtPgto.add(Calendar.MONTH, i);
				lancamento.setTipoMovimento(MovimentoType.DEBITO);
				lancamento.setValor(valorParcela);
				lancamento.setParcela(parcela);
				
				parcela.setLancamento(lancamento);
				parcela.setSituacao(SituacaoContaType.ABERTA);
				parcela.setConta(contaAPagar);
				parcela.setNumParcela (i+1);
				parcela.setDataPagamento(dtPgto.getTime());
				parcelas.add(i,parcela);
				
			}
		}
		contaAPagar.setParcelas(parcelas);
	}

	private boolean validateParcelas() {
		if(compra != null )
			if(numParcelas != null && numParcelas != 0)
				if (dataInicial !=null) 
					return true;
		return false;
		
	}

	public String salvar() {
		try {
			if (validateParcelas() && parcelas.size()>0) {
				contaAPagarManager.salvar(contaAPagar);
				getMessageCadastroSucesso();
			}
		} catch (Exception e) {
			getMessageInstabilidade();
			e.printStackTrace();
		}

		return "/pages/conta/conta_a_pagar";
	}

	public ContaAPagar getContaAPagar() {
		return contaAPagar;
	}

	public void setContaAPagar(ContaAPagar contaAPagar) {
		this.contaAPagar = contaAPagar;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public CompraManager getCompraManager() {
		return compraManager;
	}

	public void setCompraManager(CompraManager compraManager) {
		this.compraManager = compraManager;
	}

	public ContaAPagarManager getContaAPagarManager() {
		return contaAPagarManager;
	}

	public void setContaAPagarManager(ContaAPagarManager contaAPagarManager) {
		this.contaAPagarManager = contaAPagarManager;
	}
}
