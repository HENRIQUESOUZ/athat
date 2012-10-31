package br.com.athat.core.manager.pessoa;

import java.util.List;

import br.com.athat.core.entity.pessoa.Papel;
import br.com.athat.core.entity.pessoa.Pessoa;

public interface PessoaManager {
    
    Pessoa findByCpfCnpj(String cpfCnpj);

	Pessoa buscarPorId(Long id);
	
	Pessoa buscarPorIdCompleto(Long id);
	
	List<Papel> buscaGenericaPop(Long id, String cpfCnpj, String razaoSocial, Object tipoClasse);
    
}
