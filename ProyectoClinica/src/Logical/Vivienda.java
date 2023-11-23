package Logical;

public class Vivienda {
	
	private String idVivienda;
	private String Direccion; 
	private String telefono;
	
	public Vivienda(String idVivienda, String direccion, String telefono) {
		super();
		this.idVivienda = idVivienda;
		Direccion = direccion;
		this.telefono = telefono;
	}

	public String getIdVivienda() {
		return idVivienda;
	}

	public void setIdVivienda(String idVivienda) {
		this.idVivienda = idVivienda;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
