package Logical;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Clinica {
	
	private ArrayList<Medico> misMedico;
	private ArrayList<Paciente> misPaciente;
	private ArrayList<Consultas> misConsultas;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Cita> misCitas;
	private ArrayList<Usuario>misUsuarios;
	private ArrayList<Enfermedad> misEnfermedades;
	List<String> listaPacientesAsignados;
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
		this.misVacunas = new ArrayList<Vacuna>();
		this.misUsuarios = new ArrayList<Usuario>();
		this.listaPacientesAsignados = new ArrayList();
		this.misEnfermedades = new ArrayList<Enfermedad>();
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

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	
	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}

	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}

	
	// A partir de aqui pongamos los metodos...
	
	
	  // Metodos para crear o insertar 
	
	 public void crearCita(String idCita, Paciente paciente, Medico medico, Date fecha) {
	       
	        if (misMedico.contains(medico) && misPaciente.contains(paciente)) {	     
	            if (verificarDisponibilidadMedico(medico, fecha)) {	              
	                Cita nuevaCita = new Cita(idCita, paciente, medico, fecha);
	                
	                misCitas.add(nuevaCita);
	                System.out.println("Cita creada con �xito.");
	            } else {
	                System.out.println("El m�dico no est� disponible en la fecha seleccionada.");
	            }
	        } else {
	            System.out.println("M�dico o paciente no encontrados.");
	        }
	    }
	 
	    public void agregarUsuario(Usuario usuario) {
	        misUsuarios.add(usuario);
	    }
	    
	    public void agregarMedico(Medico medico) {
	    	misMedico.add(medico);
	    }
	    public void agregarEnfermedad(Enfermedad enfermedad) { /* Hay que agregar los mismo al reves, digo el asignar medico a paciente. */
	    	misEnfermedades.add(enfermedad);
	    }

	    public void asignarPacienteMedico(String paciente) {
	        listaPacientesAsignados.add(paciente);
	        
	    }
	    
		public void insertarVacuna(Vacuna vacunas) {
			
			misVacunas.add(vacunas);
			System.out.println(misVacunas);
			generadorCodigoVacuna++;
			
		}
	    
	    // Metodo de busquedas para programa
	    
	    public Paciente obtenerPacienteXnombre(String nombre) {
			Paciente paciente = null;
			boolean encontrado = false;
			int i = 0;
			while (i < misPaciente.size()&& !encontrado) {
				if (misPaciente.get(i).getNombre().equalsIgnoreCase(nombre)) {
					paciente = misPaciente.get(i);
					encontrado = true;
				} 
				i++;
			}
			return paciente;
		}
	   
	    public Medico obtenerMedicoXnombre(String nombre) {
	    	Medico medic = null;
			boolean encontrado = false;
			int i = 0;
			while (i < misMedico.size()&& !encontrado) {
				if (misMedico.get(i).getNombre().equalsIgnoreCase(nombre)) {
					medic = misMedico.get(i);
					encontrado = true;
				} 
				i++;
			}
			return medic;
		}
	    
		public Vacuna obtenervacuna(String idVacuna) {
			
			Vacuna vacuna = null;
			boolean encontrado = false;
			int i = 0;
			while(i<misVacunas.size()&& !encontrado) {
				if(misVacunas.get(i).getIdVacuna().equalsIgnoreCase(idVacuna)) {
					vacuna = misVacunas.get(i);
					encontrado = true;
					break;
				}
				i++;
			}
			return vacuna;
		}
		
	    // Otros metodos 
	    
	    private String hashPassword(String password) {
		       
	        return String.valueOf(password.hashCode());
	    }
	    
	    public boolean login(String nombreUsuario, String password, String rol) {
	        for (Usuario usuario : misUsuarios) {
	            if (usuario.getNombreUser().equals(nombreUsuario) &&
	                usuario.getPassword().equals(hashPassword(password)) &&
	                usuario.getRol().equals(rol)) {
	                System.out.println("Inicio de sesi�n exitoso como " + rol);
	                return true;
	            }
	        }
	        System.out.println("Credenciales incorrectas o usuario no autorizado.");
	        return false;
	    }
	    
	    private boolean verificarDisponibilidadMedico(Medico medico, Date fecha) {
	        for (Cita cita : misCitas) {
	            if (cita.getDoc().equals(medico) && cita.getFecha().equals(fecha)) {
	                return false; 
	                }
	        }
	        return true; 
	    }
	}