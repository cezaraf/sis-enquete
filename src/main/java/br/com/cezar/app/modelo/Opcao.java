package br.com.cezar.app.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>
 * <b>Title:</b> Opcoes
 * </p>
 * 
 * <p>
 * <b>Description:</b> Opcoes
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Entity
@Table(name = "tb_opcoes")
@SequenceGenerator(name = Entidade.GENERATOR, sequenceName = "seq_tb_opcoes", allocationSize = 1)
public class Opcao extends Entidade {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6600895187610973146L;

	@Column(name = "DS_CONTEUDO", nullable = false)
	/** Atributo conteudo. */
	private String conteudo;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENQUETE")
	/** Atributo enquete. */
	private Enquete enquete;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "opcao", targetEntity = Voto.class)
	/** Atributo votos. */
	private List<Voto> votos;

	/**
	 * Retorna o valor do atriuto <code>conteudo</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getConteudo() {

		return this.conteudo;
	}

	/**
	 * Define o valor do atributo <code>conteudo</code>.
	 * 
	 * @param conteudo
	 */
	public void setConteudo(final String conteudo) {

		this.conteudo = conteudo;
	}

	/**
	 * Retorna o valor do atriuto <code>enquete</code>
	 * 
	 * @return <code>Enquete</code>
	 */
	public Enquete getEnquete() {

		return this.enquete;
	}

	/**
	 * Define o valor do atributo <code>enquete</code>.
	 * 
	 * @param enquete
	 */
	public void setEnquete(final Enquete enquete) {

		this.enquete = enquete;
	}

	/**
	 * Retorna o valor do atriuto <code>votos</code>
	 * 
	 * @return <code>List<Voto></code>
	 */
	public List<Voto> getVotos() {

		return this.votos;
	}

	/**
	 * Define o valor do atributo <code>votos</code>.
	 * 
	 * @param votos
	 */
	public void setVotos(final List<Voto> votos) {

		this.votos = votos;
	}

}
