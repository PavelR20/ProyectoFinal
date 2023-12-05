package Logical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	
	// 
		public static void GuardarUsuarios(ArrayList<Usuario> usuarios) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
	            for (Usuario usuario : usuarios) {
	                writer.write(usuario.getIdUsuario() + ","
	                        + usuario.getNombreUser() + ","
	                        + usuario.getPassword() + ","
	                        + usuario.getRol());
	                writer.newLine(); 
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
		
		public static void borrarUsuario(String archivo, String nombreUsuario) {
	        ArrayList<Usuario> listaUsuarios = LeerUsuario();

	        
	        for (int i = 0; i < listaUsuarios.size(); i++) {
	            if (listaUsuarios.get(i).getNombreUser().equalsIgnoreCase(nombreUsuario)) {
	                listaUsuarios.remove(i);
	                break;
	            }
	        }
	        
	        GuardarUsuarios(listaUsuarios);
	    }
		
		// medicos 
		
		public static void guardarMedicoEnArchivo(Medico medico) {
	        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH1, true)))) {
	            writer.println(medico.toString()); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
		 public static void leerMedico() {
		        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH1))) {
		            String linea;
		            while ((linea = reader.readLine()) != null) {
		                System.out.println(linea); 
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		 
		// Paciente 
		 
		 public static void guardarPacienteEnArchivo(Paciente paciente) {
		        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH2, true)))) {
		            writer.println(paciente.toString()); 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
			
			 public static void leerPaciente() {
			        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH2))) {
			            String linea;
			            while ((linea = reader.readLine()) != null) {
			                System.out.println(linea); 
			            }
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
			 
			 // Vacuna 
			 
			 public static void guardarVacunaEnArchivo(Vacuna vac) {
			        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH3, true)))) {
			            writer.println(vac.toString()); 
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
				
				 public static void leerVacuna() {
				        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH3))) {
				            String linea;
				            while ((linea = reader.readLine()) != null) {
				                System.out.println(linea); 
				            }
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				    }
				 
				 // enfermedad 
				 
				 public static void guardarEnfermedadEnArchivo(Enfermedad enfe) {
				        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH4, true)))) {
				            writer.println(enfe.toString()); 
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				    }
					
					 public static void leerEnfermedad() {
					        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH4))) {
					            String linea;
					            while ((linea = reader.readLine()) != null) {
					                System.out.println(linea); 
					            }
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
					    }
					 
					 // vivienda
					 
					 public static void guardarViviendaEnArchivo(Vivienda vivienda) {
					        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH5, true)))) {
					            writer.println(vivienda.toString()); 
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
					    }
						
						 public static void leerVivienda() {
						        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH5))) {
						            String linea;
						            while ((linea = reader.readLine()) != null) {
						                System.out.println(linea); 
						            }
						        } catch (IOException e) {
						            e.printStackTrace();
						        }
						    }
		 
						 // consultas 
						 
						 public static void guardarConsultasEnArchivo(Consultas consu) {
						        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH6, true)))) {
						            writer.println(consu.toString()); 
						        } catch (IOException e) {
						            e.printStackTrace();
						        }
						    }
							
							 public static void leerConsulta() {
							        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH6))) {
							            String linea;
							            while ((linea = reader.readLine()) != null) {
							                System.out.println(linea); 
							            }
							        } catch (IOException e) {
							            e.printStackTrace();
							        }
							    }
							 
							 // citas 
							 
							 public static void guardarCitasEnArchivo(Cita cita) {
							        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH7, true)))) {
							            writer.println(cita.toString()); 
							        } catch (IOException e) {
							            e.printStackTrace();
							        }
							    }
								
								 public static void leerCita() {
								        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH7))) {
								            String linea;
								            while ((linea = reader.readLine()) != null) {
								                System.out.println(linea); 
								            }
								        } catch (IOException e) {
								            e.printStackTrace();
								        }
								    }
								 
								 // historial 
								 
								 public static void guardarHistorialEnArchivo(HistoriaMedica HM) {
								        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH8, true)))) {
								            writer.println(HM.toString()); 
								        } catch (IOException e) {
								            e.printStackTrace();
								        }
								    }
									
									 public static void leerHisto() {
									        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH8))) {
									            String linea;
									            while ((linea = reader.readLine()) != null) {
									                System.out.println(linea); 
									            }
									        } catch (IOException e) {
									            e.printStackTrace();
									        }
									    }
								 
								 
}	
