package br.com.athat.core.manager;

public interface AbstractManager {
	
	 public <T> T buscarPorId(Class<T> classe, Long id);

}
