package br.com.athat.core.manager.movimentacao.projeto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.projeto.Levantamento;
import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.core.manager.movimentacao.ItemProdutoManager;
import br.com.athat.core.vo.projeto.LenvamentoVO;

public class LevantamentoManagerImpl extends AbstractManagerImpl implements LevantamentoManager {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ItemProdutoManager itemProdutoManager;

	@Override
	@Transactional
	public void salvar(Orcamento orcamento) {
		if(orcamento.getId() == null) {
			getEntityManager().persist(orcamento);
		} else {
			getEntityManager().merge(orcamento);
		}
		itemProdutoManager.salvar(orcamento.getItensMovimentacao());
	}
	
	@Override
	@Transactional
	public void salvar(Levantamento levantamento) {
		if(levantamento.getId() == null) {
			getEntityManager().persist(levantamento);
		} else {
			getEntityManager().merge(levantamento);
		}
		itemProdutoManager.salvar(levantamento.getItensMovimentacao());
	}

	@Override
	@SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
	public List<Levantamento> buscar(LenvamentoVO levantamento) {
		Criteria criteria = createSession().createCriteria(Levantamento.class)
			.add(Restrictions.between("dataCadastro", levantamento.getDataInicio(), levantamento.getDataFim()))
	    ;	
//        if (compra.getSituacaoMovimentacaoType() != null) {
//            criteria.add(Restrictions.eq("situacaoMovimentacaoType", compra.getSituacaoMovimentacaoType()));
//        }
			
		if(levantamento.getId() != null) {
			criteria.add(Restrictions.eq("id", levantamento.getId()));
		}
	   
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)	
	public List<Levantamento> buscarOrcApresentacaoProjeto(Long idProjeto) {
		Criteria criteria = createSession().createCriteria(Levantamento.class, "l")
			.createAlias("projeto", "p")
			.add(Restrictions.eq("p.id", idProjeto))
			.add(Restrictions.ne("l.situacaoMovimentacaoType", SituacaoMovimentacaoType.CANCELADA))
		;

		for(Levantamento l : (List<Levantamento>) criteria.list()) {
			Hibernate.initialize(l.getItensMovimentacao());
		}
		return criteria.list();
	}

	@Override
	@Transactional(readOnly = true)	
	public Levantamento buscarLevantamentoPorIdFull(Long id) {
		Criteria criteria = createSession().createCriteria(Levantamento.class)
				.add(Restrictions.eq("id", id));
			Levantamento levantamento = (Levantamento) criteria.uniqueResult();
			Hibernate.initialize(levantamento.getItensMovimentacao());
			
			return levantamento;
	}

	@Override
	@Transactional(readOnly = true)	
	public Orcamento buscarOrcamentoPorIdFull(Long id) {
		Criteria criteria = createSession().createCriteria(Orcamento.class)
				.add(Restrictions.eq("id", id));
			Orcamento orcamento = (Orcamento) criteria.uniqueResult();
			Hibernate.initialize(orcamento.getItensMovimentacao());
			
			return orcamento;
	}
}
