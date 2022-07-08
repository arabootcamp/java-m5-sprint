package com.empresaprevencionriesgos.model;

import java.time.LocalDate;

public class UsuarioDTO {

	//
	private String nick;
	private String password1;
	private String rut;
	private String nombres;
	private String apellidos;
	private LocalDate fechaDeNacimiento;
	private int perfilId; // 1-admin, 2-cliente, 3-profesional

	public UsuarioDTO(String nick, String password1, String rut, String nombres, String apellidos,
			LocalDate fechaDeNacimiento, int perfilId) {
		super();
		this.nick = nick;
		this.password1 = password1;
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.perfilId = perfilId;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public int getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(int perfilId) {
		this.perfilId = perfilId;
	}
	

	public String getPerfilNombre() {
		if(this.perfilId==1) return "administrativo";
		if(this.perfilId==2) return "cliente";
		if(this.perfilId==3) return "profesional";
		return null;
	}

	public String urlEditarUsuario() {
		return "EditarUsuario?rut=" + this.getRut()+"&perfil_id="+this.perfilId;
	}
	
	public String urlEliminarUsuario() {
		return "EliminarUsuario?rut=" + this.getRut();
	}
	
	public String fechaFormatoFormulario() {
		
		String[] arregloFecha = this.fechaDeNacimiento.toString().split("-");
		return arregloFecha[2] + '-' + arregloFecha[1] + '-' + arregloFecha[0];
	}

	
	@Override
	public String toString() {
		return "UsuarioDTO [nick=" + nick + ", password1=" + password1 + ", rut=" + rut + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", fechaDeNacimiento=" + fechaDeNacimiento + ", perfilId=" + perfilId
				+ "]";
	}
	
	
}
