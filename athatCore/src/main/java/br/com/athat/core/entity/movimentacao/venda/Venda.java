package br.com.athat.core.entity.movimentacao.venda;

import br.com.athat.core.entity.movimentacao.Movimentacao;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
