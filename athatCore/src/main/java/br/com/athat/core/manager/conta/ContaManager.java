package br.com.athat.core.manager.conta;



public interface ContaManager {

	
	public void salvar();
//	public List<Conta> buscarTodos(Conta conta);
	public void gerarParcelas(int numeroParcelas);
	public ParcelaManager getParcelas();
	
	
	
}
