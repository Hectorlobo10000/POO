package RankingPro;

import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Conexion;
import Modelo.Ranking;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;

public class TorneoController implements Initializable{

	@FXML private TableView<Ranking> tblRanking;
	@FXML private TableColumn<Ranking, String> clmCuenta;
	@FXML private TableColumn<Ranking, String> clmJugador;

	@FXML private TextField txtCuenta;
	@FXML private TextField txtJugador;
	@FXML private ComboBox<String> cboResultado;
	@FXML private Button btnActualizar;

	private ObservableList<Ranking> listaRanking;
	private ObservableList<String> listaResultados;
	private Conexion conexion;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion = new Conexion();
		listaResultados = FXCollections.observableArrayList();
		listaResultados.add("Ganó");
		listaResultados.add("Perdió");
		cboResultado.setItems(listaResultados);
		enlazarTblRaking();

		tblRanking.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ranking>(){

			@Override
			public void changed(ObservableValue<? extends Ranking> Obseraveble, Ranking oldValue, Ranking newValue) {
				if(newValue != null){
					llenarcomponentes(newValue);
				}
			}

		});
	}

	@FXML public void actualizar(){
		if(cboResultado.getSelectionModel().getSelectedIndex() == 0){
			valor = 100;
		}else{
			valor = 50;
		}
		conexion.Conectar();
		int resultado = Ranking.actualizarPuntos(conexion, txtCuenta.getText(), valor);
		conexion.Cerrar();
		if(resultado == 1){
			listaRanking.clear();
			conexion.Conectar();
			conexion.llenarListaRanking(listaRanking);
			conexion.Cerrar();
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Sistema de Ranking");
			alerta.setContentText("Registro modificado");
			alerta.initModality(Modality.WINDOW_MODAL);
			alerta.initOwner(main.formularioGestionarJugadores);
			alerta.showAndWait();
		}else{
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Sistema de Ranking");
			alerta.setContentText("No se pudo modificar el registro");
			alerta.initModality(Modality.WINDOW_MODAL);
			alerta.initOwner(main.formularioGestionarJugadores);
			alerta.showAndWait();
		}
	}

	private void llenarcomponentes(Ranking newValue) {
		txtCuenta.setText(newValue.getCuenta());
		txtJugador.setText(newValue.getJugador());
	}

	private void enlazarTblRaking() {
		clmCuenta.setCellValueFactory(new PropertyValueFactory<Ranking, String>("cuenta"));
		clmJugador.setCellValueFactory(new PropertyValueFactory<Ranking, String>("jugador"));
	}

	//Enlazar listas
	private Main main;
	private int valor;

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
