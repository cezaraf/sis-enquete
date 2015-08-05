package br.com.cezar.app.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * <b>Title:</b> BaseController
 * </p>
 * 
 * <p>
 * <b>Description:</b> BaseController
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public class BaseController implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6030711444083464581L;

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	protected FacesContext getContext() {

		return FacesContext.getCurrentInstance();
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	protected HttpServletRequest getRequest() {

		return (HttpServletRequest) this.getContext().getExternalContext().getRequest();
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param name
	 * @return
	 */
	protected String getParameterFromRequest(String name) {

		return this.getRequest().getParameter(name);
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param name
	 * @return
	 */
	protected String[] getParametersFromRequest(String name) {

		return this.getRequest().getParameterValues(name);
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param message
	 */
	public void addAlertMessage(String message) {

		this.getContext().addMessage(null, new FacesMessage(message));
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	protected HttpServletResponse getResponse() {

		return (HttpServletResponse) this.getContext().getExternalContext().getResponse();
	}

	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @param nome
	 * @return
	 */
	protected Cookie getCookie(String nome) {
		
		Cookie[] cookies = this.getRequest().getCookies();
		
		for (Cookie cookie : cookies) {
			
			if (nome.equals(cookie.getName())) {
				
				return cookie;
			}
		}
		
		return null;
	}
	
	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @param nome
	 * @param value
	 */
	protected void registrarCookie(String nome, String value) {

		Cookie cookie = new Cookie(nome, value);

		cookie.setMaxAge(60 * 60 * 24 * 30);
		
		this.getResponse().addCookie(cookie);
	}
}
