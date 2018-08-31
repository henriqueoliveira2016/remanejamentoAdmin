package br.ciss.remanejamento.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

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
	@POST
	@Produces(value = MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public String getTodos(@Context HttpServletRequest context) {
		Gson gson = new Gson();
		try {
			List<Pessoa> pessoas = pessoaDAO.getTodos();
			return gson.toJson(pessoas);
		} catch (Exception e) {
			return gson.toJson(e.getMessage());
		}
	}
	
	@Path(value = "/remover/{idPessoa}")
	@GET
	@Produces(value = MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public String remover(@Context HttpServletRequest context, @PathParam("idPessoa") Long idPessoa) {
		Gson gson = new Gson();
		try {
			pessoaDAO.remover(idPessoa);
			return gson.toJson(true);
		} catch(Exception e) {
			return gson.toJson(e.getMessage());
		}
	}
	
	@Path(value = "/getById")
	@GET
	@Produces(value = MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public String getById(@Context HttpServletRequest context, @QueryParam("idPessoa") Long idPessoa) {
		Gson gson = new Gson();
		try {
			return gson.toJson(pessoaDAO.getById(idPessoa));
		} catch (Exception e) {
			return gson.toJson(e.getMessage());
		}
	}

}
