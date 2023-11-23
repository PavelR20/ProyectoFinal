package Logical;

import java.sql.Date;

public class Cita {
	private String idCita;
	private Paciente paciente;
	private Medico doc;
	private Date fecha;
	
	public Cita(String idCita, Paciente paciente, Medico doc, Date fecha) {
		super();
		this.idCita = idCita;
		this.paciente = paciente;
		this.doc = doc;
		this.fecha = fecha;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
