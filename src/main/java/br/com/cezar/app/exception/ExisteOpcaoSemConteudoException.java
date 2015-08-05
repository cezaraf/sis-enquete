package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> ExisteOpcaoSemConteudoException
 * </p>
 * 
 * <p>
 * <b>Description:</b> ExisteOpcaoSemConteudoException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class ExisteOpcaoSemConteudoException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6311613358471214930L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ExisteOpcaoSemConteudoException() {

		super("Favor, preencher o conteúdo das opções");
	}
}
