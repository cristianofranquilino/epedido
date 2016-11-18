package br.com.epedido.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.epedido.model.TipoPagamento;

@Stateless
public class TipoPagamentoDAO extends GenericDAO<TipoPagamento, Serializable> {

	public TipoPagamentoDAO() {
		super(TipoPagamento.class);
	}

	public List<TipoPagamento> getAtivos() {
		TypedQuery<TipoPagamento> query = em.
				createQuery("select T FROM TipoPagamento "
						+ " where T.ativo = 0 "
						+ " T order by T.descricao", 
						TipoPagamento.class);
		return query.getResultList();
	}

}
