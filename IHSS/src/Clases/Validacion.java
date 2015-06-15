package Clases;

import java.util.ArrayList;

public class Validacion {
	private String errores;
	public Validacion(){
		
	}
	
	public String getComprobarValidacion(Cita cita, Paciente paciente, ArrayList<Padecimientos> padecimientos, Enfermera enfermera, Medico medico, ArrayList<Receta> medicamentos){
		errores = "";
		if(cita.getFecha().isEmpty())
			errores += "El campo fecha esta vacio.\n";
		
		if(cita.getHora().isEmpty())
			errores += "El campo hora esta vacio.\n";
		
		if(paciente.getNombre().isEmpty())
			errores += "El campo nombre de paciente esta vacio.\n";
		
		if(paciente.getIdentidad().isEmpty())
			errores += "El campo identidad esta vacio.\n";
		
		if(paciente.getEdad() == 0)
			errores += "El campo edad esta vacio.\n";
		
		for(int indice = 0; indice < padecimientos.size(); indice++){
			
			if(padecimientos.get(indice).getNombre().isEmpty())
				errores += "El campo nombre de padecimientos esta vacio.\n";
			
			if(padecimientos.get(indice).getDescripcion().isEmpty())
				errores += "El campo descripcion de padecimientos esta vacio.\n";
			
			if(padecimientos.get(indice).getDiasPadecimientos() == 0)
				errores += "El campo dias con el padecimientos esta vacio.\n";
			
		}
		
		if(enfermera.getCodidoColegacion().isEmpty())
			errores += "El campo codigo colegacion de enfermera esta vacio.\n";
		
		if(enfermera.getRegistroExamenes().isEmpty())
			errores += "El campo registro de examenes de enfermera esta vacio.\n";
		
		if(medico.getEspecialidad().isEmpty())
			errores += "El campo especialidad de medico esta vacio.\n";
		
		if(medico.getConsultorio().isEmpty())
			errores += "El campo consultorio de medico esta vacio.\n";
		
		for(int indice = 0; indice < medicamentos.size(); indice ++){
			
			if(medicamentos.get(indice).getNombre().isEmpty())
				errores += "El campo nombre de medicamentos esta vacio.\n";
			
			if(medicamentos.get(indice).getPresentacion().isEmpty())
				errores += "El campo presentacion de medicamentos esta vacio.\n";
			
			if(medicamentos.get(indice).getFecha().isEmpty())
				errores += "El campo fecha de vencimiento de medicamentos esta vacio.\n";
			
		}
		
		return errores;
	}
	
	public int getValidarNumeroInt(String numero){
		int numeroValido = 0;
		
		try{
			numeroValido = Integer.parseInt(numero);
		}catch(Exception e){
			numeroValido = 0;
		}
		
		return numeroValido;
	}
	
}
