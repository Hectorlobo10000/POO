package Clases;

public class Medico {
	private String especialidad;
	private String Consultorio;
	
	public Medico(){
		
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getConsultorio() {
		return Consultorio;
	}

	public void setConsultorio(String consultorio) {
		Consultorio = consultorio;
	}

	@Override
	public String toString() {
		return "Medico [especialidad=" + especialidad + ", Consultorio="
				+ Consultorio + "]";
	}
	
	
}
