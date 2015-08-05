package br.com.cezar.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;

import br.com.cezar.app.modelo.Entidade;

/**
 * <p>
 * <b>Title:</b> DAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> DAO
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public abstract class GenericDAO<T extends Entidade> implements IGenericDAO<T> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6133385190180536020L;

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	public abstract Class<T> getEntityClass();

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	public abstract SessionFactory getSessionFactory();

	/**
	 * Método responsável por obter a sessão do hibernate
	 * 
	 * @author Cézar Augusto Ferreira
	 * 
	 * @return sessão do hibernate
	 */
	public Session getSession() {

		return this.getSessionFactory().getCurrentSession();
	}

	public void save(final T entidade) {

		this.getSession().saveOrUpdate(entidade);
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(final Long id) {

		return (T) this.getSession().get(this.getEntityClass(), id);
	}

	public void delete(final Long id) {

		this.getSession().delete(this.get(id));
	}

	public void update(final T entidade) {

		this.save(entidade);
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {

		return this.criteriaList().setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
	}

	protected Criteria newCriteria() {

		return this.getSession().createCriteria(this.getEntityClass());
	}

	protected Criteria criteriaList() {

		return this.newCriteria();
	}
}
