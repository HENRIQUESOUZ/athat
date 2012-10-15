package br.com.athat.core.movimentacao.venda.entity;

import br.com.athat.core.cadastro.pessoa.cliente.entity.Cliente;
import br.com.athat.core.movimentacao.Movimentacao;
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
