package br.com.epedido.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.epedido.enumerators.ResponseTypes;

public class ResponseAPI {

	private Object data;
	private List<String> messages;
	@JsonIgnore
	private int statusCode;
	@JsonIgnore
	private String frase;
	@JsonIgnore
	private Map<String, String> headers;
	private ResponseTypes type;
	
	/*Construtor*/
	public ResponseAPI(){
		setMessages(new ArrayList<String>());
		this.setHeaders(new HashMap<String, String>());
	}
	
	/*status*/
	public ResponseAPI status(ResponseTypes code){
		setType(code);
		statusCode = getType().getStatusCode();
		return this;
	}
	
	
	/*Tipos e status*/
	public ResponseAPI serverError(){
		setType(ResponseTypes.SERVER_ERROR);
		statusCode = getType().getStatusCode();
		return this;
	}
	
	public ResponseAPI error(){
		setType(ResponseTypes.ERROR);
		statusCode = getType().getStatusCode();
		return this;
	}
	
	public ResponseAPI unauthorized(){
		setType(ResponseTypes.UNAUTHORIZED);
		statusCode = getType().getStatusCode();
		return this;
	}
	
	public ResponseAPI forbidden(){
		setType(ResponseTypes.FORBIDDEN);
		statusCode = getType().getStatusCode();
		return this;
	}
	
	public ResponseAPI success(){
		setType(ResponseTypes.SUCCESS);
		statusCode = getType().getStatusCode();
		return this;
	}

	public ResponseAPI information(){
		setType(ResponseTypes.INFORMATION);
		statusCode = getType().getStatusCode();
		return this;
	}

	public ResponseAPI confirmation(){
		setType(ResponseTypes.CONFIRMATION);
		statusCode = getType().getStatusCode();
		return this;
	}
	
	/*Mensagens*/
	public List<String> getMessages() {
		return messages;
	}
	
	public ResponseAPI message(String message){
		getMessages().add(message);
		return this;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public ResponseAPI messages(List<String> messages){
		this.setMessages(messages);
		return this;
	}

	public boolean hasMensages(){
		return getMessages().isEmpty() ? false : true;
	}
	
	public void clearMessages() {
		this.getMessages().clear();
	}
	
	public ResponseAPI frase(String frase){
		this.frase = frase;
		return this;
	}
	
	public boolean hasError(){
		return this.getType().equals(ResponseTypes.ERROR);
	}

	/*header*/
	public ResponseAPI header(String header, String valor){
		this.getHeaders().put(header, valor);
		return this;
	}

	/*data*/
	public ResponseAPI data(Object object){
		setData(object);
		return this;
	}
	
	public <T> T getData(Class<T> clazz) {		
		return clazz.cast(data);
	}
	
	
	/*build*/
	public Response build(){
		
		ResponseBuilder response = Response.status(statusCode).type(MediaType.APPLICATION_JSON).entity(this);

		for (Entry<String, String> header : getHeaders().entrySet()) {
			response.header(header.getKey(), header.getValue());
		}
		
		return response.build();		
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public ResponseTypes getType() {
		return type;
	}

	public void setType(ResponseTypes type) {
		this.type = type;
	}
	
}
