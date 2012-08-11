package br.com.athat.core.cadastro.pessoa.manager;

import br.com.athat.core.cadastro.pessoa.entity.Pessoa;

public interface PessoaManager {
    
    Pessoa findByCpfCnpj(String cpfCnpj);

	Pessoa buscarPorId(Long id);
	
	Pessoa buscarPorIdCompleto(Long id);
    
}
