package br.com.epedido.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Stateless
public class GenericDAO<T, I extends Serializable> {

	@PersistenceContext(unitName = "epedido")
	protected EntityManager em;

	private Class<T> classe;

	public GenericDAO(){}
	
	public EntityManager getEntityManager() {
		return this.em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	/**
	 * Métodos para usar nos tests
	 */
	public void createTransaction() {
		this.em.getTransaction().begin();
	}

	public void commitTransaction() {
		this.em.getTransaction().commit();
	}

	public void roolbackTransaction() {
		this.em.getTransaction().rollback();
		;
	}

	public void destroyEntityManager() {
		this.em.close();
	}

	/**
	 * Fim métodos de testes
	 */

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	public T create(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	public T update(T entity) {
		em.merge(entity);
		em.flush();
		return entity;
	}

	public T getBy(Long id) {
		return em.find(classe, id);
	}

	public T getByStringId(String id) {
		return em.find(classe, id);
	}

	public T getBy(Object id) {
		return em.find(classe, id);
	}

	/**
	 * Finds an entity by one of its properties.
	 * 
	 * 
	 * @param clazz
	 *            entidade.
	 * @param propertyName
	 *            atributo da entidade.
	 * @param value
	 *            o valor do que deseja achar.
	 * @return
	 */
	public List<T> findByProperty(Class<T> clazz, String propertyName, Object value) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		Root<T> root = cq.from(clazz);
		cq.where(cb.equal(root.get(propertyName), value));
		return em.createQuery(cq).getResultList();
	}

	public T delete(Long id) {
		T entity = em.find(classe, id);
		em.remove(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = em.createQuery("FROM " + classe.getName());
		return query.getResultList();
	}

	public Boolean isLoaded(T entity, String nomeColecao) {
		PersistenceUnitUtil unitUtil = em.getEntityManagerFactory().getPersistenceUnitUtil();
		return unitUtil.isLoaded(entity, nomeColecao);
	}
	
}