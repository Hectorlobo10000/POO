package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;

public class Conexion {
	private Connection conexion;
	private String url = "jdbc:mysql://localhost/db_ranking";
	private String usuario = "root";
	private String  pass = "";

	public Conexion(){

	}

	public Connection getConexion(){
		return conexion;
	}

	public void Conectar(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Cerrar(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void llenarListaSexo(ObservableList<Sexo> listaSexo) {
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery("SELECT id_sexo, sexo FROM tbl_sexo");
			while(resultado.next()){
				listaSexo.add(new Sexo(resultado.getInt("id_sexo"), resultado.getString("sexo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void llenarListaCarrera(ObservableList<Carrera> listaCarrera) {
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery("SELECT id_carrera, carrera FROM tbl_carrera");
			while(resultado.next()){
				listaCarrera.add(new Carrera(resultado.getInt("id_carrera"), resultado.getString("carrera")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void llenarListaOrigen(ObservableList<Origen> listaOrigen) {
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery("SELECT id_origen, origen FROM tbl_origen");
			while(resultado.next()){
				listaOrigen.add(new Origen(resultado.getInt("id_origen"), resultado.getString("origen")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void llenarListaRanking(ObservableList<Ranking> listaRanking) {
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery("SELECT "
					+ "A.cuenta, "
					+ "A.primer_nombre, "
					+ "A.segundo_nombre, "
					+ "A.primer_apellido, "
					+ "A.segundo_apellido, "
					+ "A.id_sexo, "
					+ "B.sexo, "
					+ "A.id_origen, "
					+ "C.origen, "
					+ "A.id_carrera, "
					+ "D.carrera, "
					+ "A.edad, "
					+ "A.email, "
					+ "A.telefono, "
					+ "A.id, "
					+ "A.previamente, "
					+ "A.puntos, "
					+ "A.foto "
					+ "FROM tbl_ranking A "
					+ "INNER JOIN tbl_sexo B "
					+ "ON (A.id_sexo = B.id_sexo) "
					+ "INNER JOIN tbl_origen C "
					+ "ON (A.id_origen = C.id_origen) "
					+ "INNER JOIN tbl_carrera D "
					+ "ON (A.id_carrera = D.id_carrera) "
					+ "ORDER BY A.puntos DESC");
			while(resultado.next()){
				Ranking ranking = new Ranking(
				resultado.getString("cuenta"),
				resultado.getString("primer_nombre"),
				resultado.getString("segundo_nombre"),
				resultado.getString("primer_apellido"),
				resultado.getString("segundo_apellido"),
				new Sexo(resultado.getInt("id_sexo"), resultado.getString("sexo")),
				new Origen(resultado.getInt("id_origen"), resultado.getString("origen")),
				new Carrera(resultado.getInt("id_carrera"), resultado.getString("carrera")),
				resultado.getInt("edad"),
				resultado.getString("email"),
				resultado.getString("telefono"),
				resultado.getRow()/*resultado.getInt("posicion")*/,
				resultado.getInt("previamente"),
				resultado.getInt("puntos"),
				resultado.getString("foto"));
				listaRanking.add(ranking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
