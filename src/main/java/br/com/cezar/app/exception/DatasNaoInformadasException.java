package br.com.cezar.app.exception;

/**
 * <p>
 * <b>Title:</b> DatasNaoInformadasException
 * </p>
 * 
 * <p>
 * <b>Description:</b> DatasNaoInformadasException
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class DatasNaoInformadasException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -4106351920003937541L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public DatasNaoInformadasException() {

		super("Favor, informar as datas de início e fim da visualização da enquete.");
	}
}
