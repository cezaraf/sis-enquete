package br.com.cezar.app.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cezar.app.dao.EnqueteDAO;
import br.com.cezar.app.dto.ResultadoEnqueteDTO;
import br.com.cezar.app.exception.DatasInvalidasException;
import br.com.cezar.app.exception.DatasNaoInformadasException;
import br.com.cezar.app.exception.ExisteOpcaoSemConteudoException;
import br.com.cezar.app.exception.JaExisteEnqueteNoPeriodoException;
import br.com.cezar.app.exception.NumeroMinimoOpcoesException;
import br.com.cezar.app.exception.OpcaoNaoSelecionadaException;
import br.com.cezar.app.exception.PerguntaNaoInformadaException;
import br.com.cezar.app.exception.TipoSelecaoNaoInformadoException;
import br.com.cezar.app.modelo.Enquete;
import br.com.cezar.app.modelo.Opcao;
import br.com.cezar.app.modelo.Voto;

/**
 * <p>
 * <b>Title:</b> EnqueteService
 * </p>
 * 
 * <p>
 * <b>Description:</b> EnqueteService
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Service
@Transactional
public class EnqueteServiceImpl implements Serializable, EnqueteService {

	/** Atributo NUMERO_MINIMO_OPCOES. */
	private static final int NUMERO_MINIMO_OPCOES = 2;

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 5273502407195622964L;

	@Autowired
	/** Atributo dao. */
	private EnqueteDAO dao;

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @return
	 */
	public List<Enquete> list() {

		return this.dao.list();
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param enquete
	 */
	public void save(final Enquete enquete) {

		this.validarCamposObrigatorios(enquete);

		this.validarDatasInformadas(enquete);

		this.validarNumeroOpcoes(enquete);

		this.validarSeOpcoesEstaoVazias(enquete);

		this.validarSeExisteEnqueteRegistradaNoPeriodoInformado(enquete);

		this.dao.save(enquete);
	}

	/**
	 * Método responsável por validar se existem opções sem preenchimento
	 * 
	 * @author Cézar Augusto Ferreira
	 * 
	 * @param enquete
	 *            enquete a ser validada
	 */
	private void validarSeOpcoesEstaoVazias(Enquete enquete) {

		if (enquete.getOpcoes() != null && !enquete.getOpcoes().isEmpty()) {

			for (Opcao o : enquete.getOpcoes()) {

				if (o.getConteudo() == null || o.getConteudo().isEmpty()) {

					throw new ExisteOpcaoSemConteudoException();
				}
			}
		}
	}

	/**
	 * Método responsável por validar se já existe uma enquete disponível no período informado
	 * 
	 * @author Cézar Augusto Ferreira
	 * 
	 * @param enquete
	 *            enquete a ser validada
	 */
	private void validarSeExisteEnqueteRegistradaNoPeriodoInformado(Enquete enquete) {

		if (this.dao.existeEnqueteNoPeriodoInformado(enquete.getId(), enquete.getDataInicio(), enquete.getDataFinal())) {

			throw new JaExisteEnqueteNoPeriodoException();
		}
	}

	/**
	 * Método responsável por validar as datas de início e fim informadas para a enquete
	 * 
	 * @author Cézar Augusto Ferreira
	 * 
	 * @param enquete
	 *            entidade que será validada
	 */
	private void validarDatasInformadas(final Enquete enquete) {

		if (enquete.getDataInicio() != null && enquete.getDataFinal() != null && enquete.getDataInicio().after(enquete.getDataFinal())) {

			throw new DatasInvalidasException();
		}
	}

	/**
	 * Método responsável por validar o número mínimo de opções da enquete
	 * 
	 * @author Cézar Augusto Ferreira
	 * 
	 * @param enquete
	 *            entidade que deverá ser validada
	 */
	private void validarNumeroOpcoes(final Enquete enquete) {

		if (enquete.getOpcoes() == null || enquete.getOpcoes().size() < EnqueteServiceImpl.NUMERO_MINIMO_OPCOES) {

			throw new NumeroMinimoOpcoesException();
		}
	}

	/**
	 * Método responsável por validar os campos obrigatórios da entidade enquete
	 * 
	 * @author Cézar Augusto Ferreira
	 * 
	 * @param enquete
	 *            enquete a ser validada
	 */
	private void validarCamposObrigatorios(final Enquete enquete) {

		if (enquete.getPergunta() == null || enquete.getPergunta().isEmpty()) {

			throw new PerguntaNaoInformadaException();
		}

		if (enquete.getDataInicio() == null || enquete.getDataFinal() == null) {

			throw new DatasNaoInformadasException();
		}
		
		if (enquete.getTipoSelecao() == null) {
			
			throw new TipoSelecaoNaoInformadoException();
		}
	}

	public void delete(Long id) {

		this.dao.delete(id);
	}

	public Enquete get(Long id) {

		return this.dao.get(id);
	}

	public Enquete getEnquetePeriodo() {

		return this.dao.getEnquetePeriodo(new Date());
	}

	private void registrarVoto(Long opcaoId) {

		Opcao op = this.dao.getOpcao(opcaoId);
		
		if (op != null) {
		
			Voto voto = new Voto();
			
			voto.setData(new Date());
			
			voto.setOpcao(op);
			
			this.dao.saveVoto(voto);
		}
	}

	public void votar(String[] opcoes) {

		validarOpcoes(opcoes);
		
		for (String opcao : opcoes) {
			
			this.votar(opcao);
		}
	}

	private void validarOpcoes(String[] opcoes) {

		if (opcoes == null || opcoes.length == 0) {
			
			throw new OpcaoNaoSelecionadaException();
		}
	}

	public void votar(String opcao) {

		this.validarOpcao(opcao);
		
		this.registrarVoto(Long.parseLong(opcao));
	}

	private void validarOpcao(String opcao) {

		if (opcao == null || opcao.isEmpty() || !opcao.matches("[0-9.*]")) {
			
			throw new OpcaoNaoSelecionadaException();
		}
	}

	public ResultadoEnqueteDTO getResultado() {

		return this.dao.getResultado(new Date());
	}

	public ResultadoEnqueteDTO getResultado(Long idEnquete) {

		return this.dao.getResultado(idEnquete);
	}
}
