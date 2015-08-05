package br.com.cezar.app.dto;

import java.io.Serializable;

/**
 * <p>
 * <b>Title:</b> ResultadoOpcaoDTO
 * </p>
 * 
 * <p>
 * <b>Description:</b> ResultadoOpcaoDTO
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class ResultadoOpcaoDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 5433661073213067949L;

	/** Atributo id. */
	private Long id;

	/** Atributo opcao. */
	private String opcao;

	/** Atributo percentual. */
	private Double percentual;

	/** Atributo quantidade. */
	private Long quantidade;

	/**
	 * Retorna o valor do atriuto <code>opcao</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getOpcao() {

		return opcao;
	}

	/**
	 * Define o valor do atributo <code>opcao</code>.
	 * 
	 * @param opcao
	 */
	public void setOpcao(String opcao) {

		this.opcao = opcao;
	}

	/**
	 * Retorna o valor do atriuto <code>percentual</code>
	 * 
	 * @return <code>Double</code>
	 */
	public Double getPercentual() {

		return percentual;
	}
	
	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @return
	 */
	public int getPercentualInt() {
		
		return (this.percentual == null) ? 0 : this.percentual.intValue();
	}

	/**
	 * Define o valor do atributo <code>percentual</code>.
	 * 
	 * @param percentual
	 */
	public void setPercentual(Double percentual) {

		this.percentual = percentual;
	}

	/**
	 * Retorna o valor do atriuto <code>quantidade</code>
	 * 
	 * @return <code>Long</code>
	 */
	public Long getQuantidade() {

		return quantidade;
	}

	/**
	 * Define o valor do atributo <code>quantidade</code>.
	 * 
	 * @param quantidade
	 */
	public void setQuantidade(Long quantidade) {

		this.quantidade = quantidade;
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
