package br.com.epedido.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.epedido.service.TipoPagamentoService;
import br.com.epedido.widget.ResponseAPI;

@Path("/auxiliares/tipo-pagamento")
@Consumes("application/json")
@Produces("application/json")
public class TipoPagamentoResource {
	
	@Inject private TipoPagamentoService service;
	@Inject	ResponseAPI response;
	
	@GET
	public Response get(){
		System.out.println("ABC");
		return response.data(service.getAll()).success().build();
		//String result = "Restful example : ";

		//return Response.status(200).entity(result).build();
	}
	
}
