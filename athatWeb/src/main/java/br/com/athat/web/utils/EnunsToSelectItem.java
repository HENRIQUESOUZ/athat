package br.com.athat.web.utils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.athat.core.entity.pessoa.endereco.EstadoType;
import br.com.athat.core.entity.pessoa.enuns.EnderecoType;
import br.com.athat.core.entity.pessoa.enuns.LogradouroType;
import br.com.athat.core.entity.produto.ProdutoType;
import br.com.athat.core.entity.produto.categoria.IdentificacaoType;
import br.com.athat.core.entity.produto.categoria.UnidadeMedidaType;

public class EnunsToSelectItem implements Serializable{

	private static final long serialVersionUID = 1L;

	public List<SelectItem> getEnderecosType(){
        List<SelectItem> itens = new LinkedList<SelectItem>();
        for(EnderecoType type : EnderecoType.values())
        	itens.add(new SelectItem(type.name(),type.getDescricao()));
        return itens;
    }
    
    public List<SelectItem> getLogradourosType(){
        List<SelectItem> itens = new LinkedList<SelectItem>();
        for(LogradouroType type : LogradouroType.values())
        	itens.add(new SelectItem(type.name(),type.getDescricao()));
        return itens;
    }
    
    public List<SelectItem> getEstadoType(){
        List<SelectItem> itens = new LinkedList<SelectItem>();
        for(EstadoType type : EstadoType.values())
        	itens.add(new SelectItem(type.name(),type.getDescricao()));
        return itens;
    }
    
    public List<SelectItem> getUnidadeMedidaType(){
        List<SelectItem> itens = new LinkedList<SelectItem>();
        for(UnidadeMedidaType type : UnidadeMedidaType.values())
        	itens.add(new SelectItem(type.name(),type.getDescricao()));
        return itens;
    }
    
    public List<SelectItem> getProdutoType(){
        List<SelectItem> itens = new LinkedList<SelectItem>();
        for(ProdutoType type : ProdutoType.values())
        	itens.add(new SelectItem(type.name(),type.getDescricao()));
        return itens;
    }
    public List<SelectItem> getIdentificacaoType(){
        List<SelectItem> itens = new LinkedList<SelectItem>();
        for(IdentificacaoType type : IdentificacaoType.values())
        	itens.add(new SelectItem(type.name(),type.getDescricao()));
        return itens;
    }    
    
}
