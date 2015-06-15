package Clases;

public class Receta {
	private String nombre;
	private String presentacion;
	private String fecha;
	
	public Receta(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "\n Receta [nombre=" + nombre + ", presentacion=" + presentacion
				+ ", fecha=" + fecha + "]";
	}
	
	
}
