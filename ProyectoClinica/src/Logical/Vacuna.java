package Logical;


public class Vacuna {

	private String idVacuna;
	private String nombreVacuna;
	private Paciente idPaciente;
	
	public Vacuna(String idVacuna, String nombreVacuna, Paciente idPaciente) {
		super();
		this.idVacuna = idVacuna;
		this.nombreVacuna = nombreVacuna;
		this.idPaciente = idPaciente;
	}
	
	public String toString() {
		
        return idVacuna + "," + nombreVacuna + ",";
    }

	public String getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(String idVacuna) {
		this.idVacuna = idVacuna;
	}

	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	public Paciente getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Paciente idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	

	
	
}
