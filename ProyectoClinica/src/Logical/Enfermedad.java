package Logical;

public class Enfermedad {
	
	private String idEnfermedad;
	private String nombreEnfermedad;
	private String descripcion;
	private String sintomas;
	private Vacuna vacunaDispo;
	private boolean enfermedadVigilancia = true; 
	private boolean enfermedadIsSelected = false;
	
	public Enfermedad(String idEnfermedad, String nombreEnfermedad, String descripcion, String sintomas,
			Vacuna vacunaDispo,boolean enfermedadVigilancia) {
		super();
		this.idEnfermedad = idEnfermedad;
		this.nombreEnfermedad = nombreEnfermedad;
		this.descripcion = descripcion;
		this.sintomas = sintomas;
		this.vacunaDispo = vacunaDispo;
		this.setEnfermedadVigilancia(enfermedadVigilancia);
	}
	
	public String toString() {
        return idEnfermedad + "," + nombreEnfermedad + "," + descripcion + "," + sintomas + "," + vacunaDispo;
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

	public boolean isEnfermedadVigilancia() {
		return enfermedadVigilancia;
	}

	public void setEnfermedadVigilancia(boolean enfermedadVigilancia) {
		this.enfermedadVigilancia = enfermedadVigilancia;
	}

	public boolean isEnfermedadIsSelected() {
		return enfermedadIsSelected;
	}

	public void setEnfermedadIsSelected(boolean enfermedadIsSelected) {
		this.enfermedadIsSelected = enfermedadIsSelected;
	}
	
	
	

}
