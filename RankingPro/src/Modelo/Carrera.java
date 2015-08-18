package Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Carrera {

	private IntegerProperty idCarrera;
	private StringProperty carrera;

	public Carrera(int idCarrera, String carrera){
		this.idCarrera = new SimpleIntegerProperty(idCarrera);
		this.carrera = new SimpleStringProperty(carrera);
	}

	public int getIdCarrera(){
		return idCarrera.get();
	}

	public void setIdCarrera(int idCarrera){
		this.idCarrera = new SimpleIntegerProperty(idCarrera);
	}

	public String getCarrera(){
		return carrera.get();
	}

	public void setCarrera(String carrera){
		this.carrera = new SimpleStringProperty(carrera);
	}

	@Override
	public String toString() {
		return carrera.get();
	}

}
