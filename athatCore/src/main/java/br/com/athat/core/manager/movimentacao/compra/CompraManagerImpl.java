package br.com.athat.core.manager.movimentacao.compra;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoEntradaType;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.pedido.PedidoCompra;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.core.manager.pedido.PedidoCompraManager;
import br.com.athat.core.manager.produto.estoque.EstoqueManager;
import br.com.athat.core.vo.compra.CompraVO;

public class CompraManagerImpl extends AbstractManagerImpl implements CompraManager {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private EstoqueManager estoqueManager;
    
    @Autowired
    private PedidoCompraManager pedidoCompraManager;

    @Transactional
    public Compra salvar(Compra compra) {
        if (compra.getId() == null) {
            compra.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.ABERTA);
            compra.setSituacaoEntradaType(SituacaoEntradaType.AGUARDANDO);
            getEntityManager().persist(compra);
        } else {
            getEntityManager().merge(compra);
            getEntityManager().flush();
        }
        
        return compra;
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Compra> buscar(CompraVO compra) {
        Criteria criteria = createSession().createCriteria(Compra.class)
        		.add(Restrictions.between("dataCadastro", compra.getDataInicioCompra(), compra.getDataFimCompra()))
        		.add(Restrictions.between("dataEmissaoNF", compra.getDataInicioNF(), compra.getDataFimNF()))
        ;

//        if (compra.getSituacaoMovimentacaoType() != null) {
//            criteria.add(Restrictions.eq("situacaoMovimentacaoType", compra.getSituacaoMovimentacaoType()));
//        }
//        
//        if (compra.getSituacaoEntradaType() != null) {
//            criteria.add(Restrictions.eq("situacaoEntradaType", compra.getSituacaoEntradaType()));
//        }

        if (compra.getFornecedor() != null && compra.getFornecedor().getId() != null) {
            criteria.createAlias("fornecedor", "for");
            criteria.add(Restrictions.eq("for.id", compra.getFornecedor().getId()));
        }

        return criteria.list();
    }

	@Override
	@Transactional
	public void entrada(Compra compra) {
		for(ItemProduto it : compra.getItensMovimentacao()) {
			estoqueManager.entrar(it);
		}
		getEntityManager().merge(compra);
	}

	@Override
	@Transactional(readOnly = true)
	public Compra buscarCompraPorIdFull(Long id) {
		Compra compra = getEntityManager().find(Compra.class, id);
		Hibernate.initialize(compra.getItensMovimentacao());
		return compra;
	}

	@Override
	@Transactional
	public void salvar(List<Compra> compras, PedidoCompra pedidoCompra) {
		for(Compra c : compras) {
			salvar(c);
		}
		pedidoCompra.setDataEncerramento(new Date());
		pedidoCompraManager.salvar(pedidoCompra);
	}
}
