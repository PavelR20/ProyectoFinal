package Logical;

import java.util.ArrayList;

public class HistoriaMedica {
	
	private ArrayList<Consultas> historialConsultas;

	public HistoriaMedica(ArrayList<Consultas> historialConsultas) {
		super();
		historialConsultas = new ArrayList<Consultas>();
	}

	public ArrayList<Consultas> getHistorialConsultas() {
		return historialConsultas;
	}

	public void setHistorialConsultas(ArrayList<Consultas> historialConsultas) {
		this.historialConsultas = historialConsultas;
	}
	
	public void agregarConsulta(Consultas consult) {
		historialConsultas.add(consult);
	}
	
}
