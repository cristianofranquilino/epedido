package br.com.epedido.login;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;

import br.com.epedido.widget.ResponseAPI;

@PreMatching
@Provider
public class Interceptor implements ContainerRequestFilter, ContainerResponseFilter {

	private static final ServerResponse EXPIRED  = new ServerResponse(new ResponseAPI().unauthorized().message("Sua sessão expirou. Por favor, efetue o login novamente."), 401, new Headers<Object>());
	
	
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		
		 responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
	        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
	        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");     
		
		
		
	}

	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("teste 1");	
		
		ResourceMethod methodInvoker = (ResourceMethod) requestContext.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
        Method method = methodInvoker.getMethod();
        requestContext.abortWith(EXPIRED);
	}

}
