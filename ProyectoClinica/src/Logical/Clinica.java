package Logical;

import java.util.ArrayList;

public class Clinica {
	
	private ArrayList<Medico> misMedico;
	private ArrayList<Paciente> misPaciente;
	private ArrayList<Consultas> misConsultas;
	
	public Clinica(ArrayList<Medico> misMedico, ArrayList<Paciente> misPaciente, ArrayList<Consultas> misConsultas) {
		super();
		this.misMedico = misMedico;
		this.misPaciente = misPaciente;
		this.misConsultas = misConsultas;
	}

	public ArrayList<Medico> getMisMedico() {
		return misMedico;
	}

	public void setMisMedico(ArrayList<Medico> misMedico) {
		this.misMedico = misMedico;
	}

	public ArrayList<Paciente> getMisPaciente() {
		return misPaciente;
	}

	public void setMisPaciente(ArrayList<Paciente> misPaciente) {
		this.misPaciente = misPaciente;
	}

	public ArrayList<Consultas> getMisConsultas() {
		return misConsultas;
	}

	public void setMisConsultas(ArrayList<Consultas> misConsultas) {
		this.misConsultas = misConsultas;
	}
	
	
	

}
