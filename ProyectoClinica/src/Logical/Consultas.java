package Logical;

import java.util.Date;
import java.util.List;

public class Consultas {
    
    private String idConsulta;
    private Date fechaConsulta;
    private List<Enfermedad> sintomas;
    private Medico doctor;
    private Paciente patient;
    
    public Consultas(String idConsulta, Date fechaConsulta, List<Enfermedad> sintomas, Medico doctor, Paciente patient) {
        super();
        this.idConsulta = idConsulta;
        this.fechaConsulta = fechaConsulta;
        this.sintomas = sintomas;
        this.doctor = doctor;
        this.patient = patient;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public List<Enfermedad> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Enfermedad> sintomas) {
        this.sintomas = sintomas;
    }

    public Paciente getPatient() {
        return patient;
    }

    public void setPatient(Paciente patient) {
        this.patient = patient;
    }

    public Medico getDoctor() {
        return doctor;
    }

    public void setDoctor(Medico doctor) {
        this.doctor = doctor;
    }
}