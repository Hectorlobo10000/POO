package Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sexo {
	private IntegerProperty idSexo;
	private StringProperty sexo;

	public Sexo(int idSexo, String sexo){
		this.idSexo = new SimpleIntegerProperty(idSexo);
		this.sexo = new SimpleStringProperty(sexo);
	}

	public int getIdSexo(){
		return idSexo.get();
	}

	public void setIdSexo(int idSexo){
		this.idSexo = new SimpleIntegerProperty(idSexo);
	}

	public String getSexo(){
		return sexo.get();
	}

	public void setSexo(String sexo){
		this.sexo = new SimpleStringProperty(sexo);
	}

	@Override
	public String toString() {
		return sexo.get();
	}


}
