package br.com.cezar.app.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>
 * <b>Title:</b> Voto
 * </p>
 * 
 * <p>
 * <b>Description:</b> Voto
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Entity
@Table(name = "tb_votos")
@SequenceGenerator(name = Entidade.GENERATOR, sequenceName = "seq_tb_votos", allocationSize = 1)
public class Voto extends Entidade {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6999420285257752754L;

	@Column(name = "DT_VOTO", nullable = false)
	/** Atributo data. */
	private Date data;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OPCAO")
	/** Atributo opcao. */
	private Opcao opcao;

	/**
	 * Retorna o valor do atriuto <code>data</code>
	 * 
	 * @return <code>Date</code>
	 */
	public Date getData() {

		return data;
	}

	/**
	 * Define o valor do atributo <code>data</code>.
	 * 
	 * @param data
	 */
	public void setData(Date data) {

		this.data = data;
	}

	/**
	 * Retorna o valor do atriuto <code>opcao</code>
	 * 
	 * @return <code>Opcao</code>
	 */
	public Opcao getOpcao() {

		return opcao;
	}

	/**
	 * Define o valor do atributo <code>opcao</code>.
	 * 
	 * @param opcao
	 */
	public void setOpcao(Opcao opcao) {

		this.opcao = opcao;
	}

}
