package br.com.athat.web.controller.conta;

import br.com.athat.core.entity.conta.*;
import br.com.athat.core.entity.movimentacao.Movimentacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.manager.conta.ContaAPagarManager;
import br.com.athat.core.manager.conta.ContaAReceberManager;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.web.utils.AbstractController;

public class BaixarParcelaController extends AbstractController {

    private static final long serialVersionUID = 1L;
    private Conta conta;
    private Parcela parcelaABaixar;
    @Autowired
    private CompraManager compraManager;
    @Autowired
    private ContaAPagarManager contaAPagarManager;
    @Autowired
    private ContaAReceberManager contaAReceberManager;

    private BaixarParcelaController() {
    }


    private boolean validateSalvar() {
        boolean validate = true;
        return validate;

    }

    public void quitar() {
        for (Parcela parcela : conta.getParcelas()) {
            if (parcela.getId() == parcelaABaixar.getId()) {
                parcela.setSituacao(SituacaoContaType.QUITADA);
            }
        }
    }

    public void desquitar() {
        for (Parcela parcela : conta.getParcelas()) {
            if (parcela.getId() == parcelaABaixar.getId()) {
                parcela.setSituacao(SituacaoContaType.ABERTA);
            }
        }
    }

    public String salvar() {
        try {
            if (validateSalvar()) {
                if (conta.getTipoConta() == ContaType.PAGAR) {
                    contaAPagarManager.salvar((ContaAPagar) conta, null);
                } else {
                    contaAReceberManager.salvar((ContaAReceber) conta);
                }
                getMessageCadastroSucesso();
            }
        } catch (Exception e) {
            getMessageInstabilidade();
            e.printStackTrace();
        }

        return "/pages/conta/contaAPagar";
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
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

    public ContaAReceberManager getContaAReceberManager() {
        return contaAReceberManager;
    }

    public void setContaAReceberManager(ContaAReceberManager contaAReceberManager) {
        this.contaAReceberManager = contaAReceberManager;
    }

    public Parcela getParcelaABaixar() {
        return parcelaABaixar;
    }

    public void setParcelaABaixar(Parcela parcelaABaixar) {
        this.parcelaABaixar = parcelaABaixar;
    }
}
