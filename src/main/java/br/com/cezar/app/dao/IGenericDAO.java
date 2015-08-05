package br.com.cezar.app.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.com.cezar.app.modelo.Entidade;

public interface IGenericDAO<T extends Entidade> extends Serializable {

	public abstract Class<T> getEntityClass();

	public abstract Session getSession();

	public abstract void save(T entidade);

	public abstract T get(Long id);

	public abstract void delete(Long id);

	public abstract void update(T entidade);

	public abstract List<T> list();
}