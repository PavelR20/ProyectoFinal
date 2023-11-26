package Logical;

import java.util.Date;

public class Paciente extends Persona {
	
	private String idPaciente;
	private String infoEmergencia;
	private HistoriaMedica historial;
	
	public Paciente(String cedula, String nombre, String genero, Date fechaNacimiento, String telefono,
			String idPaciente, String infoEmergencia, HistoriaMedica historial) {
		super(cedula, nombre, genero, fechaNacimiento, telefono);
		this.idPaciente = idPaciente;
		this.infoEmergencia = infoEmergencia;
		this.historial = historial;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getInfoEmergencia() {
		return infoEmergencia;
	}

	public void setInfoEmergencia(String infoEmergencia) {
		this.infoEmergencia = infoEmergencia;
	}

	public HistoriaMedica getHistorial() {
		return historial;
	}

	public void setHistorial(HistoriaMedica historial) {
		this.historial = historial;
	}
	
	

	
	
	

}
