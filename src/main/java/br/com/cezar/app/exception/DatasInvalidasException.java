package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> DatasInvalidasException
 * </p>
 * 
 * <p>
 * <b>Description:</b> DatasInvalidasException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class DatasInvalidasException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6721096149120464966L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public DatasInvalidasException() {

		super("A data de inicial não pode ser maior que a data final");
	}
}
