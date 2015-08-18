package RankingPro;

import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Conexion;
import Modelo.Ranking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class GestionarJugadoresController implements Initializable{

	private ObservableList<Ranking> listaRanking;

	private Conexion conexion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conexion = new Conexion();
		listaRanking = FXCollections.observableArrayList();
		llenarListas();
	}


	public void llenarListas() {
		conexion.Conectar();
		conexion.llenarListaRanking(listaRanking);
		conexion.Cerrar();
	}


	//Enlazar lista
	private Main main;

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
		main.enlazarRanking(listaRanking);
	}

	/*public ObservableList<Ranking> getListaRanking(){
		return listaRanking;
	}

	public void setEnlazarRanking(ObservableList<Ranking> olRanking) {
		this.listaRanking = olRanking;
	}*/

}
