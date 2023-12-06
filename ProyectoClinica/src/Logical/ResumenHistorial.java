package Logical;

import java.sql.Date;
import java.util.ArrayList;

public class ResumenHistorial {
	private String codigo;
	private ArrayList<Medico> medicos;
	private ArrayList<Enfermedad> enfermedades;
	private ArrayList<Date> fecha;
	public ResumenHistorial(String codigo, ArrayList<Medico> medicos, ArrayList<Enfermedad> enfermedades,
			ArrayList<Vacuna> vacunas, ArrayList<Date> fecha) {
		super();
		this.codigo = codigo;
		medicos = new ArrayList<Medico>();
		enfermedades = new ArrayList<Enfermedad>();
		fecha = new ArrayList<Date>();
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public ArrayList<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}
	public ArrayList<Enfermedad> getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}
	public ArrayList<Date> getFecha() {
		return fecha;
	}
	public void setFecha(ArrayList<Date> fecha) {
		this.fecha = fecha;
	}
}
