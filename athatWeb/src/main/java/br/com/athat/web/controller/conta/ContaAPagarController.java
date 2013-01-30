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
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.manager.conta.ContaAPagarManager;
import br.com.athat.core.manager.conta.ContaAPagarManagerImpl;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.web.utils.AbstractController;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ContaAPagarController extends AbstractController {

    private static final long serialVersionUID = 1L;
    private ContaAPagar contaAPagar;
    private Compra compra;
    private List<Parcela> parcelas;
    private int numParcelas;
    private Date dataInicial;
    
    @Autowired
    private CompraManager compraManager;
    
    @Autowired
    private ContaAPagarManager contaAPagarManager;

    private ContaAPagarController() {
        init();
    }

    private void init() {
//        if (compra == null) {
//            compra = new Compra();
//            compra.setValorTotal(BigDecimal.ZERO);
//        }
//        contaAPagarManager = new ContaAPagarManagerImpl();
        contaAPagar = new ContaAPagar();
        contaAPagar.setMovimentacao(compra);
        contaAPagar.setSituacao(SituacaoContaType.ABERTA);
        contaAPagar.setValorTotal(BigDecimal.ZERO);
        parcelas = new ArrayList<Parcela>();
        contaAPagar.setParcelas(parcelas);


    }

    public String limpar() {
        init();
        return "/pages/conta/ContaAPagar";
    }

    public String gerarParcelas() {
        contaAPagar.setMovimentacao(compra);
        contaAPagar.setValorTotal(compra.getValorTotal());
        BigDecimal valorParcela;
        parcelas = new ArrayList<Parcela>();
        if (validateParcelas()) {
            valorParcela = compra.getValorTotal().divide(new BigDecimal(numParcelas), 2, RoundingMode.HALF_EVEN);
            for (int i = 0; i < numParcelas; i++) {
                Parcela parcela = new Parcela();
                System.out.println(valorParcela);
                Lancamento lancamento = new Lancamento();
                Calendar dtPgto = Calendar.getInstance();
                dtPgto.setTime(dataInicial);
                dtPgto.add(Calendar.MONTH, i);
                lancamento.setTipoMovimento(MovimentoType.DEBITO);
                lancamento.setValor(valorParcela);
                lancamento.setParcela(parcela);

                parcela.setLancamento(lancamento);
                parcela.setSituacao(SituacaoContaType.ABERTA);
                parcela.setConta(contaAPagar);
                parcela.setNumParcela(i + 1);
                parcela.setDataPagamento(dtPgto.getTime());
                parcelas.add(i, parcela);

            }
        }
        contaAPagar.setParcelas(parcelas);
        return "/pages/conta/contaAPagar";
    }

    private boolean validateParcelas() {
        boolean validate = true;
        if (compra == null) {
            setMessage(FacesMessage.SEVERITY_INFO, null, "Problemas com a Movimentação em questão");
            validate = false;
        }

        if (numParcelas <= 0) {
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
                compra.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.FECHADA);
                compra.setContaAPagar(contaAPagar);
                contaAPagarManager.salvar(contaAPagar, compra);
                getMessageCadastroSucesso();
            }
        } catch (Exception e) {
            getMessageInstabilidade();
            e.printStackTrace();
        }

        return "/pages/conta/contaAPagar";
    }

    private boolean validateSalvar() {
        boolean validate = validateParcelas();
        if (parcelas.size() == 0) {
            setMessage(FacesMessage.SEVERITY_INFO, null, "Dados Incompletos");
            validate = false;
        }
        return validate;

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
