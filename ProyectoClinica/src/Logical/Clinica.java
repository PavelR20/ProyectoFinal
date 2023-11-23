package Logical;

import java.util.ArrayList;

public class Clinica {
	
	private ArrayList<Medico> misMedico;
	private ArrayList<Paciente> misPaciente;
	private ArrayList<Consultas> misConsultas;
	private static Clinica clinica = null;
	private static int generadorCodigoConsulta = 1;
	private static int generadorCodigoEnfermedad = 1;
	private static int generadorCodigoHistorialMed = 1;
	private static int generadorCodigoidMedico = 1;
	private static int generadorCodigoVacuna = 1;
	private static int generadorCodigoVivienda = 1;
	
	public Clinica() {
		super();
		this.misMedico = new ArrayList<Medico>();
		this.misPaciente = new ArrayList<Paciente>();
		this.misConsultas = new ArrayList<Consultas>();
	}
	
	public static Clinica getInstance(){
		if(clinica == null){
			clinica = new Clinica();
		}		
		return clinica;
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
	
	// A partir de aqui pongamos los metodos...
	
	
	
	
}
