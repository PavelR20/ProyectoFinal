package Logical;

import java.util.Date;

public class Cita {
	private String idCita;
	private Paciente paciente;
	private Medico doc;
	private java.util.Date fecha;

	public Cita(String idCita, Paciente paciente, Medico doc, java.util.Date fechaCita) {
		super();
		this.idCita = idCita;
		this.paciente = paciente;
		this.doc = doc;
		this.fecha = fechaCita;
	}

	public String toString() {

		return idCita + "," + paciente + "," + doc + "," + fecha;
	}

	public String getIdCita() {
		return idCita;
	}

	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getDoc() {
		return doc;
	}

	public void setDoc(Medico doc) {
		this.doc = doc;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
