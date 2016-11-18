package br.com.epedido.enumerators;

public enum ResponseTypes {
	SERVER_ERROR(500), ERROR(400), UNAUTHORIZED(401), FORBIDDEN(403), SUCCESS(200), INFORMATION(200), CONFIRMATION(200);
	
	private int statusCode;
	
	ResponseTypes(int status){
		this.statusCode = status;
	}
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
