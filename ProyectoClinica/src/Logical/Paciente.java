package Logical;

import java.util.Date;

public class Paciente extends Persona {
	
	private String idPaciente;
	private String infoEmergencia;
	
	public Paciente(String cedula, String nombre, String genero, Date fechaNacimiento, String telefono,
			String idPaciente, String infoEmergencia) {
		super(cedula, nombre, genero, fechaNacimiento, telefono);
		this.idPaciente = idPaciente;
		this.infoEmergencia = infoEmergencia;
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
	
	

	
	
	

}
