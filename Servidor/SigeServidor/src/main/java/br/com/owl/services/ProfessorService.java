package br.com.owl.services;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.owl.application.ProfessorApplication;

@Path("/professor")
public class ProfessorService {

	private ProfessorApplication professorApplication;
	
	public ProfessorService() {
		this.professorApplication = new ProfessorApplication();
	}
	
	@Path("/salvar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(String conteudo){
		professorApplication.salvar(conteudo);
		URI uri = URI.create("/aluno/salvar");
		return Response.created(uri).build();
	}
	
	@Path("buscar")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscar(){
		return Response.ok(this.professorApplication.buscar()).build();
	}
	
	@Path("buscar/{id}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")int id){
		return Response.ok(this.professorApplication.buscar(id)).build();
	}
}
