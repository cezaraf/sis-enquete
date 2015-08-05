package br.com.cezar.app.service;

import java.util.List;

import br.com.cezar.app.dto.ResultadoEnqueteDTO;
import br.com.cezar.app.modelo.Enquete;

/**
 * <p>
 * <b>Title:</b> IEnqueteService
 * </p>
 * 
 * <p>
 * <b>Description:</b> IEnqueteService
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public interface EnqueteService {

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	public abstract List<Enquete> list();

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param enquete
	 */
	public abstract void save(Enquete enquete);

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param parseLong
	 */
	public abstract void delete(Long id);

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param id
	 * @return
	 */
	public abstract Enquete get(Long id);

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	public abstract Enquete getEnquetePeriodo();

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param opcoes
	 */
	public abstract void votar(String[] opcoes);

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param opcao
	 */
	public abstract void votar(String opcao);

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	public abstract ResultadoEnqueteDTO getResultado();

	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @param idEnquete
	 * @return
	 */
	public abstract ResultadoEnqueteDTO getResultado(Long idEnquete);

}
