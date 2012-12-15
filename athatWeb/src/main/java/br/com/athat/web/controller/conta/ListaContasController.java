package br.com.athat.web.controller.conta;

import br.com.athat.core.entity.conta.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.manager.conta.ContaAPagarManager;
import br.com.athat.core.manager.conta.ContaAReceberManager;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.web.utils.AbstractController;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

public class ListaContasController extends AbstractController {

    private static final long serialVersionUID = 1L;
    private List<Conta> contasAPagar= new ArrayList<Conta>();
    private List<Conta> contasAReceber= new ArrayList<Conta>();
   
    @Autowired
    private ContaAPagarManager contaAPagarManager;
    
    @Autowired
    private ContaAReceberManager contaAReceberManager;
    
    private ListaContasController() {

        

    }
        @PostConstruct
    public void init(){
        contasAPagar = contaAPagarManager.buscarContaAberta();
        if(contasAPagar == null)
            contasAPagar = new ArrayList<Conta>();
        contasAReceber = contaAReceberManager.buscarContaAberta();
        if(contasAReceber == null)
            contasAReceber = new ArrayList<Conta>();	
    }

    public ContaAReceberManager getContaAReceberManager() {
        return contaAReceberManager;
    }

    public void setContaAReceberManager(ContaAReceberManager contaAReceberManager) {
        this.contaAReceberManager = contaAReceberManager;
    }

    public List<Conta> getContasAPagar() {
        return contasAPagar;
    }

    public void setContasAPagar(List<Conta> contasAPagar) {
        this.contasAPagar = contasAPagar;
    }

    public List<Conta> getContasAReceber() {
        return contasAReceber;
    }

    public void setContasAReceber(List<Conta> contasAReceber) {
        this.contasAReceber = contasAReceber;
    }

    public ContaAPagarManager getContaAPagarManager() {
        return contaAPagarManager;
    }

    public void setContaAPagarManager(ContaAPagarManager contaAPagarManager) {
        this.contaAPagarManager = contaAPagarManager;
    }
    
}
