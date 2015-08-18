package Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ranking {
	private StringProperty cuenta;
	private StringProperty primerNombre;
	private StringProperty segundoNombre;
	private StringProperty primerApellido;
	private StringProperty segundoApellido;
	private Sexo sexo;
	private Origen origen;
	private Carrera carrera;
	private IntegerProperty edad;
	private StringProperty email;
	private StringProperty telefono;
	private IntegerProperty posicion;
	private IntegerProperty previamente;
	private IntegerProperty puntos;
	private StringProperty foto;
	private StringProperty jugador;

	public Ranking(String cuenta, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, Sexo sexo, Origen origen, Carrera carrera,
			int edad, String email, String telefono, int posicion,
			int previamente, int puntos, String foto) {
		this.cuenta = new SimpleStringProperty(cuenta);
		this.primerNombre = new SimpleStringProperty(primerNombre);
		this.segundoNombre = new SimpleStringProperty(segundoNombre);
		this.primerApellido = new SimpleStringProperty(primerApellido);
		this.segundoApellido = new SimpleStringProperty(segundoApellido);
		this.sexo = sexo;
		this.origen = origen;
		this.carrera = carrera;
		this.edad = new SimpleIntegerProperty(edad);
		this.email = new SimpleStringProperty(email);
		this.telefono = new SimpleStringProperty(telefono);
		this.posicion = new SimpleIntegerProperty(posicion);
		this.previamente = new SimpleIntegerProperty(previamente);
		this.puntos = new SimpleIntegerProperty(puntos);
		this.foto = new SimpleStringProperty(foto);
		this.jugador = new SimpleStringProperty(primerApellido + " " + primerNombre);
	}

	public String getCuenta() {
		return cuenta.get();
	}

	public void setCuenta(String cuenta) {
		this.cuenta = new SimpleStringProperty(cuenta);
	}

	public String getPrimerNombre() {
		return primerNombre.get();
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = new SimpleStringProperty(primerNombre);
	}

	public String getSegundoNombre() {
		return segundoNombre.get();
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = new SimpleStringProperty(segundoNombre);
	}

	public String getPrimerApellido() {
		return primerApellido.get();
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = new SimpleStringProperty(primerApellido);
	}

	public String getSegundoApellido() {
		return segundoApellido.get();
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = new SimpleStringProperty(segundoApellido);
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public int getEdad() {
		return edad.get();
	}

	public void setEdad(int edad) {
		this.edad = new SimpleIntegerProperty(edad);
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email = new SimpleStringProperty(email);
	}

	public String getTelefono() {
		return telefono.get();
	}

	public void setTelefono(String telefono) {
		this.telefono = new SimpleStringProperty(telefono);
	}

	public int getPosicion() {
		return posicion.get();
	}

	public void setPosicion(int posicion) {
		this.posicion = new SimpleIntegerProperty(posicion);
	}

	public int getPreviamente() {
		return previamente.get();
	}

	public void setPreviamente(int previamente) {
		this.previamente = new SimpleIntegerProperty(previamente);
	}

	public int getPuntos() {
		return puntos.get();
	}

	public void setPuntos(int puntos) {
		this.puntos = new SimpleIntegerProperty(puntos);
	}

	public String getFoto() {
		return foto.get();
	}

	public void setFoto(String foto) {
		this.foto = new SimpleStringProperty(foto);
	}

	public String getJugador(){
		return jugador.get();
	}

	public void setJugador(String primerApellido, String primerNombre){
		this.jugador = new SimpleStringProperty(primerApellido + " " + primerNombre);
	}

	@Override
	public String toString() {
		return cuenta.get();
	}


}
