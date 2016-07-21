package br.com.owl.application.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.owl.application.application.ProfessorApplication;
import br.com.owl.application.dto.ProfessorForm;
import br.com.owl.application.dto.TarefaForm;

@Path("/professor")
public class ProfessorService {
	
	private ProfessorApplication professorApplication;
	
	public ProfessorService() {
		professorApplication = new ProfessorApplication();
	}
	
	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(String json){
		ProfessorForm professorForm = new Gson().fromJson(json, ProfessorForm.class);
		this.professorApplication.salvar(professorForm);
		URI uri = URI.create("/professor/salvar");
		return Response.created(uri).build();
	}
	
	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(){
		List<ProfessorForm> professores = this.professorApplication.buscar();
		String json = new Gson().toJson(professores);
		return Response.ok(json).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id") int id){
		ProfessorForm professorForm = this.professorApplication.buscar(id);
		String json = new Gson().toJson(professorForm);
		return Response.ok(json).build();
	}
	
	@DELETE
	@Path("/remove/{id}")
	public Response remover(@PathParam("id") int id){
		this.professorApplication.remover(id);
		URI uri = URI.create("/professor/remove");
		return Response.created(uri).build();
	}
	
	
	@POST
	@Path("/salvarTarefa")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarTarefa(String json){
		TarefaForm tarefa = new Gson().fromJson(json, TarefaForm.class);
		this.professorApplication.salvarTarefa(tarefa);
		URI uri = URI.create("/professor/salvarTarefa");
		return Response.created(uri).build();
	}
	
	@GET
	@Path("/buscarTarefas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTarefas(){
		List<TarefaForm> listaTarefasForm = this.professorApplication.buscarTarefas();
		String json = new Gson().toJson(listaTarefasForm);
		return Response.ok(json).build();
	}
}
