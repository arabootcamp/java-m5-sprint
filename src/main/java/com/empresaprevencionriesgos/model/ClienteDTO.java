package com.empresaprevencionriesgos.model;

import java.time.LocalDate;

public class ClienteDTO extends UsuarioDTO {

	private String telefono;
	private String email;
	private int afpId;
	private int sistemaSaludId;
	private String direccion;
	private String comuna;
	private String organizacion;

	public ClienteDTO(String nick, String password1, String rut, String nombres, String apellidos,
			LocalDate fechaDeNacimiento, int perfilId, String telefono, String email, int afpId, int sistemaSaludId,
			String direccion, String comuna, String organizacion) {
		super(nick, password1, rut, nombres, apellidos, fechaDeNacimiento, perfilId);
		this.telefono = telefono;
		this.email = email;
		this.afpId = afpId;
		this.sistemaSaludId = sistemaSaludId;
		this.direccion = direccion;
		this.comuna = comuna;
		this.organizacion = organizacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAfpId() {
		return afpId;
	}

	public void setAfpId(int afpId) {
		this.afpId = afpId;
	}

	public int getSistemaSaludId() {
		return sistemaSaludId;
	}

	public void setSistemaSaludId(int sistemaSaludId) {
		this.sistemaSaludId = sistemaSaludId;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	
	@Override
	public String toString() {
		return "ClienteDTO [telefono=" + telefono + ", email=" + email + ", afpId=" + afpId + ", sistemaSaludId="
				+ sistemaSaludId + ", direccion=" + direccion + ", comuna=" + comuna + ", organizacion=" + organizacion
				+ "]";
	}
	

}
