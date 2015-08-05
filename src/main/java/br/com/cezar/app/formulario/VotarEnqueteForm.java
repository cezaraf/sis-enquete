package br.com.cezar.app.formulario;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.cezar.app.dto.ResultadoEnqueteDTO;
import br.com.cezar.app.modelo.Enquete;

/**
 * <p>
 * <b>Title:</b> VotarEnqueteForm
 * </p>
 * 
 * <p>
 * <b>Description:</b> VotarEnqueteForm
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Component
@Scope("request")
public class VotarEnqueteForm implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -4489864527543156903L;

	/** Atributo enquete. */
	private Enquete enquete;

	/** Atributo resultado. */
	private ResultadoEnqueteDTO resultado;

	/** Atributo idEnquete. */
	private Long idEnquete;

	/**
	 * Retorna o valor do atriuto <code>enquete</code>
	 * 
	 * @return <code>Enquete</code>
	 */
	public Enquete getEnquete() {

		return enquete;
	}

	/**
	 * Define o valor do atributo <code>enquete</code>.
	 * 
	 * @param enquete
	 */
	public void setEnquete(Enquete enquete) {

		this.enquete = enquete;
	}

	/**
	 * Retorna o valor do atriuto <code>resultado</code>
	 * 
	 * @return <code>ResultadoEnqueteDTO</code>
	 */
	public ResultadoEnqueteDTO getResultado() {

		return resultado;
	}

	/**
	 * Define o valor do atributo <code>resultado</code>.
	 * 
	 * @param resultado
	 */
	public void setResultado(ResultadoEnqueteDTO resultado) {

		this.resultado = resultado;
	}

	/**
	 * Retorna o valor do atriuto <code>idEnquete</code>
	 * 
	 * @return <code>Long</code>
	 */
	public Long getIdEnquete() {

		return idEnquete;
	}

	/**
	 * Define o valor do atributo <code>idEnquete</code>.
	 * 
	 * @param idEnquete
	 */
	public void setIdEnquete(Long idEnquete) {

		this.idEnquete = idEnquete;
	}

}
