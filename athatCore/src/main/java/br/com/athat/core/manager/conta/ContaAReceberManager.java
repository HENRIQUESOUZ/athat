package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.ContaAReceber;
import java.util.List;

import br.com.athat.core.entity.conta.Conta;



public interface ContaAReceberManager {

	
	public void salvar(ContaAReceber conta);
	public List<Conta> buscarContaAberta();

	
	
	
}
