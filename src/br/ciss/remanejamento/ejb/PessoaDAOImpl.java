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
			bdManager.persist(pessoa);
			bdManager.flush();
			
			return pessoa;
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
	public Boolean remover(Pessoa pessoa) throws Exception {
		try {
			bdManager.remove(pessoa);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
