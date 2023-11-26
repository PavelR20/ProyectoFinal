package Logical;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medico extends Persona {
	
	private String idMedico;
	private String especialidad;
	List<String> listaPacientesAsignados;
	
	public Medico(String cedula, String nombre, String genero, Date fechaNacimiento, String telefono, String idMedico,
			String especialidad) {
		super(cedula, nombre, genero, fechaNacimiento, telefono);
		this.idMedico = idMedico;
		this.especialidad = especialidad;
		this.listaPacientesAsignados = new ArrayList<>();
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	 public void asignarPaciente(String paciente) {

	        listaPacientesAsignados.add(paciente);
	        // System.out.println("Paciente " + paciente + " asignado al médico " + nombre + "."); //Prueba cambiar...
	    }
	 
	 public void generarInformeMedico(String paciente, String sintomas, String diagnostico, String tratamiento) {
	        if (listaPacientesAsignados.contains(paciente)) {
	            
	        } else {
	            
	        }
	    }
}
