package br.com.cezar.app.formulario;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.cezar.app.modelo.Enquete;
import br.com.cezar.app.modelo.EnumTipoSelecao;

/**
 * <p>
 * <b>Title:</b> ManterEnqueteForm
 * </p>
 * 
 * <p>
 * <b>Description:</b> ManterEnqueteForm
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Component("enqueteForm")
@Scope("session")
public class ManterEnqueteForm implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -3404820594806977063L;

	/** Atributo entidade. */
	private Enquete entidade;

	/** Atributo entidades. */
	private List<Enquete> entidades;

	/** Atributo tipoSelecaoList. */
	private List<EnumTipoSelecao> tipoSelecaoList;

	/**
	 * Retorna o valor do atriuto <code>entidade</code>
	 * 
	 * @return <code>Enquete</code>
	 */
	public Enquete getEntidade() {

		return entidade;
	}

	/**
	 * Define o valor do atributo <code>entidade</code>.
	 * 
	 * @param entidade
	 */
	public void setEntidade(Enquete entidade) {

		this.entidade = entidade;
	}

	/**
	 * Retorna o valor do atriuto <code>entidades</code>
	 * 
	 * @return <code>List<Enquete></code>
	 */
	public List<Enquete> getEntidades() {

		return entidades;
	}

	/**
	 * Define o valor do atributo <code>entidades</code>.
	 * 
	 * @param entidades
	 */
	public void setEntidades(List<Enquete> entidades) {

		this.entidades = entidades;
	}

	/**
	 * Retorna o valor do atriuto <code>tipoSelecaoList</code>
	 * 
	 * @return <code>List<EnumTipoSelecao></code>
	 */
	public List<EnumTipoSelecao> getTipoSelecaoList() {

		if (tipoSelecaoList == null || tipoSelecaoList.isEmpty()) {
			
			return this.tipoSelecaoList = Arrays.asList(EnumTipoSelecao.values());
		}
		
		return tipoSelecaoList;
	}

	/**
	 * Define o valor do atributo <code>tipoSelecaoList</code>.
	 * 
	 * @param tipoSelecaoList
	 */
	public void setTipoSelecaoList(List<EnumTipoSelecao> tipoSelecaoList) {

		this.tipoSelecaoList = tipoSelecaoList;
	}

}
