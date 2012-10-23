package br.com.athat.core.manager.pessoa;

import br.com.athat.core.entity.pessoa.Pessoa;

public interface PessoaManager {
    
    Pessoa findByCpfCnpj(String cpfCnpj);

	Pessoa buscarPorId(Long id);
	
	Pessoa buscarPorIdCompleto(Long id);
    
}
