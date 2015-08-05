package br.com.cezar.app.dao;

import java.util.Date;

import br.com.cezar.app.dto.ResultadoEnqueteDTO;
import br.com.cezar.app.modelo.Enquete;
import br.com.cezar.app.modelo.Opcao;
import br.com.cezar.app.modelo.Voto;

/**
 * <p>
 * <b>Title:</b> IEnqueteDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> IEnqueteDAO
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
public interface EnqueteDAO extends IGenericDAO<Enquete> {

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * @param long1
	 * 
	 * @param dataInicio
	 * @param dataFinal
	 * @return
	 */
	public boolean existeEnqueteNoPeriodoInformado(Long long1, Date dataInicio, Date dataFinal);

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param date
	 * @return
	 */
	public Enquete getEnquetePeriodo(Date date);

	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @param opcaoId
	 * @return
	 */
	public Opcao getOpcao(Long opcaoId);

	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @param voto
	 */
	public void saveVoto(Voto voto);

	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @param date
	 * @return
	 */
	public ResultadoEnqueteDTO getResultado(Date date);

	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @param idEnquete
	 * @return
	 */
	public ResultadoEnqueteDTO getResultado(Long idEnquete);
}
