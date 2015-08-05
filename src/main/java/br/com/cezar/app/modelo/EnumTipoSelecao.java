package br.com.cezar.app.modelo;

/**
 * <p>
 * <b>Title:</b> EnumTipoEnquete
 * </p>
 * 
 * <p>
 * <b>Description:</b> EnumTipoEnquete
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public enum EnumTipoSelecao {

	/** Atributo SELECAO_UNICA. */
	UNICA("Permitir selecionar apenas uma opção"),

	/** Atributo SELECAO_MULTIPLA. */
	MULTIPLA("Permitir selecionar várias opções");

	/** Atributo label. */
	private String label;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param label
	 */
	private EnumTipoSelecao( String label ) {

		this.label = label;
	}

	/**
	 * Retorna o valor do atriuto <code>label</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getLabel() {

		return label;
	}

}
