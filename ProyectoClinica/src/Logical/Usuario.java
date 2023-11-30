package Logical;

public class Usuario {

	private String idUsuario;
	private String nombreUser;
	private String password;
	private String Rol;
	
	public Usuario(String idUsuario, String nombreUser, String password, String rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUser = nombreUser;
		this.password = password;
		this.Rol = rol;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public String getNombreUser() {
		return nombreUser;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRol() {
		return Rol;
	}
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRol(String rol) {
		Rol = rol;
	}
	
	
	
}
