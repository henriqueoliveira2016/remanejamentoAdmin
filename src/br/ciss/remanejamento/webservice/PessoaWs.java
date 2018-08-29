package br.ciss.remanejamento.webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.ciss.remanejamento.ejb.PessoaDAO;
import br.ciss.remanejamento.objeto.Pessoa;

@Path(value = "pessoaws")
@Stateless
public class PessoaWs {
	
	@EJB
	PessoaDAO pessoaDAO;
	
	@Path(value = "/salvar")
	@POST
	@Produces(value = MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public String salvar(@Context HttpServletRequest context, Pessoa pessoa) {
		Gson gson = new Gson();
		try {
			pessoaDAO.salvar(pessoa);
			return gson.toJson(pessoa);
		} catch(Exception e) {
			return gson.toJson(e.getMessage());
		}
	}
	
	@Path(value = "/gettodos")
	@GET
	@Produces(value = MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public String getTodos(@Context HttpServletRequest context) {
		Gson gson = new Gson();
		try {
			return gson.toJson(pessoaDAO.getTodos());
		} catch (Exception e) {
			return gson.toJson(e.getMessage());
		}
	}
	

}
