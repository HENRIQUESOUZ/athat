package br.com.athat.core.manager.pedido;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.pedido.PedidoCompra;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.core.vo.pedido.PedidoCompraVO;
import br.com.athat.utils.validators.DateUtils;

public class PedidoCompraManagerImpl extends AbstractManagerImpl implements PedidoCompraManager {

	private static final long serialVersionUID = 1L;

	@Override
	@Transactional
	public void salvar(PedidoCompra pedidoCompra) {
		if(pedidoCompra.getId() == null) {
			getEntityManager().persist(pedidoCompra);
		} else {
			getEntityManager().merge(pedidoCompra);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PedidoCompra> buscar(PedidoCompraVO pedidoCompraVO) {
		Criteria criteria = createSession().createCriteria(PedidoCompra.class)
				.add(Restrictions.between("dataCadastro", 
					DateUtils.zerarHoras(pedidoCompraVO.getDataInicio()), DateUtils.horasFinal(pedidoCompraVO.getDataFim())))
			;
//			if(projeto.getId() != null) {
//				criteria.add(Restrictions.eq("id", projeto.getId()));
//			}
		for(PedidoCompra p : (List<PedidoCompra>) criteria.list()) {
			Hibernate.initialize(p.getItensMovimentacao());
		}
		
			return criteria.list();
		}	
}
