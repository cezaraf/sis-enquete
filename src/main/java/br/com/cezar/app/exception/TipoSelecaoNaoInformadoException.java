package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> TipoSelecaoNaoInformadoException
 * </p>
 * 
 * <p>
 * <b>Description:</b> TipoSelecaoNaoInformadoException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class TipoSelecaoNaoInformadoException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -2547767381672949721L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public TipoSelecaoNaoInformadoException() {

		super("Selecione o tipo de seleção da enquete");
	}
}
