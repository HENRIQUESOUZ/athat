package br.com.athat.web.movimentacao.compra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.core.manager.produto.ProdutoManager;
import br.com.athat.core.manager.produto.tabelaPreco.TabelaPrecoManager;
import br.com.athat.web.utils.AbstractController;

public class CompraController extends AbstractController {

    private static final long serialVersionUID = 1L;
    private Compra compra;
    private ItemProduto itemProduto;
    private List<Produto> produtos;
    @Autowired
    private CompraManager compraManager;
    @Autowired
    private ProdutoManager produtoManager;

	@Autowired
	private TabelaPrecoManager tabelaPrecoManager;

    public CompraController() {
        init();
    }

    public void removerProduto() {
        compra.getItensMovimentacao().remove(itemProduto);
        itemProduto = new ItemProduto();
        calculaValorTotal();
    }

    public String salvar() {
        try {
            if (validade()) {
                compraManager.salvar(compra);
                getMessageCadastroSucesso();
            }
        } catch (Exception e) {
            getMessageInstabilidade();
            e.printStackTrace();
        }

        return "/pages/movimentacao/compra";
    }

    public String finalizar() {
        try {
            if (validade()) {
                compraManager.salvar(compra);
                setMessage("Compra Finalizada com Sucesso!");
                init();
                return "/pages/conta/contaAPagar";
            }
        } catch (Exception e) {
            getMessageInstabilidade();
            e.printStackTrace();
        }
        return "/pages/movimentacao/compra  ";
    }

    public void validaFornecedor(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Fornecedor fornecedor = (Fornecedor) event.getComponent().getAttributes().get("pessoa");
        if (fornecedor == null) {
            context.addCallbackParam("confirmar", false);
            setMessage("Fornecedor não selecionado.");
        } else {
            context.addCallbackParam("confirmar", true);
            compra.setFornecedor(fornecedor);
        }
    }

    public void adicionarProduto(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Produto produto = (Produto) event.getComponent().getAttributes().get("produto");
        if (produto == null) {
            context.addCallbackParam("confirmar", false);
            setMessage("Produto não selecionada.");
        } else {
            context.addCallbackParam("confirmar", true);
            itemProduto.setProduto(produto);
            compra.getItensMovimentacao().add(itemProduto);
            itemProduto = new ItemProduto();
        }
    }

    public String limpar() {
        init();
        return "/pages/movimentacao/compra";
    }

    public void calculaValorTotal() {
        BigDecimal valor = BigDecimal.ZERO;
        for (ItemProduto it : compra.getItensMovimentacao()) {
            valor = valor.add(it.getValorTotal());
        }
        compra.setValorTotal(valor);
    }

    private void init() {
        compra = new Compra();
        compra.setFornecedor(new Fornecedor());
        compra.getFornecedor().setPessoa(new Pessoa());
        compra.setItensMovimentacao(new ArrayList<ItemProduto>());
        compra.setValorTotal(BigDecimal.ZERO);
        produtos = new ArrayList<Produto>();
        itemProduto = new ItemProduto();
    }

    private boolean validade() {
        if (compra.getValorTotal().compareTo(BigDecimal.ZERO) <= 0) {
            setMessage(FacesMessage.SEVERITY_INFO, null, "Compra com valor total zero.");
            return false;
        }

        for (ItemProduto it : compra.getItensMovimentacao()) {
            if (it.getValorTotal().compareTo(BigDecimal.ZERO) <= 0) {
                setMessage(FacesMessage.SEVERITY_INFO, null, "Produto(s) com valor total zero.");
                return false;
            }
        }

        return true;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public ItemProduto getItemProduto() {
        return itemProduto;
    }

    public void setItemProduto(ItemProduto itemProduto) {
        this.itemProduto = itemProduto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public CompraManager getCompraManager() {
        return compraManager;
    }

    public void setCompraManager(CompraManager compraManager) {
        this.compraManager = compraManager;
    }

    public ProdutoManager getProdutoManager() {
        return produtoManager;
    }

    public void setProdutoManager(ProdutoManager produtoManager) {
        this.produtoManager = produtoManager;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
