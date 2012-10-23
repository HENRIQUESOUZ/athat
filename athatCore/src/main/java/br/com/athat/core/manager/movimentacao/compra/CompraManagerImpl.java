package br.com.athat.core.manager.movimentacao.compra;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.manager.produto.estoque.EstoqueManager;
import org.springframework.beans.factory.annotation.Autowired;

public class CompraManagerImpl extends AbstractManager implements CompraManager {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private EstoqueManager estoqueManager;

    @Transactional
    public Compra salvar(Compra compra) {
        
        for(ItemProduto itemProduto : compra.getItensMovimentacao()){
            estoqueManager.entrar(itemProduto);           
        }
        
        if (compra != null) {
            compra.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.ABERTA);
            getEntityManager().persist(compra);
        } else {
            getEntityManager().merge(compra);
        }
        
        return compra;
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Compra> buscar(Compra compra) {
        Criteria criteria = createSession().createCriteria(Compra.class);

        if (compra.getDataCadastro() != null) {
            criteria.add(Restrictions.eq("dataCadastro", compra.getDataCadastro()));
        }

        if (compra.getDataEmissaoNF() != null) {
            criteria.add(Restrictions.eq("dataEmissaoNF", compra.getDataEmissaoNF()));
        }

        if (compra.getSituacaoMovimentacaoType() != null) {
            criteria.add(Restrictions.eq("situacaoMovimentacao", compra.getSituacaoMovimentacaoType()));
        }

        if (compra.getFornecedor().getId() != null) {
            criteria.createAlias("fornecedor", "for");
            criteria.add(Restrictions.eq("for.id", compra.getFornecedor().getId()));
        }

        return criteria.list();
    }
}
