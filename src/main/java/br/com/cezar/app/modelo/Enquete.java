package br.com.cezar.app.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>
 * <b>Title:</b> Enquete
 * </p>
 * 
 * <p>
 * <b>Description:</b> Enquete
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Entity
@Table(name = "tb_enquetes")
@SequenceGenerator(name = Entidade.GENERATOR, sequenceName = "seq_tb_enquetes", allocationSize = 1)
public class Enquete extends Entidade {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6716142881012889178L;

	@Column(name = "DS_ENQUETE", nullable = true)
	/** Atributo descricao. */
	private String descricao;

	@Column(name = "DS_PERGUNTA", nullable = false)
	/** Atributo pergunta. */
	private String pergunta;

	@Column(name = "DT_INICIO", nullable = false)
	@Temporal(TemporalType.DATE)
	/** Atributo dataInicio. */
	private Date dataInicio;

	@Column(name = "DT_FINAL", nullable = true)
	@Temporal(TemporalType.DATE)
	/** Atributo dataFinal. */
	private Date dataFinal;

	@Column(name = "TP_STATUS", columnDefinition = "INTEGER NOT NULL CONSTRAINT CK_TP_STATUS CHECK(TP_STATUS IN (0,1))")
	@Enumerated(EnumType.ORDINAL)
	/** Atributo status. */
	private EnumStatus status;

	@Column(name = "TP_SELECAO", columnDefinition = "INTEGER NOT NULL CONSTRAINT CK_TP_SELECAO CHECK(TP_SELECAO IN (0,1))")
	@Enumerated(EnumType.ORDINAL)
	/** Atributo tipoSelecao. */
	private EnumTipoSelecao tipoSelecao;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "enquete", orphanRemoval = true)
	/** Atributo opcoes. */
	private List<Opcao> opcoes;

	/**
	 * Retorna o valor do atriuto <code>pergunta</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getPergunta() {

		return this.pergunta;
	}

	/**
	 * Define o valor do atributo <code>pergunta</code>.
	 * 
	 * @param pergunta
	 */
	public void setPergunta(final String pergunta) {

		this.pergunta = pergunta;
	}

	/**
	 * Retorna o valor do atriuto <code>opcoes</code>
	 * 
	 * @return <code>List<Opcoes></code>
	 */
	public List<Opcao> getOpcoes() {

		return this.opcoes;
	}

	/**
	 * Define o valor do atributo <code>opcoes</code>.
	 * 
	 * @param opcoes
	 */
	public void setOpcoes(final List<Opcao> opcoes) {

		this.opcoes = opcoes;
	}

	/**
	 * Retorna o valor do atriuto <code>descricao</code>
	 * 
	 * @return <code>String</code>
	 */
	public String getDescricao() {

		return this.descricao;
	}

	/**
	 * Define o valor do atributo <code>descricao</code>.
	 * 
	 * @param descricao
	 */
	public void setDescricao(final String descricao) {

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atriuto <code>dataInicio</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getDataInicio() {

		return this.dataInicio;
	}

	/**
	 * Define o valor do atributo <code>dataInicio</code>.
	 * 
	 * @param dataInicio
	 */
	public void setDataInicio(final Date dataInicio) {

		this.dataInicio = dataInicio;
	}

	/**
	 * Retorna o valor do atriuto <code>dataFinal</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getDataFinal() {

		return this.dataFinal;
	}

	/**
	 * Define o valor do atributo <code>dataFinal</code>.
	 * 
	 * @param dataFinal
	 */
	public void setDataFinal(final Date dataFinal) {

		this.dataFinal = dataFinal;
	}

	/**
	 * Retorna o valor do atriuto <code>status</code>
	 * 
	 * @return <code>EnumStatus</code>
	 */
	public EnumStatus getStatus() {

		return this.status;
	}

	/**
	 * Define o valor do atributo <code>status</code>.
	 * 
	 * @param status
	 */
	public void setStatus(final EnumStatus status) {

		this.status = status;
	}

	/**
	 * Retorna o valor do atriuto <code>tipoSelecao</code>
	 * 
	 * @return <code>EnumTipoSelecao</code>
	 */
	public EnumTipoSelecao getTipoSelecao() {

		return this.tipoSelecao;
	}

	/**
	 * Define o valor do atributo <code>tipoSelecao</code>.
	 * 
	 * @param tipoSelecao
	 */
	public void setTipoSelecao(final EnumTipoSelecao tipoSelecao) {

		this.tipoSelecao = tipoSelecao;
	}

	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @return
	 */
	public boolean isSelecaoMultipla() {
		
		return EnumTipoSelecao.MULTIPLA.equals(this.tipoSelecao);
	}
	
	/**
	 * Método responsável por
	 *
	 * @author fabrica
	 *
	 * @return
	 */
	public boolean isSelecaoUnica() {
		
		return EnumTipoSelecao.UNICA.equals(this.tipoSelecao);
	}
}
