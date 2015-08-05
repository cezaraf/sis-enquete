package br.com.cezar.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.cezar.app.exception.ValidacaoException;
import br.com.cezar.app.formulario.ManterEnqueteForm;
import br.com.cezar.app.modelo.Enquete;
import br.com.cezar.app.modelo.EnumStatus;
import br.com.cezar.app.modelo.Opcao;
import br.com.cezar.app.service.EnqueteService;

/**
 * <p>
 * <b>Title:</b> ManterEnqueteController
 * </p>
 * 
 * <p>
 * <b>Description:</b> ManterEnqueteController
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Component("enqueteController")
@Scope("session")
public class ManterEnqueteController extends BaseController {

	private static final String MSG_SUCESSO = "Operação realizada com sucesso!";

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -5194749916233065087L;

	@Autowired
	/** Atributo formulario. */
	private ManterEnqueteForm formulario;

	@Autowired
	/** Atributo service. */
	private EnqueteService service;

	/**
	 * Método responsável por inicializar os dados do formulário
	 * 
	 * @author Cézar Augusto Ferreira
	 */
	public void init() {

		if (this.getFormulario().getEntidade() == null) {

			this.novo();
		}

		this.getFormulario().setEntidades(this.service.list());
	}

	/**
	 * Método responsável por atualizar as entidades do formulário
	 * 
	 * @author Cézar Augusto Ferreira
	 */
	public void novo() {

		this.getFormulario().setEntidade(new Enquete());

		this.getFormulario().getEntidade().setOpcoes(new ArrayList<Opcao>());
	}

	/**
	 * Método responsável por salvar os dados do formulário
	 * 
	 * @author Cézar Augusto Ferreira
	 */
	public void save() {

		try {

			this.getFormulario().getEntidade().setStatus(EnumStatus.ATIVO);

			this.service.save(this.getFormulario().getEntidade());

			this.addAlertMessage(ManterEnqueteController.MSG_SUCESSO);

			this.novo();

		} catch (final ValidacaoException e) {

			this.addAlertMessage(e.getMessage());
		}
	}

	public void alterar() {

		final Long id = this.getIdEnqueteFromRequest();

		if (id != null) {

			this.getFormulario().setEntidade(this.service.get(id));
		}
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 */
	public void remover() {

		final Long id = this.getIdEnqueteFromRequest();

		if (id != null) {

			this.service.delete(id);

			this.addAlertMessage(ManterEnqueteController.MSG_SUCESSO);
		}
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	private Long getIdEnqueteFromRequest() {

		final String idEnquete = this.getParameterFromRequest("idEnquete");

		if (idEnquete != null && !idEnquete.isEmpty() && idEnquete.matches("[0-9].*")) {

			return Long.parseLong(idEnquete);
		}

		return null;
	}

	/**
	 * Método responsável por adicionar uma opção na enquete em questão
	 * 
	 * @author Cézar Augusto Ferreira
	 */
	public void addOpcao() {

		final Opcao o = new Opcao();

		o.setEnquete(this.getFormulario().getEntidade());

		this.getFormulario().getEntidade().getOpcoes().add(o);
	}

	/**
	 * Método responsável por remover uma opção na enquete em questão
	 * 
	 * @author Cézar Augusto Ferreira
	 */
	public void removerOpcao() {

		final int index = Integer.parseInt(this.getParameterFromRequest("opcaoIndex"));

		this.getFormulario().getEntidade().getOpcoes().remove(index);
	}

	/**
	 * Retorna o valor do atriuto <code>formulario</code>
	 * 
	 * @return <code>ManterEnqueteForm</code>
	 */
	public ManterEnqueteForm getFormulario() {

		return this.formulario;
	}

	/**
	 * Retorna o valor do atriuto <code>service</code>
	 * 
	 * @return <code>EnqueteService</code>
	 */
	public EnqueteService getService() {

		return this.service;
	}

}
