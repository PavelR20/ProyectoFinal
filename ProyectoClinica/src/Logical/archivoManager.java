package Logical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class archivoManager {

	private static final String FILE_PATH = "usuarios.txt";	
	private static final String FILE_PATH1 = "Medico.txt";
	private static final String FILE_PATH2 = "Paciente.txt";
	private static final String FILE_PATH3 = "vacunas.txt";
	private static final String FILE_PATH4 = "enfermedad.txt";
	private static final String FILE_PATH5 = "vivienda.txt";
	private static final String FILE_PATH6 = "consultas.txt";
	private static final String FILE_PATH7 = "citas.txt";
	private static final String FILE_PATH8 = "historial.txt";

	// Usuarios 

	public static void GuardarUsuarios(ArrayList<Usuario> usuarios) {
		try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH, true)))) {
			for (Usuario usuario : usuarios) {
				writer.write(usuario.getIdUsuario() + ","
						+ usuario.getNombreUser() + ","
						+ usuario.getPassword() + ","
						+ usuario.getRol());
					writer.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Usuario> LeerUsuario() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 4) {
					usuarios.add(new Usuario(parts[0], parts[1], parts[2], parts[3]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public static void borrarUsuario(Usuario usuario) {
		ArrayList<Usuario> listaUsuarios = LeerUsuario();

		if (usuario != null) {
			listaUsuarios.remove(usuario);
			GuardarUsuarios(listaUsuarios);
		}
	}

	// medicos 
	/*
	public static void borrarMedico(Medico medico) {
		ArrayList<Medico> listaMedico = leerMedico();

		if (medico != null) {
			listaMedico.remove(medico);
			g(listaMedico);
		}
	}
	*/
	public static void guardarMedicoEnArchivo(Medico medico) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH1, true)))) {
			writer.println(medico.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Medico> leerMedico() {
		ArrayList<Medico> medicos = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH1))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 9) { 
					medicos.add(new Medico(parts[0], parts[1], parts[2], 
							parseDate(parts[3]), parts[4], 
							new Vivienda(parts[1], parts[2], parts[3], new ArrayList<Persona>()), 
							parts[6], parts[7]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return medicos;
	}

	// Paciente 

	public static void guardarPacienteEnArchivo(Paciente paciente) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH2, true)))) {
			writer.println(paciente.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Paciente> leerPacientes() {
		ArrayList<Paciente> pacientes = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH2))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 10) {

					Vivienda vivienda = new Vivienda(parts[6], parts[7], parts[8], new ArrayList<Persona>());
					Paciente paciente = new Paciente(parts[0], parts[1], parts[2], parseDate(parts[3]), parts[4],
							parts[5], vivienda, parts[9], new HistoriaMedica(new ArrayList<>()));

					pacientes.add(paciente);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pacientes;
	}

	// Vacuna 

	public static void guardarVacunaEnArchivo(Vacuna vac) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH3, true)))) {
			writer.println(vac.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Vacuna> leerVacuna() {
		ArrayList<Vacuna> vacunas = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH3))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 5) { 
					vacunas.add(new Vacuna(parts[0], parts[1], 
							new Paciente(parts[0], parts[1], parts[2], parseDate(parts[3]), parts[4],
									parts[5], new Vivienda(parts[6], parts[7], parts[8], new ArrayList<Persona>()), parts[9], new HistoriaMedica(new ArrayList<>())), 
							Integer.parseInt(parts[3]), 
							parts[4]));
				}
			}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}

		return vacunas;
	}

	// enfermedad 

	public static void guardarEnfermedadEnArchivo(Enfermedad enfe) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH4, true)))) {
			writer.println(enfe.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Enfermedad> leerEnfermedad() {
		ArrayList<Enfermedad> enfermedades = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH4))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) { 
					enfermedades.add(new Enfermedad(parts[0], parts[1], parts[2], parts[3], 
							new Vacuna(parts[0], parts[1], 
									new Paciente(parts[0], parts[1], parts[2], parseDate(parts[3]), parts[4],
											parts[5], new Vivienda(parts[6], parts[7], parts[8], new ArrayList<Persona>()), parts[9], new HistoriaMedica(new ArrayList<>())), 
									Integer.parseInt(parts[3]), 
									parts[4]), Boolean.parseBoolean(parts[5])));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return enfermedades;
	}


	// vivienda

	public static void guardarViviendaEnArchivo(Vivienda vivienda) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH5, true)))) {
			writer.println(vivienda.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Vivienda> leerVivienda() {
		ArrayList<Vivienda> viviendas = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH5))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 3) { 
					viviendas.add(new Vivienda(parts[0], parts[1], parts[2], new ArrayList<>()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return viviendas;
	}


	// consultas 

	public static void guardarConsultasEnArchivo(Consultas consu) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH6, true)))) {
			writer.println(consu.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Consultas> leerConsulta() {
		ArrayList<Consultas> consultas = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH6))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 5) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaConsulta = dateFormat.parse(parts[1]);

					List<Enfermedad> sintomas = new ArrayList<>();
					String[] sintomasArray = parts[2].split(";");
					for (String sintoma : sintomasArray) {
						sintomas.add(new Enfermedad(parts[0], parts[1], parts[2], parts[3], 
								new Vacuna(parts[0], parts[1], 
										new Paciente(parts[0], parts[1], parts[2], parseDate(parts[3]), parts[4],
												parts[5], new Vivienda(parts[6], parts[7], parts[8], new ArrayList<Persona>()), parts[9], new HistoriaMedica(new ArrayList<>())), 
										Integer.parseInt(parts[3]), 
										parts[4]), Boolean.parseBoolean(parts[5])));
					}

					consultas.add(new Consultas(parts[0], fechaConsulta, sintomas,
							new Medico(parts[0], parts[1], parts[2], 
									parseDate(parts[3]), parts[4], 
									new Vivienda(parts[6], parts[7], parts[8], new ArrayList<Persona>()), 
									parts[8], parts[9]),
							new Paciente(parts[0], parts[1], parts[2], parseDate(parts[3]), parts[4],
									parts[5], new Vivienda(parts[6], parts[7], parts[8], new ArrayList<Persona>()), parts[9], new HistoriaMedica(new ArrayList<>()))));
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return consultas;
	}


	// citas 

	public static void guardarCitasEnArchivo(Cita cita) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH7, true)))) {
			writer.println(cita.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Cita> leerCita() {
		ArrayList<Cita> citas = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH7))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 4) { 
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaCita = dateFormat.parse(parts[3]);


					citas.add(new Cita(parts[0], 
							new Paciente(parts[0], parts[1], parts[2], parseDate(parts[3]), parts[4],
									parts[5], new Vivienda(parts[6], parts[7], parts[8], new ArrayList<Persona>()), parts[9], new HistoriaMedica(new ArrayList<>())),
							new Medico(parts[0], parts[1], parts[2], 
									parseDate(parts[3]), parts[4], 
									new Vivienda(parts[6], parts[7], parts[8], new ArrayList<Persona>()), 
									parts[8], parts[9]),
							fechaCita));
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return citas;
	}


	// historial 

	public static void guardarHistorialEnArchivo(HistoriaMedica HM) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH8, true)))) {
			writer.println(HM.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<HistoriaMedica> leerHistorias() {
		ArrayList<HistoriaMedica> historias = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length > 0) { 
					String idHistoria = parts[0]; 
					ArrayList<Consultas> consultas = leerConsultas(idHistoria); 

					HistoriaMedica historia = new HistoriaMedica(consultas);
					historias.add(historia);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return historias;
	}


	// Otros

	private static Date parseDate(String dateStr) {
		return null;
	}

	private static ArrayList<Consultas> leerConsultas(String idHistoria) {
		return new ArrayList<>(); 
	}

}	
