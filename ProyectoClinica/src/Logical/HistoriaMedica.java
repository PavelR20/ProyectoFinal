package Logical;

import java.sql.Date;
import java.util.ArrayList;

public class HistoriaMedica {

	private ArrayList<Consultas> historialConsultas;
	private ResumenHistorial resumenPaciente;

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

	public ResumenHistorial generarResumen() {
		ResumenHistorial resumen = null;
		int i=0;
		for (Consultas consultas : historialConsultas) {
			resumen.setCodigo(historialConsultas.get(i).getIdConsulta());
			resumen.getMedicos().add(historialConsultas.get(i).getDoctor());
			resumen.getEnfermedades().addAll(historialConsultas.get(i).getSintomas());
			resumen.getFecha().add((Date) historialConsultas.get(i).getFechaConsulta());
			i++;
		}

		return resumen;

	}

	public ResumenHistorial getResumenPaciente() {
		return resumenPaciente;
	}

	public void setResumenPaciente(ResumenHistorial resumenPaciente) {
		this.resumenPaciente = resumenPaciente;
	}
}
