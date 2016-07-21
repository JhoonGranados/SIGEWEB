package br.com.owl.servidor;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Start {
	public static void main(String[] args) {

		 //inicializarDadosComMock
		
		 ResourceConfig config = new ResourceConfig().packages("br.com.owl");
		 URI uri = URI.create("http://localhost:8080/");
		 HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,
		 config);
		 //server.setHeader("Access-Control-Allow-Origin" , "*");
		
		 System.out.println("Servidor Rodando");
		 try {
			 System.in.read();
		 } catch (IOException e) {
			 System.out.println(e.getMessage());
		 }
		 server.stop();
	}
}
