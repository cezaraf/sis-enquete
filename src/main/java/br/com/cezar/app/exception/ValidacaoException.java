package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> ValidacaoException
 * </p>
 * 
 * <p>
 * <b>Description:</b> ValidacaoException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class ValidacaoException extends RuntimeException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6644767375746440226L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param msg
	 */
	public ValidacaoException( final String msg ) {

		super(msg);
	}
}
