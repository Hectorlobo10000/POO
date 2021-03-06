package RankingPro;

import java.io.IOException;

import Modelo.Ranking;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Stage formularioPrincipal;
	private Stage formularioRanking;
	protected Stage formularioGestionarJugadores;
	private Stage formularioTorneo;

	private RankingProController rankingProController;
	private RankingController rankingController;
	private GestionarJugadoresController gestionarJugadoresController;
	private TorneoController torneoController;

	@Override
	public void start(Stage primaryStage) {
		formularioPrincipal = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("RankingPro.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			formularioPrincipal.setScene(scene);
			formularioPrincipal.setTitle("Ranking UNAH");
			formularioPrincipal.setResizable(false);
			rankingProController = loader.getController();
			rankingProController.setMain(this);
			formularioPrincipal.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		inicializarFormularioTorneo();
		inicialiazarFormularioRanking();
		inicialiazarFormularioGestionarJugadores();
	}

	public void inicialiazarFormularioGestionarJugadores() {
		if(formularioGestionarJugadores == null){
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("GestionarJugadores.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formularioGestionarJugadores = new Stage();
				//scene.getStylesheets().add(getClass().getResource("").toExternalForm());
				formularioGestionarJugadores.setScene(scene);
				formularioGestionarJugadores.setTitle("Ranking UNAH");
				formularioGestionarJugadores.setResizable(false);
				formularioGestionarJugadores.initModality(Modality.WINDOW_MODAL);
				formularioGestionarJugadores.initOwner(formularioPrincipal);
				gestionarJugadoresController = loader.getController();
				gestionarJugadoresController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void inicialiazarFormularioRanking() {
		if(formularioRanking == null){
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Ranking.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formularioRanking = new Stage();
				//scene.getStylesheets().add(getClass().getResource("").toExternalForm());
				formularioRanking.setScene(scene);
				formularioRanking.setTitle("Ranking UNAH");
				formularioRanking.setResizable(false);
				formularioRanking.initModality(Modality.WINDOW_MODAL);
				formularioRanking.initOwner(formularioPrincipal);
				rankingController = loader.getController();
				rankingController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void inicializarFormularioTorneo(){
		if(formularioTorneo ==  null){
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Torneo.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formularioTorneo = new Stage();
				//scene.getStylesheets().add(getClass().getResource("").toExternalForm());
				formularioTorneo.setScene(scene);
				formularioTorneo.setTitle("Torneo UNAH");
				formularioTorneo.setResizable(false);
				formularioTorneo.initModality(Modality.WINDOW_MODAL);
				formularioTorneo.initOwner(formularioPrincipal);
				torneoController = loader.getController();
				torneoController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void mostrarRanking() {
		formularioRanking.show();
	}

	public void mostrarGestionarJugadores() {
		formularioGestionarJugadores.show();
	}

	public void mostrarTorneo(){
		formularioTorneo.show();
	}

	public void enlazarRanking(ObservableList<Ranking> olRanking){
		rankingController.setEnlazarRanking(olRanking);
		rankingProController.setEnlazarRanking(olRanking);
		torneoController.setEnlazarRanking(olRanking);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
