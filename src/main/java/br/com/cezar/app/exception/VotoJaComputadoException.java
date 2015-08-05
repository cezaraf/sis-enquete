package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> VotoJaComputadoException
 * </p>
 * 
 * <p>
 * <b>Description:</b> VotoJaComputadoException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class VotoJaComputadoException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -5117312578301955386L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public VotoJaComputadoException() {

		super("Voto já computado!");
	}
}
