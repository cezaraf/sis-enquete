package br.com.cezar.app.dto;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * <b>Title:</b> ResultadoDTO
 * </p>
 * 
 * <p>
 * <b>Description:</b> ResultadoDTO
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class ResultadoEnqueteDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 9051281477885210720L;

	/** Atributo id. */
	private Long id;

	/** Atributo pergunta. */
	private String pergunta;

	/** Atributo opcoes. */
	private List<ResultadoOpcaoDTO> opcoes;

	/**
	 * Retorna o valor do atriuto <code>pergunta</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getPergunta() {

		return pergunta;
	}

	/**
	 * Define o valor do atributo <code>pergunta</code>.
	 * 
	 * @param pergunta
	 */
	public void setPergunta(String pergunta) {

		this.pergunta = pergunta;
	}

	/**
	 * Retorna o valor do atriuto <code>opcoes</code>
	 * 
	 * @return <code>List<ResultadoOpcaoDTO></code>
	 */
	public List<ResultadoOpcaoDTO> getOpcoes() {

		return opcoes;
	}

	/**
	 * Define o valor do atributo <code>opcoes</code>.
	 * 
	 * @param opcoes
	 */
	public void setOpcoes(List<ResultadoOpcaoDTO> opcoes) {

		this.opcoes = opcoes;
	}

	/**
	 * Retorna o valor do atriuto <code>id</code>
	 * 
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return id;
	}

	/**
	 * Define o valor do atributo <code>id</code>.
	 * 
	 * @param id
	 */
	public void setId(Long id) {

		this.id = id;
	}

}
