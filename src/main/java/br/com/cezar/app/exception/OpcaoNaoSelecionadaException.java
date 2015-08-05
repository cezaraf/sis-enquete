package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> OpcaoNaoSelecionadaException
 * </p>
 * 
 * <p>
 * <b>Description:</b> OpcaoNaoSelecionadaException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class OpcaoNaoSelecionadaException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -2189960070598050971L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public OpcaoNaoSelecionadaException() {

		super("Selecione uma opção!");
	}
}
