package Clases;

import java.util.ArrayList;

public class Paciente {
	private String nombre;
	private String identidad;
	private int edad;
	private ArrayList<Padecimientos> padecimientos;
	
	public Paciente(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentidad() {
		return identidad;
	}

	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Padecimientos> getPadecimientos() {
		return padecimientos;
	}

	public void setPadecimientos(ArrayList<Padecimientos> padecimientos) {
		this.padecimientos = padecimientos;
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", identidad=" + identidad
				+ ", edad=" + edad + "]";
	}
	
	
}
