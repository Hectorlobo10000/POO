package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.ObservableList;

public class Validaciones {


	public static String getValidar(String cuenta,
			String primerNombre,
			String SegundoNombre,
			String primerApellido,
			String segundoApellido,
			String edad,
			String correo,
			String telefono,
			String previamente,
			String puntos, ObservableList<Ranking> listaRanking) {
		String resultado = "";
		if(cuenta == null || cuenta.isEmpty()){
			resultado = resultado + "El campo CUENTA es obligatorio \n";
		}else{
			for(int validarCuenta = 0; validarCuenta < listaRanking.size(); validarCuenta++){
				if(cuenta == listaRanking.get(validarCuenta).getCuenta()){
					resultado = resultado + "El número de CUENTA ingresado ya existe";
				}
			}
		}

		if(primerNombre == null || primerNombre.isEmpty()){
			resultado = resultado + "El campo PRIMER NOMBRE es obligatorio \n";
		}

		if(SegundoNombre == null || SegundoNombre.isEmpty()){
			resultado = resultado + "El campo SEGUNDO NOMBRE es obligatorio \n";
		}

		if(primerApellido == null || primerApellido.isEmpty()){
			resultado = resultado + "El campo PRIMER APELLIDO es obligatorio \n";
		}

		if(segundoApellido == null || segundoApellido.isEmpty()){
			resultado = resultado + "El campo SEGUNDO APELLIDO es obligatorio \n";
		}

		if(edad == null || edad.isEmpty()){
			resultado = resultado + "El campo EDAD es obligatorio \n";
		}else{
			try{
				Integer.valueOf(edad);
			}catch (Exception e){
				resultado = resultado + "El campo EDAD no es correcto \n";
			}
		}

		if(correo == null || correo.isEmpty()){
			resultado = resultado + "El campo E-MAIL es obligatorio \n";
		}else
		{
			Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = pattern.matcher(correo);
			if(!matcher.matches()){
				resultado = resultado + "El campo E-MAIL no es correcto \n";
			}
		}

		if(telefono == null || telefono.isEmpty()){
			resultado = resultado + "El campo TELÉFONO es obligatorio \n";
		}else{
			Pattern pattern = Pattern.compile("^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$");
			Matcher matcher = pattern.matcher("+504" + telefono);
			if(!matcher.matches()){
				resultado = resultado + "El campo TELÉFONO no es correcto \n";
			}
		}

		if(previamente == null || previamente.isEmpty()){
			resultado = resultado + "El campo PREVIAMENTE es obligatorio \n";
		}else{
			try{
				Integer.valueOf(previamente);
			}catch (Exception e){
				resultado = resultado + "El campo PREVIAMENTE no es correcto \n";
			}
		}

		if(puntos == null || puntos.isEmpty()){
			resultado = resultado + "El campo PUNTOS es obligatorio \n";
		}else{
			try{
				Integer.valueOf(puntos);
			}catch (Exception e){
				resultado = resultado + "El campo PUNTOS no es correcto \n";
			}
		}

		return resultado;
	}
}
