package br.com.athat.web.controller.conta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.conta.ContaAReceber;
import br.com.athat.core.entity.conta.Parcela;
import br.com.athat.core.entity.conta.SituacaoContaType;
import br.com.athat.core.entity.conta.financeiro.Lancamento;
import br.com.athat.core.entity.conta.financeiro.MovimentoType;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.venda.Venda;
import br.com.athat.core.manager.conta.ContaAReceberManager;
import br.com.athat.core.manager.movimentacao.venda.VendaManager;
import br.com.athat.web.utils.AbstractController;
import java.util.Date;
import javax.faces.application.FacesMessage;

public class ContaAReceberController extends AbstractController {

    private static final long serialVersionUID = 1L;
    private ContaAReceber contaAReceber;
    private Venda venda;
    private List<Parcela> parcelas;
    private int numParcelas;
    private Date dataInicial;
    @Autowired
    private VendaManager vendaManager;
    @Autowired
    private ContaAReceberManager contaAReceberManager;

    private ContaAReceberController() {
        init();
    }

    private void init() {
//        if (compra == null) {
//            compra = new Venda();
//            compra.setValorTotal(BigDecimal.ZERO);
//        }
//        contaAReceberManager = new ContaAReceberManagerImpl();
        contaAReceber = new ContaAReceber();
        contaAReceber.setMovimentacao(venda);
        contaAReceber.setSituacao(SituacaoContaType.ABERTA);
        contaAReceber.setValorTotal(BigDecimal.ZERO);
        parcelas = new ArrayList<Parcela>();
        contaAReceber.setParcelas(parcelas);


    }

    public String limpar() {
        init();
        return "/pages/conta/ContaAReceber";
    }

    public String gerarParcelas() {
        contaAReceber.setMovimentacao(venda);
        contaAReceber.setValorTotal(venda.getValorTotal());
        BigDecimal valorParcela;
        parcelas = new ArrayList<Parcela>();
        if (validateParcelas()) {
            valorParcela = venda.getValorTotal().divide(BigDecimal.valueOf(numParcelas), 2);
            for (int i = 0; i < numParcelas; i++) {
                Parcela parcela = new Parcela();
                Lancamento lancamento = new Lancamento();
                Calendar dtPgto =  Calendar.getInstance();
                dtPgto.setTime(dataInicial);
                dtPgto.add(Calendar.MONTH, i);
                lancamento.setTipoMovimento(MovimentoType.DEBITO);
                lancamento.setValor(valorParcela);
                lancamento.setParcela(parcela);

                parcela.setLancamento(lancamento);
                parcela.setSituacao(SituacaoContaType.ABERTA);
                parcela.setConta(contaAReceber);
                parcela.setNumParcela(i + 1);
                parcela.setDataPagamento(dtPgto.getTime());
                parcelas.add(i, parcela);

            }
        }
        contaAReceber.setParcelas(parcelas);
        return "/pages/conta/contaAReceber";
    }

    private boolean validateParcelas() {
        boolean validate = true;
        if (venda == null) {
            setMessage(FacesMessage.SEVERITY_INFO, null, "Problemas com a Movimentação em questão");
            validate = false;
        }

        if ( numParcelas == 0) {
            setMessage(FacesMessage.SEVERITY_INFO, null, "Campo Numero de Parcela Obrigatório");
            validate = false;
        }
        
        if (dataInicial == null) {
            setMessage(FacesMessage.SEVERITY_INFO, null, "Campo Data Inicial Obrigatório");
            validate = false;
        }
        return validate;

    }

    public String salvar() {
        try {
            if (validateSalvar()) {

                venda.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.FECHADA);
                venda.setContaAReceber(contaAReceber);
		vendaManager.salvar(venda);

                getMessageCadastroSucesso();
            } 
        } catch (Exception e) {
            getMessageInstabilidade();
            e.printStackTrace();
        }

        return "/pages/conta/contaAReceber";
    }
    private boolean validateSalvar(){
        boolean validate = validateParcelas();
        if(parcelas.size() == 0){
            setMessage(FacesMessage.SEVERITY_INFO, null, "Dados Imnompletos");
            validate = false;
        }
        return validate;
             
    }
    
    public ContaAReceber getContaAReceber() {
        return contaAReceber;
    }

    public void setContaAReceber(ContaAReceber contaAReceber) {
        this.contaAReceber = contaAReceber;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public VendaManager getVendaManager() {
        return vendaManager;
    }

    public void setVendaManager(VendaManager vendaManager) {
        this.vendaManager = vendaManager;
    }

    public ContaAReceberManager getContaAReceberManager() {
        return contaAReceberManager;
    }

    public void setContaAReceberManager(ContaAReceberManager contaAReceberManager) {
        this.contaAReceberManager = contaAReceberManager;
    }
}
