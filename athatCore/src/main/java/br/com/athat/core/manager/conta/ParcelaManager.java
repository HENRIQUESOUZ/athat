package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.Parcela;

public interface ParcelaManager {
	public void gerarParcelas(int numeroParcelas);
	public Parcela getParcela(int numeroParcela);

	
}
