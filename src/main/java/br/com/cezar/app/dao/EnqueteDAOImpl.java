package br.com.cezar.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cezar.app.dto.ResultadoEnqueteDTO;
import br.com.cezar.app.dto.ResultadoOpcaoDTO;
import br.com.cezar.app.modelo.Enquete;
import br.com.cezar.app.modelo.EnumStatus;
import br.com.cezar.app.modelo.Opcao;
import br.com.cezar.app.modelo.Voto;

/**
 * <p>
 * <b>Title:</b> EnqueteDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> EnqueteDAO
 * </p>
 * 
 * @author Cézar Augusto Ferreira
 * 
 * @version 1.0.0
 */
@Transactional
@Repository
public class EnqueteDAOImpl extends GenericDAO<Enquete> implements EnqueteDAO {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -927620559187206902L;

	@Autowired
	/** Atributo sessionFactory. */
	private SessionFactory sessionFactory;

	@Override
	public void delete(Long id) {

		Enquete enquete = this.get(id);

		enquete.setStatus(EnumStatus.INATIVO);

		this.update(enquete);
	}

	@Override
	protected Criteria criteriaList() {

		return super.criteriaList().add(Restrictions.eq("status", EnumStatus.ATIVO));
	}

	@Override
	public Class<Enquete> getEntityClass() {

		return Enquete.class;
	}

	/**
	 * Método responsável por verificar na base de dados se já existe uma enquete no período
	 * parametrizado
	 * 
	 * @author Cézar Augusto Ferreira
	 * 
	 * @param dataInicio
	 *            data de início do período
	 * 
	 * @param dataFinal
	 *            data final do período
	 * 
	 * @return true, caso exista alguma enquete no período, caso contrário, false
	 */
	public boolean existeEnqueteNoPeriodoInformado(Long id, Date dataInicio, Date dataFinal) {

		Criteria criteria = this.newCriteria();

		criteria.setProjection(Projections.rowCount());

		Disjunction dis = Restrictions.disjunction();

		dis.add(Property.forName("dataInicio").between(dataInicio, dataFinal));

		dis.add(Property.forName("dataFinal").between(dataInicio, dataFinal));

		criteria.add(dis);

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		if (id != null) {

			criteria.add(Restrictions.not(Restrictions.idEq(id)));
		}

		return ( (Long) criteria.uniqueResult() ) > 0;
	}

	@Override
	public SessionFactory getSessionFactory() {

		return this.sessionFactory;
	}

	public Enquete getEnquetePeriodo(Date date) {

		Criteria criteria = getCriteriaObterEnquetePeriodo(date);

		return (Enquete) criteria.uniqueResult();
	}

	private Criteria getCriteriaObterEnquetePeriodo(Date date) {

		Criteria criteria = this.criteriaList();

		criteria.add(Restrictions.le("dataInicio", date));

		criteria.add(Restrictions.ge("dataFinal", date));

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		return criteria;
	}

	public Opcao getOpcao(Long opcaoId) {

		return (Opcao) this.getSession().get(Opcao.class, opcaoId);
	}

	public void saveVoto(Voto voto) {

		this.getSession().save(voto);
	}

	/**
	 *
	 */
	public ResultadoEnqueteDTO getResultado(Date date) {

		Criteria criteria = this.getCriteriaObterEnquetePeriodo(date);

		return getResultado(criteria);
	}

	/**
	 * Método responsável por
	 * 
	 * @author fabrica
	 * 
	 * @param criteria
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ResultadoEnqueteDTO getResultado(Criteria criteria) {

		ProjectionList projs = Projections.projectionList();

		projs.add(Projections.property("pergunta"), "pergunta");

		projs.add(Projections.property("id"), "id");

		criteria.setProjection(projs);

		criteria.setResultTransformer(Transformers.aliasToBean(ResultadoEnqueteDTO.class));

		ResultadoEnqueteDTO resultado = (ResultadoEnqueteDTO) criteria.uniqueResult();

		if (resultado != null) {

			Long qtdVotos = getQuantidadeVotos(resultado);

			Criteria criteriaOpcao = this.getSession().createCriteria(Opcao.class);

			ProjectionList projsOpcao = Projections.projectionList();

			projsOpcao.add(Projections.property("conteudo"), "opcao");

			projsOpcao.add(Projections.property("id"), "id");

			criteriaOpcao.setProjection(projsOpcao);

			criteriaOpcao.add(Restrictions.eq("enquete.id", resultado.getId()));

			criteriaOpcao.setResultTransformer(Transformers.aliasToBean(ResultadoOpcaoDTO.class));

			List<ResultadoOpcaoDTO> opcoes = criteriaOpcao.list();

			for (ResultadoOpcaoDTO opcao : opcoes) {

				Criteria criteriaQuantidadeVotos = this.getSession().createCriteria(Opcao.class);

				criteriaQuantidadeVotos.createAlias("votos", "v");

				criteriaQuantidadeVotos.setProjection(Projections.countDistinct("v.id"));

				criteriaQuantidadeVotos.add(Restrictions.idEq(opcao.getId()));

				opcao.setQuantidade((Long) criteriaQuantidadeVotos.uniqueResult());

				opcao.setPercentual(qtdVotos > 0 ? ( ( opcao.getQuantidade() * 100 ) / qtdVotos ) : 0D);
			}

			resultado.setOpcoes(opcoes);
		}

		return resultado;
	}

	private Long getQuantidadeVotos(ResultadoEnqueteDTO resultado) {

		Criteria criteriaQtdVotos = this.getSession().createCriteria(Opcao.class);

		criteriaQtdVotos.createAlias("votos", "v");

		criteriaQtdVotos.createAlias("enquete", "e");

		criteriaQtdVotos.setProjection(Projections.countDistinct("v.id"));

		criteriaQtdVotos.add(Restrictions.eq("e.id", resultado.getId()));

		return (Long) criteriaQtdVotos.uniqueResult();
	}

	public ResultadoEnqueteDTO getResultado(Long idEnquete) {

		Criteria criteria = this.newCriteria();

		criteria.add(Restrictions.idEq(idEnquete));

		return this.getResultado(criteria);
	}
}
