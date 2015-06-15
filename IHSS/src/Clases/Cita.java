package Clases;

import java.util.ArrayList;

public class Cita {
	private String fecha;
	private String hora;
	private Paciente paciente;
	private Enfermera enfermera;
	private Medico medico;
	private ArrayList<Receta> medicamentos;
	
	public Cita(){
		
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Enfermera getEnfermera() {
		return enfermera;
	}

	public void setEnfermera(Enfermera enfermera) {
		this.enfermera = enfermera;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public ArrayList<Receta> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(ArrayList<Receta> medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Override
	public String toString() {
		return "Cita [fecha=" + fecha + ", hora=" + hora + ", paciente="
				+ paciente.toString() + ", enfermera=" + enfermera.toString() + ", medico=" + medico.toString()
				+ "]";
	}
	
	
}
