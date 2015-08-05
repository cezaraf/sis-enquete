package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> NumeroMinimoOpcoesException
 * </p>
 * 
 * <p>
 * <b>Description:</b> NumeroMinimoOpcoesException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class NumeroMinimoOpcoesException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -2611536694384537794L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param msg
	 */
	public NumeroMinimoOpcoesException() {

		super("Por favor, informe, no mínimo, duas opções");
	}
}
