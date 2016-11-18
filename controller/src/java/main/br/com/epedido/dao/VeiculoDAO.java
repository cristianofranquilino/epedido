package br.com.epedido.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.epedido.model.TipoVeiculo;
import br.com.epedido.model.Veiculo;

@Stateless
public class VeiculoDAO extends GenericDAO<Veiculo, Serializable> {

	public VeiculoDAO(){
		super(Veiculo.class);
	}
	
	
	public List<Veiculo> getByTipo(TipoVeiculo tipoVeiculo){
		
		TypedQuery<Veiculo> query = em.
				createQuery("select V FROM Veiculo V "
						+ " where V.ativo = 0  and V.tipo = :tipo", 
								Veiculo.class);
		query.setParameter("tipo", tipoVeiculo);
		return query.getResultList();
		
	}
	
	public List<Veiculo> getAtivos(){
		
		TypedQuery<Veiculo> query = em.
				createQuery("select V FROM Veiculo V "
						+ " where V.ativo = 0 ", 
								Veiculo.class);
		return query.getResultList();
		
	}
	
}
