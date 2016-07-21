package br.com.owl.application.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.owl.application.application.TurmaApplication;

@Path("/turma")
public class TurmaService {
	
	private TurmaApplication turmaApplication;
	
	public TurmaService() {
		turmaApplication = new TurmaApplication();
	}
	
	@GET
	@Path("buscarSeries")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaSeries(){
		String json = new Gson().toJson(this.turmaApplication.buscarSeries());
		return Response.ok(json).build();
	}
	
}
