package br.ciss.remanejamento.ejb;

import java.util.List;

import javax.ejb.Local;

import br.ciss.remanejamento.objeto.Pessoa;

@Local
public interface PessoaDAO {

	public Pessoa salvar(Pessoa pessoa) throws Exception;
	
	public List<Pessoa> getTodos() throws Exception;

	public void excluir(Long idPessoa) throws Exception;
	
	public Pessoa getById(Long idPessoa) throws Exception;

}
