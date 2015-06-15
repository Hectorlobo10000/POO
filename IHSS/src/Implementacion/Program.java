package Implementacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clases.Cita;
import Clases.Enfermera;
import Clases.Medico;
import Clases.Paciente;
import Clases.Padecimientos;
import Clases.Receta;
import Clases.Validacion;

public class Program {

	public static void main(String[] args) {
		ArrayList<Cita> citas = new ArrayList<Cita>();
		
		int opcion = 3;
		do{
			
			String menu = JOptionPane.showInputDialog("1. Agregar Cita\n" + "2. Mostrar informacion\n" + "3. Salir");
			opcion = Integer.parseInt(menu.isEmpty()?"3":menu);
			
			switch(opcion){
			case 1:
				
				Cita objetoCita = new Cita();
				Paciente objetoPaciente = new Paciente();
				ArrayList<Padecimientos> padecimientos = new ArrayList<Padecimientos>();
				Padecimientos objetoPadecimientos = new Padecimientos();
				Enfermera objetoEnfermera = new Enfermera();
				Medico objetoMedico = new Medico();
				ArrayList<Receta> medicamentos = new ArrayList<Receta>();
				Receta objetoReceta = new Receta();
				Validacion objetoValidacion = new Validacion();
				
				int numeroPadecimientos = 0;
				int numeroMedicamentos = 0;
				String errores = "";
				do{
					
					objetoCita.setFecha(JOptionPane.showInputDialog("Fecha de cita", objetoCita.getFecha()));
					objetoCita.setHora(JOptionPane.showInputDialog("Hora de la cita", objetoCita.getHora()));
					
					objetoPaciente.setNombre(JOptionPane.showInputDialog("Nombre del paciente", objetoPaciente.getNombre()));
					objetoPaciente.setIdentidad(JOptionPane.showInputDialog("Identidad del paciente", objetoPaciente.getIdentidad()));
					objetoPaciente.setEdad(objetoValidacion.getValidarNumeroInt(JOptionPane.showInputDialog("Edad del paciente", objetoPaciente.getEdad())));
					
					if(errores.isEmpty()){
						String sintomas = JOptionPane.showInputDialog("Numero de padecimientos");
						numeroPadecimientos = objetoValidacion.getValidarNumeroInt(sintomas.isEmpty()?"1":sintomas);
					}
					
					for(int numeroPeticion = 0; numeroPeticion < numeroPadecimientos; numeroPeticion++){
						objetoPadecimientos.setNombre(JOptionPane.showInputDialog("Nombre del padecimiento", objetoPadecimientos.getNombre()));
						objetoPadecimientos.setDescripcion(JOptionPane.showInputDialog("Descripcion del padecimiento", objetoPadecimientos.getDescripcion()));
						objetoPadecimientos.setDiasPadecimientos(objetoValidacion.getValidarNumeroInt(JOptionPane.showInputDialog("Dias con el padecimiento", objetoPadecimientos.getDiasPadecimientos())));
						padecimientos.add(objetoPadecimientos);
					}
					objetoPaciente.setPadecimientos(padecimientos);
					
					objetoEnfermera.setCodidoColegacion(JOptionPane.showInputDialog("Codigo de colegación de la enfermera", objetoEnfermera.getCodidoColegacion()));
					objetoEnfermera.setRegistroExamenes(JOptionPane.showInputDialog("Examenes que puede realizar", objetoEnfermera.getRegistroExamenes()));
					
					objetoMedico.setEspecialidad(JOptionPane.showInputDialog("Especialidad del doctor", objetoMedico.getEspecialidad()));
					objetoMedico.setConsultorio(JOptionPane.showInputDialog("Consultorio del doctor", objetoMedico.getConsultorio()));
					
					if(errores.isEmpty()){
						String nMedicamentos = JOptionPane.showInputDialog("Numero de medicamentos recetados");
						numeroMedicamentos = objetoValidacion.getValidarNumeroInt(nMedicamentos.isEmpty()?"1":nMedicamentos);
					}
					
					for(int numeroPeticion = 0; numeroPeticion < numeroMedicamentos; numeroPeticion++){
						objetoReceta.setNombre(JOptionPane.showInputDialog("Nombre del medicamento", objetoReceta.getNombre()));
						objetoReceta.setPresentacion(JOptionPane.showInputDialog("Presentacion del medicamento", objetoReceta.getPresentacion()));
						objetoReceta.setFecha(JOptionPane.showInputDialog("Fecha de vencimiento del medicamento", objetoReceta.getFecha()));
						medicamentos.add(objetoReceta);
					}
					
					errores = objetoValidacion.getComprobarValidacion(objetoCita, objetoPaciente, padecimientos, objetoEnfermera, objetoMedico, medicamentos);
					if(!errores.isEmpty()){
						JOptionPane.showMessageDialog(null, errores);
					}
					
				}while(!errores.isEmpty());
				objetoCita.setPaciente(objetoPaciente);
				objetoCita.setEnfermera(objetoEnfermera);
				objetoCita.setMedico(objetoMedico);
				objetoCita.setMedicamentos(medicamentos);
				citas.add(objetoCita);
				//System.out.print(citas.get(0));
				//System.out.print(citas.get(0).getPaciente().getPadecimientos().get(0));
				break;
			case 2:
				for(int indice0 = 0; indice0 < citas.size(); indice0++){
					System.out.println(citas.get(indice0));
					for(int indice1 = 0; indice1 < citas.get(indice0).getPaciente().getPadecimientos().size(); indice1++){
						System.out.println(citas.get(indice0).getPaciente().getPadecimientos().get(indice1));
					}
					for(int indice2 = 0; indice2 < citas.get(indice0).getMedicamentos().size(); indice2++){
						System.out.println(citas.get(indice0).getMedicamentos().get(indice2));
					}
				}
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Adios!");
				break;
			default:
					break;
			}
			
		}while(opcion != 3);
		
	}

}
