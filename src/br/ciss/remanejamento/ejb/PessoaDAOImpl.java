package br.ciss.remanejamento.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ciss.remanejamento.objeto.Pessoa;

@Stateless
public class PessoaDAOImpl implements PessoaDAO{

	@PersistenceContext
	EntityManager bdManager;
	
	@Override
	public Pessoa salvar(Pessoa pessoa) throws Exception {
		try {
			if (pessoa.getIdPessoa() == null) {
				bdManager.persist(pessoa);
			} else {
				bdManager.getReference(pessoa.getClass(), pessoa.getIdPessoa());
				bdManager.merge(pessoa);
			}
			
			bdManager.flush();
			
			return pessoa
					;
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<Pessoa> getTodos() throws Exception {
		try {
			Query query = bdManager.createQuery("Select pe from Pessoa pe order by pe.idPessoa desc");
			List<Pessoa> retorno = (List<Pessoa>) query.getResultList();
			return retorno;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void excluir(Long idPessoa) throws Exception {
		try {
			Pessoa pessoa = bdManager.getReference(Pessoa.class, idPessoa);
			bdManager.remove(pessoa);
			bdManager.flush();

		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public Pessoa getById(Long idPessoa) throws Exception {
		try {
			Query query = bdManager.createQuery("SELECT p FROM Pessoa p WHERE p.idPessoa = ?");
			query.setParameter(1, idPessoa);
			Pessoa pessoa = (Pessoa) query.getSingleResult();
			return pessoa;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
