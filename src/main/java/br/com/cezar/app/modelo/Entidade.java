package br.com.cezar.app.modelo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <p>
 * <b>Title:</b> Entidade
 * </p>
 * 
 * <p>
 * <b>Description:</b> Entidade
 * </p>	
 * 	
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@MappedSuperclass
public class Entidade implements Serializable {

	/** Atributo GENERATOR. */
	public static final String GENERATOR = "br.com.cezar.app.sequenceGenerator";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -3667846055045128310L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Entidade.GENERATOR)
	/** Atributo id. */
	private Long id;
	
	/**
	 * Retorna o valor do atriuto <code>id</code>
	 * 
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return this.id;
	}

	/**
	 * Define o valor do atributo <code>id</code>.
	 * 
	 * @param id
	 */
	public void setId(final Long id) {

		this.id = id;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( this.id == null ) ? 0 : this.id.hashCode() );
		return result;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Entidade other = (Entidade) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
