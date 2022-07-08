package com.empresaprevencionriesgos.model;

import java.time.LocalDate;

public class AdministrativoDTO extends UsuarioDTO {

	private String area;
	private String experienciaPrevia;

	public AdministrativoDTO(String nick, String password1, String rut, String nombres, String apellidos,
			LocalDate fechaDeNacimiento, int perfilId, String area, String experienciaPrevia) {
		super(nick, password1, rut, nombres, apellidos, fechaDeNacimiento, perfilId);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	@Override
	public String toString() {
		return "AdministrativoDTO [area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
	}

}
