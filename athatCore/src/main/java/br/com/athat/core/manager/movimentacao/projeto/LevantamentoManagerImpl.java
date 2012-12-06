package br.com.athat.core.manager.movimentacao.projeto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.projeto.Levantamento;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.core.vo.projeto.LevantamentoVO;

public class LevantamentoManagerImpl extends AbstractManagerImpl implements LevantamentoManager {

	private static final long serialVersionUID = 1L;

	@Override
	@Transactional
	public void salvar(Levantamento levantamento) {
		if(levantamento.getId() == null) {
			getEntityManager().persist(levantamento);
		} else {
			getEntityManager().merge(levantamento);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
	public List<Levantamento> buscar(LevantamentoVO levantamento) {
		Criteria criteria = createSession().createCriteria(Compra.class)
				.add(Restrictions.between("dataCadastro", levantamento.getDataInicio(), levantamento.getDataFim()))
	        	
//        if (compra.getSituacaoMovimentacaoType() != null) {
//            criteria.add(Restrictions.eq("situacaoMovimentacaoType", compra.getSituacaoMovimentacaoType()));
//        }
	     ;
		 return criteria.list();
	}
}
