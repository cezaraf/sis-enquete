package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> JaExisteEnqueteNoPeriodoException
 * </p>
 * 
 * <p>
 * <b>Description:</b> JaExisteEnqueteNoPeriodoException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class JaExisteEnqueteNoPeriodoException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1820803308266410194L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public JaExisteEnqueteNoPeriodoException() {

		super("Já existe uma enquete ativa no período informado");
	}
}
