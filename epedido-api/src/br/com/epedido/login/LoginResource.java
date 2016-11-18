package br.com.epedido.login;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

	@POST
	public Response printMessage(String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}

	
}
