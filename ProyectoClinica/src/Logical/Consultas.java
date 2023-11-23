package Logical;

import java.util.Date;

public class Consultas {
	
	private String idConsulta;
	private Date fechaConsulta;
	private Medico idMedico;
	private Enfermedad sintomas;
	private Vacuna diagnostico;
	
	public Consultas(String idConsulta, Date fechaConsulta, Medico idMedico, Enfermedad sintomas, Vacuna diagnostico) {
		super();
		this.idConsulta = idConsulta;
		this.fechaConsulta = fechaConsulta;
		this.idMedico = idMedico;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
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

	public Medico getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}

	public Enfermedad getSintomas() {
		return sintomas;
	}

	public void setSintomas(Enfermedad sintomas) {
		this.sintomas = sintomas;
	}

	public Vacuna getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Vacuna diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	
	
	

}
