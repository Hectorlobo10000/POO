package Clases;

public class Enfermera {
	private String codidoColegacion;
	private String registroExamenes;
	
	public Enfermera(){
		
	}

	public String getCodidoColegacion() {
		return codidoColegacion;
	}

	public void setCodidoColegacion(String codidoColegacion) {
		this.codidoColegacion = codidoColegacion;
	}

	public String getRegistroExamenes() {
		return registroExamenes;
	}

	public void setRegistroExamenes(String registroExamenes) {
		this.registroExamenes = registroExamenes;
	}

	@Override
	public String toString() {
		return "Enfermera [codidoColegacion=" + codidoColegacion
				+ ", registroExamenes=" + registroExamenes + "]";
	}
	
	
}
