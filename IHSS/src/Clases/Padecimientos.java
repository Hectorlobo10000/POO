package Clases;

public class Padecimientos {
	private String nombre;
	private String descripcion;
	private int diasPadecimientos;
	
	public Padecimientos(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDiasPadecimientos() {
		return diasPadecimientos;
	}

	public void setDiasPadecimientos(int diasPadecimientos) {
		this.diasPadecimientos = diasPadecimientos;
	}

	@Override
	public String toString() {
		return "\n Padecimientos [nombre=" + nombre + ", descripcion="
				+ descripcion + ", diasPadecimientos=" + diasPadecimientos
				+ "]";
	}
	
	
}
