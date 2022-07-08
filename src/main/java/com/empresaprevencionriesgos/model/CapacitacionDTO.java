package com.empresaprevencionriesgos.model;

public class CapacitacionDTO {

	private long identificador;
	private int diaId; // 1-lunes, 2-martes, ...
	private String hora;
	private String lugar;
	private int duracion; // duracion es en minutos
	private int cantidadDeAsistentes;
	private String rutCliente;

	public CapacitacionDTO(long identificador, int diaId, String hora, String lugar, int duracion,
			int cantidadDeAsistentes, String rutCliente) {
		super();
		this.identificador = identificador;
		this.diaId = diaId;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadDeAsistentes = cantidadDeAsistentes;
		this.rutCliente = rutCliente;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public int getDiaId() {
		return diaId;
	}

	public void setDiaId(int diaId) {
		this.diaId = diaId;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getCantidadDeAsistentes() {
		return cantidadDeAsistentes;
	}

	public void setCantidadDeAsistentes(int cantidadDeAsistentes) {
		this.cantidadDeAsistentes = cantidadDeAsistentes;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	

	@Override
	public String toString() {
		return "CapacitacionDTO [identificador=" + identificador + ", diaId=" + diaId + ", hora=" + hora + ", lugar="
				+ lugar + ", duracion=" + duracion + ", cantidadDeAsistentes=" + cantidadDeAsistentes + ", rutCliente="
				+ rutCliente + "]";
	}

}
