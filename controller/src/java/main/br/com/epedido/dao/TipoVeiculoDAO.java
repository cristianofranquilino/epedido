package br.com.epedido.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.epedido.model.TipoVeiculo;

@Stateless
public class TipoVeiculoDAO extends GenericDAO<TipoVeiculo, Serializable> {

	public TipoVeiculoDAO(){
		super(TipoVeiculo.class);
	}
	
	public List<TipoVeiculo> getAtivos() {
		TypedQuery<TipoVeiculo> query = em.
										createQuery("select T FROM TipoVeiculo T "
												+ " where T.ativo = 0 "
												+ " order by T.descricao", 
												TipoVeiculo.class);
		return query.getResultList();
	}
	
}
