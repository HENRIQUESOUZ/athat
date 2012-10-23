
package br.com.athat.core.manager.pessoa;

import java.util.List;

import br.com.athat.core.entity.pessoa.endereco.Cidade;
import br.com.athat.core.entity.pessoa.endereco.EstadoType;


public interface CidadeManager {
    void salvar(Cidade cidade);
    
    List<Cidade> buscarTodos(Cidade cidade);
    
    List<Cidade> buscarPorEstado(EstadoType estadoType);
    
    Cidade buscarPorId(Long id);
    
}
