package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> PerguntaNaoInformadaException
 * </p>
 * 
 * <p>
 * <b>Description:</b> PerguntaNaoInformadaException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class PerguntaNaoInformadaException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 3750329744352171656L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public PerguntaNaoInformadaException() {

		super("Por favor, informe a pergunta da enquete!");
	}
}
