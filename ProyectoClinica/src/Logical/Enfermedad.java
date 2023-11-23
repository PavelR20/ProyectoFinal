package Logical;

public class Enfermedad {
	
	private String idEnfermedad;
	private String nombreEnfermedad;
	private String descripcion;
	private String sintomas;
	private Vacuna vacunaDispo;
	
	public Enfermedad(String idEnfermedad, String nombreEnfermedad, String descripcion, String sintomas,
			Vacuna vacunaDispo) {
		super();
		this.idEnfermedad = idEnfermedad;
		this.nombreEnfermedad = nombreEnfermedad;
		this.descripcion = descripcion;
		this.sintomas = sintomas;
		this.vacunaDispo = vacunaDispo;
	}

	public String getIdEnfermedad() {
		return idEnfermedad;
	}

	public void setIdEnfermedad(String idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public Vacuna getVacunaDispo() {
		return vacunaDispo;
	}

	public void setVacunaDispo(Vacuna vacunaDispo) {
		this.vacunaDispo = vacunaDispo;
	}
	
	
	

}
