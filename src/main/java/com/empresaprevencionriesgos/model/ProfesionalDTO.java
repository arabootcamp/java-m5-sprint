package com.empresaprevencionriesgos.model;

import java.time.LocalDate;

public class ProfesionalDTO extends UsuarioDTO {

	private String titulo;
	private LocalDate fechaDeIngreso;

	public ProfesionalDTO(String nick, String password1, String rut, String nombres, String apellidos,
			LocalDate fechaDeNacimiento, int perfilId, String titulo, LocalDate fechaDeIngreso) {
		super(nick, password1, rut, nombres, apellidos, fechaDeNacimiento, perfilId);
		this.titulo = titulo;
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

    public LocalDate getFechaDeIngreso() {
		
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public String fechaDeIngresoFommatoDMY() {
		String[] arregloFecha = this.fechaDeIngreso.toString().split("-");
		return arregloFecha[2] + '-' + arregloFecha[1] + '-' + arregloFecha[0];
	}
	
	@Override
	public String toString() {
		return "ProfesionalDTO [titulo=" + titulo + ", fechaDeIngreso=" + fechaDeIngreso + "]";
	}
	
	

}
