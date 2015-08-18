package Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Origen {

	private IntegerProperty idOrigen;
	private StringProperty origen;

	public Origen(int idOrigen, String origen){
		this.idOrigen = new SimpleIntegerProperty(idOrigen);
		this.origen = new SimpleStringProperty(origen);
	}

	public int getIdOrigen(){
		return idOrigen.get();
	}

	public void setIdSOrigen(int idOrigen){
		this.idOrigen = new SimpleIntegerProperty(idOrigen);
	}

	public String getOrigen(){
		return origen.get();
	}

	public void setOrigen(String origen){
		this.origen = new SimpleStringProperty(origen);
	}

	@Override
	public String toString() {
		return origen.get();
	}
}
