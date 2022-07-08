package com.empresaprevencionriesgos.model;

public class ContactoDTO {

	private String mensaje;
	private String rutCliente;

	public ContactoDTO(String mensaje, String rutCliente) {
		super();
		this.mensaje = mensaje;
		this.rutCliente = rutCliente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	
	@Override
	public String toString() {
		return "ContactoDTO [mensaje=" + mensaje + ", rutCliente=" + rutCliente + "]";
	}
	
	
	

}
