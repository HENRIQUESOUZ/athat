package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.ContaAPagar;
import java.util.List;

import br.com.athat.core.entity.conta.Conta;



public interface ContaAPagarManager {

	
	public void salvar(ContaAPagar conta);
	public List<Conta> buscarTodos(ContaAPagar conta);

	
	
	
}
