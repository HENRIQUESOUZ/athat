package br.com.athat.core.entity.movimentacao.venda;

<<<<<<< HEAD:athatCore/src/main/java/br/com/athat/core/entity/movimentacao/venda/Venda.java
import br.com.athat.core.entity.movimentacao.Movimentacao;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
=======
>>>>>>> correções na aplicação para compilar:athatCore/src/main/java/br/com/athat/core/movimentacao/venda/entity/Venda.java
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.athat.core.cadastro.pessoa.cliente.entity.Cliente;
import br.com.athat.core.movimentacao.Movimentacao;

@Entity
public class Venda extends Movimentacao{
    
    @ManyToOne
    private Cliente cliente;
    
    @Temporal(TemporalType.DATE)
    private Date previsaoEntrega;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Date previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }
    
}
