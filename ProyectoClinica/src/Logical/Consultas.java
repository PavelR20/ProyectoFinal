package Logical;

import java.util.Date;

public class Consultas {
	
	private String idConsulta;
	private Date fechaConsulta;
	private Enfermedad sintomas;
	private Medico doctor;
	private Paciente patient;
	
	public Consultas(String idConsulta, Date fechaConsulta, Enfermedad sintomas, Medico doctor, Paciente patient) {
		super();
		this.idConsulta = idConsulta;
		this.fechaConsulta = fechaConsulta;
		this.sintomas = sintomas;
		this.doctor = doctor;
		this.patient = patient;
	}
	public String getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Date getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public Enfermedad getSintomas() {
		return sintomas;
	}
	public void setSintomas(Enfermedad sintomas) {
		this.sintomas = sintomas;
	}
	public Paciente getPatient() {
		return patient;
	}
	public void setPatient(Paciente patient) {
		this.patient = patient;
	}
	public Medico getDoctor() {
		return doctor;
	}
	public void setDoctor(Medico doctor) {
		this.doctor = doctor;
	}
	
}