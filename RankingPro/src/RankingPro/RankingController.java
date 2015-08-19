package RankingPro;

import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Carrera;
import Modelo.Conexion;
import Modelo.Origen;
import Modelo.Ranking;
import Modelo.Sexo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class RankingController implements Initializable{

	@FXML private TableView<Ranking> tblRanking;
	@FXML private TableColumn<Ranking, Number> clmPosicion;
	@FXML private TableColumn<Ranking, Number> clmPreviamente;
	@FXML private TableColumn<Ranking, String> clmJugador;
	@FXML private TableColumn<Ranking, String> clmCarrera;
	@FXML private TableColumn<Ranking, Number> clmPuntos;

	@FXML private ImageView imgFoto;
	@FXML private TextField txtCuenta;
	@FXML private TextField txtPrimerNombre;
	@FXML private TextField txtSegundoNombre;
	@FXML private TextField txtPrimerApellido;
	@FXML private TextField txtSegundoApellido;
	@FXML private TextField txtSexo;
	@FXML private TextField txtOrigen;
	@FXML private TextField txtCarrera;
	/*@FXML private ComboBox<Sexo> cboSexo;
	@FXML private ComboBox<Origen> cboOrigen;
	@FXML private ComboBox<Carrera> cboCarrera;*/
	@FXML private TextField txtEdad;
	@FXML private TextField txtCorreo;
	@FXML private TextField txtTelefono;
	@FXML private TextField txtPosicion;
	@FXML private TextField txtPreviamente;
	@FXML private TextField txtPuntos;

	private ObservableList<Ranking> listaRanking;
	private ObservableList<Sexo> listaSexo;
	private ObservableList<Origen> listaOrigen;
	private ObservableList<Carrera> listaCarrera;

	private Conexion conexion;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion = new Conexion();
		listaSexo = FXCollections.observableArrayList();
		listaOrigen = FXCollections.observableArrayList();
		listaCarrera = FXCollections.observableArrayList();
		llenarListas();
		/*cboSexo.setItems(listaSexo);
		cboCarrera.setItems(listaCarrera);
		cboOrigen.setItems(listaOrigen);*/

		tblRanking.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ranking>(){
			{
		}

			@Override
			public void changed(ObservableValue<? extends Ranking> observable, Ranking oldValue, Ranking newValue) {
				llenarComponentes(newValue);
			}
		});
	}

	private void llenarComponentes(Ranking newValue) {
		Image image = new Image("file:" + newValue.getFoto());
		imgFoto.setImage(image);
		txtCuenta.setText(newValue.getCuenta());
		txtPrimerNombre.setText(newValue.getPrimerNombre());
		txtSegundoNombre.setText(newValue.getSegundoNombre());
		txtPrimerApellido.setText(newValue.getPrimerApellido());
		txtSegundoApellido.setText(newValue.getSegundoApellido());
		txtSexo.setText(newValue.getSexo().toString());
		txtOrigen.setText(newValue.getOrigen().toString());
		txtCarrera.setText(newValue.getCarrera().toString());
		/*cboSexo.getSelectionModel().select(newValue.getSexo());
		cboOrigen.getSelectionModel().select(newValue.getOrigen());
		cboCarrera.getSelectionModel().select(newValue.getCarrera());*/
		txtEdad.setText(String.valueOf(newValue.getEdad()));
		txtCorreo.setText(newValue.getEmail());
		txtTelefono.setText(newValue.getTelefono());
		txtPosicion.setText(String.valueOf(newValue.getPosicion()));
		txtPreviamente.setText(String.valueOf(newValue.getPreviamente()));
		txtPuntos.setText(String.valueOf(newValue.getPuntos()));
	}

	private void llenarListas() {
		conexion.Conectar();
		conexion.llenarListaSexo(listaSexo);
		conexion.llenarListaCarrera(listaCarrera);
		conexion.llenarListaOrigen(listaOrigen);
		conexion.Cerrar();

		clmPosicion.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("posicion"));
		clmPreviamente.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("previamente"));
		clmJugador.setCellValueFactory(new PropertyValueFactory<Ranking, String>("jugador"));
		clmCarrera.setCellValueFactory(new PropertyValueFactory<Ranking, String>("carrera"));
		clmPuntos.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("Puntos"));
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
