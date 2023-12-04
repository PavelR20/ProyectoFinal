package Logical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class archivoManager {
	
	private static final String FILE_PATH = "usuarios.txt";	
	private static final String FILE_PATH1 = "Medico.txt";
	
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
}
