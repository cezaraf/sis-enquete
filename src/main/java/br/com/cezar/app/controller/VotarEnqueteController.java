package br.com.cezar.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.cezar.app.exception.ValidacaoException;
import br.com.cezar.app.exception.VotoJaComputadoException;
import br.com.cezar.app.formulario.VotarEnqueteForm;
import br.com.cezar.app.service.EnqueteService;

/**
 * <p>
 * <b>Title:</b> VotarEnqueteController
 * </p>
 * 
 * <p>
 * <b>Description:</b> VotarEnqueteController
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Component("votarController")
@Scope("request")
public class VotarEnqueteController extends BaseController {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1939213882474221895L;

	@Autowired
	/** Atributo service. */
	private EnqueteService service;

	@Autowired
	/** Atributo formulario. */
	private VotarEnqueteForm formulario;

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 */
	public void init() {

		this.getFormulario().setEnquete(this.service.getEnquetePeriodo());
	}

	public void initResultado() {

		if (this.getFormulario().getIdEnquete() == null) {
		
			this.getFormulario().setResultado(this.service.getResultado());
			
		} else {
			
			this.getFormulario().setResultado(this.service.getResultado(this.getFormulario().getIdEnquete()));
		}
	}

	public void votar() {

		try {
			
			this.init();

			String cookieName = "ENQ" + this.getFormulario().getEnquete().getId();

			if (this.getCookie(cookieName) == null) {

				if (this.getFormulario().getEnquete().isSelecaoMultipla()) {

					this.service.votar(this.getParametersFromRequest("opcao"));

				} else {

					this.service.votar(this.getParameterFromRequest("opcao"));
				}

				this.registrarCookie(cookieName, "computado");

				this.addAlertMessage("Voto computado.");

			} else {

				throw new VotoJaComputadoException();
			}

		} catch (ValidacaoException e) {

			this.addAlertMessage(e.getMessage());
		}
	}

	/**
	 * Retorna o valor do atriuto <code>service</code>
	 * 
	 * @return <code>EnqueteService</code>
	 */
	public EnqueteService getService() {

		return service;
	}

	/**
	 * Retorna o valor do atriuto <code>formulario</code>
	 * 
	 * @return <code>VotarEnqueteForm</code>
	 */
	public VotarEnqueteForm getFormulario() {

		return formulario;
	}

}
