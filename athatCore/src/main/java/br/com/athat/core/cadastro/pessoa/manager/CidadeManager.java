
package br.com.athat.core.cadastro.pessoa.manager;

import java.util.List;

import br.com.athat.core.cadastro.pessoa.entity.endereco.Cidade;
import br.com.athat.core.cadastro.pessoa.entity.endereco.EstadoType;


public interface CidadeManager {
    void salvar(Cidade cidade);
    
    List<Cidade> buscarTodos(Cidade cidade);
    
    List<Cidade> buscarPorEstado(EstadoType estadoType);
    
    Cidade buscarPorId(Long id);
    
}
