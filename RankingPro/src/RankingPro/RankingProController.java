package RankingPro;

import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Ranking;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RankingProController  implements Initializable{

	@FXML private MenuItem mnuTorneo;
	@FXML private MenuItem mnuRanking;
	@FXML private MenuItem mnuSalir;
	@FXML private MenuItem mnuGestinarAtletas;

	@FXML private TableView<Ranking> tblRanking;
	@FXML private TableColumn<Ranking, Number> clmPosicion;
	@FXML private TableColumn<Ranking, Number> clmPreviamente;
	@FXML private TableColumn<Ranking, String> clmJugador;
	@FXML private TableColumn<Ranking, String> clmCarrera;
	@FXML private TableColumn<Ranking, Number> clmPuntos;


	private ObservableList<Ranking> listaRanking;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		enlazarTblRanking();
	}

	private void enlazarTblRanking() {
		clmPosicion.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("posicion"));
		clmPreviamente.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("previamente"));
		clmJugador.setCellValueFactory(new PropertyValueFactory<Ranking, String>("jugador"));
		clmCarrera.setCellValueFactory(new PropertyValueFactory<Ranking, String>("carrera"));
		clmPuntos.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("puntos"));
	}

	@FXML public void abrirRanking(){
		main.mostrarRanking();
	}

	@FXML public void abrirGestionarAtletas(){
		main.mostrarGestionarJugadores();
	}

	@FXML public void abrirTorneo(){
		main.mostrarTorneo();
	}

	@FXML public void salir(){
		System.exit(0);
	}

	//Enlazar listaRanking
	private Main main;

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public ObservableList<Ranking> getListaRanking(){
		return listaRanking;
	}

	public void setEnlazarRanking(ObservableList<Ranking> olRanking) {
		this.listaRanking = olRanking;
		tblRanking.setItems(listaRanking);
	}
}
