package Logical;

public class HistoriaMedica {
	
	private String idHistoriaMedico;
	private Paciente idpaciente;
	private Vacuna historialVacunasXpaciente;
	private Enfermedad historialEnfemerdad;
	
	public HistoriaMedica(String idHistoriaMedico, Paciente idpaciente, Vacuna historialVacunasXpaciente,
			Enfermedad historialEnfemerdad) {
		super();
		this.idHistoriaMedico = idHistoriaMedico;
		this.idpaciente = idpaciente;
		this.historialVacunasXpaciente = historialVacunasXpaciente;
		this.historialEnfemerdad = historialEnfemerdad;
	}

	public String getIdHistoriaMedico() {
		return idHistoriaMedico;
	}

	public void setIdHistoriaMedico(String idHistoriaMedico) {
		this.idHistoriaMedico = idHistoriaMedico;
	}

	public Paciente getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(Paciente idpaciente) {
		this.idpaciente = idpaciente;
	}

	public Vacuna getHistorialVacunasXpaciente() {
		return historialVacunasXpaciente;
	}

	public void setHistorialVacunasXpaciente(Vacuna historialVacunasXpaciente) {
		this.historialVacunasXpaciente = historialVacunasXpaciente;
	}

	public Enfermedad getHistorialEnfemerdad() {
		return historialEnfemerdad;
	}

	public void setHistorialEnfemerdad(Enfermedad historialEnfemerdad) {
		this.historialEnfemerdad = historialEnfemerdad;
	}
	
	

}
