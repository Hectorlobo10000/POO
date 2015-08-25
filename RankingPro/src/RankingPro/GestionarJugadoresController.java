package RankingPro;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Carrera;
import Modelo.Conexion;
import Modelo.Origen;
import Modelo.Ranking;
import Modelo.Sexo;
import Modelo.Validaciones;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;

public class GestionarJugadoresController implements Initializable{


	@FXML private TableView<Ranking> tblRanking;
	@FXML private TableColumn<Ranking, String> clmCuenta;
	@FXML private TableColumn<Ranking, String> clmPrimerNombre;
	@FXML private TableColumn<Ranking, String> clmSegundoNombre;
	@FXML private TableColumn<Ranking, String> clmPrimerApellido;
	@FXML private TableColumn<Ranking, String> clmSegundoApellido;
	@FXML private TableColumn<Ranking, String> clmSexo;
	@FXML private TableColumn<Ranking, String> clmOrigen;
	@FXML private TableColumn<Ranking, String> clmCarrera;
	@FXML private TableColumn<Ranking, Number> clmEdad;
	@FXML private TableColumn<Ranking, String> clmCorreo;
	@FXML private TableColumn<Ranking, String> clmTelefono;
	@FXML private TableColumn<Ranking, Number> clmPosicion;
	@FXML private TableColumn<Ranking, Number> clmPreviamente;
	@FXML private TableColumn<Ranking, Number> clmPuntos;

	@FXML private ImageView imgFoto;
	@FXML private TextField txtCuenta;
	@FXML private TextField txtPrimerNombre;
	@FXML private TextField txtSegundoNombre;
	@FXML private TextField txtPrimerApellido;
	@FXML private TextField txtSegundoApellido;
	@FXML private ComboBox<Sexo> cboSexo;
	@FXML private ComboBox<Origen> cboOrigen;
	@FXML private ComboBox<Carrera> cboCarrera;
	@FXML private TextField txtEdad;
	@FXML private TextField txtCorreo;
	@FXML private TextField txtTelefono;
	@FXML private TextField txtPosicion;
	@FXML private TextField txtPreviamente;
	@FXML private TextField txtPuntos;
	@FXML private Button btnSalvar;
	@FXML private Button btnActualizar;
	@FXML private Button btnNuevo;

	private ObservableList<Ranking> listaRanking;
	private ObservableList<Sexo> listaSexo;
	private ObservableList<Origen> listaOrigen;
	private ObservableList<Carrera> listaCarrera;

	private Conexion conexion;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conexion = new Conexion();
		listaRanking = FXCollections.observableArrayList();
		listaSexo = FXCollections.observableArrayList();
		listaOrigen = FXCollections.observableArrayList();
		listaCarrera = FXCollections.observableArrayList();
		llenarListas();
		tblRanking.setItems(listaRanking);
		cboSexo.setItems(listaSexo);
		cboOrigen.setItems(listaOrigen);
		cboCarrera.setItems(listaCarrera);

		tblRanking.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ranking>(){

			@Override
			public void changed(ObservableValue<? extends Ranking> observable, Ranking oldValue, Ranking newValue) {
				if(newValue != null){
					llenarComponentes(newValue);
					imgFoto.setDisable(false);
					btnActualizar.setDisable(false);
					btnNuevo.setDisable(false);
					btnSalvar.setDisable(true);
				}
			}

		});
	}

	private String foto = "";
	private void llenarComponentes(Ranking newValue) {
		foto = newValue.getFoto();
		Image image = new Image("file:" + newValue.getFoto());
		imgFoto.setImage(image);
		txtCuenta.setText(newValue.getCuenta());
		txtPrimerNombre.setText(newValue.getPrimerNombre());
		txtSegundoNombre.setText(newValue.getSegundoNombre());
		txtPrimerApellido.setText(newValue.getPrimerApellido());
		txtSegundoApellido.setText(newValue.getSegundoApellido());
		cboSexo.getSelectionModel().select(newValue.getSexo());
		cboOrigen.getSelectionModel().select(newValue.getOrigen());
		cboCarrera.getSelectionModel().select(newValue.getCarrera());
		txtEdad.setText(String.valueOf(newValue.getEdad()));
		txtCorreo.setText(newValue.getEmail());
		txtTelefono.setText(newValue.getTelefono());
		txtPosicion.setText(String.valueOf(newValue.getPosicion()));
		txtPreviamente.setText(String.valueOf(newValue.getPreviamente()));
		txtPuntos.setText(String.valueOf(newValue.getPuntos()));
	}


	public void llenarListas() {
		conexion.Conectar();
		conexion.llenarListaRanking(listaRanking);
		conexion.llenarListaSexo(listaSexo);
		conexion.llenarListaOrigen(listaOrigen);
		conexion.llenarListaCarrera(listaCarrera);
		conexion.Cerrar();

		clmCuenta.setCellValueFactory(new PropertyValueFactory<Ranking, String>("cuenta"));
		clmPrimerNombre.setCellValueFactory(new PropertyValueFactory<Ranking, String>("primerNombre"));
		clmSegundoNombre.setCellValueFactory(new PropertyValueFactory<Ranking, String>("segundoNombre"));
		clmPrimerApellido.setCellValueFactory(new PropertyValueFactory<Ranking, String>("primerApellido"));
		clmSegundoApellido.setCellValueFactory(new PropertyValueFactory<Ranking, String>("SegundoApellido"));
		clmSexo.setCellValueFactory(new PropertyValueFactory<Ranking, String>("sexo"));
		clmOrigen.setCellValueFactory(new PropertyValueFactory<Ranking, String>("origen"));
		clmCarrera.setCellValueFactory(new PropertyValueFactory<Ranking, String>("carrera"));
		clmEdad.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("edad"));
		clmCorreo.setCellValueFactory(new PropertyValueFactory<Ranking, String>("email"));
		clmTelefono.setCellValueFactory(new PropertyValueFactory<Ranking, String>("telefono"));
		clmPosicion.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("posicion"));
		clmPreviamente.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("previamente"));
		clmPuntos.setCellValueFactory(new PropertyValueFactory<Ranking, Number>("puntos"));
	}

	private File imgFile = null;
	@FXML private void cargarFoto(){
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Cargar Foto");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        imgFile = fileChooser.showOpenDialog(main.formularioGestionarJugadores);
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            imgFoto.setImage(image);
        }
	}

	@FXML private void salvar(){
		String insertarFoto = "";
		if(imgFile == null){
			insertarFoto = "nada";
		}else{
			insertarFoto = imgFile.getAbsolutePath();
		}
		String resultados = Validaciones.getValidar(
				txtCuenta.getText(),
				txtPrimerNombre.getText(),
				txtSegundoNombre.getText(),
				txtPrimerApellido.getText(),
				txtSegundoApellido.getText(),
				txtEdad.getText(),
				txtCorreo.getText(),
				txtTelefono.getText(),
				txtPreviamente.getText(),
				txtPuntos.getText(), listaRanking);
		if(resultados.isEmpty()){
			Ranking ranking = new Ranking(
					txtCuenta.getText(),
					txtPrimerNombre.getText(),
					txtSegundoNombre.getText(),
					txtPrimerApellido.getText(),
					txtSegundoApellido.getText(),
					cboSexo.getSelectionModel().getSelectedItem(),
					cboOrigen.getSelectionModel().getSelectedItem(),
					cboCarrera.getSelectionModel().getSelectedItem(),
					Integer.valueOf(txtEdad.getText()),
					txtCorreo.getText(),
					txtTelefono.getText(),
					0,
					Integer.valueOf(txtPreviamente.getText()),
					Integer.valueOf(txtPuntos.getText()),
					insertarFoto);
			conexion.Conectar();
			int valor = ranking.guardarRegistro(conexion);
			conexion.Cerrar();
			if(valor == 1){
				listaRanking.clear();
				conexion.Conectar();
				conexion.llenarListaRanking(listaRanking);
				conexion.Cerrar();
				limpiar();
				Alert alerta = new Alert(AlertType.CONFIRMATION);
				alerta.setTitle("Sistema de Ranking");
				alerta.setContentText("Registro guardado");
				alerta.initModality(Modality.WINDOW_MODAL);
				alerta.initOwner(main.formularioGestionarJugadores);
				alerta.showAndWait();
			}else{
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Sistema de Ranking");
				alerta.setContentText("No se pudo guardar el registro");
				alerta.initModality(Modality.WINDOW_MODAL);
				alerta.initOwner(main.formularioGestionarJugadores);
				alerta.showAndWait();
			}
		}else{
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Sistema de Ranking");
			alerta.setContentText(resultados);
			alerta.initModality(Modality.WINDOW_MODAL);
			alerta.initOwner(main.formularioGestionarJugadores);
			alerta.showAndWait();
		}

	}

	private void limpiar() {
		Image image = new Image("file:");
		imgFoto.setImage(image);
		txtCuenta.setText(null);
		txtPrimerNombre.setText(null);
		txtSegundoNombre.setText(null);
		txtPrimerApellido.setText(null);
		txtSegundoApellido.setText(null);
		cboSexo.getSelectionModel().select(null);
		cboOrigen.getSelectionModel().select(null);
		cboCarrera.getSelectionModel().select(null);
		txtEdad.setText(null);
		txtCorreo.setText(null);
		txtTelefono.setText(null);
		txtPosicion.setText(null);
		txtPreviamente.setText(null);
		txtPuntos.setText(null);
		btnSalvar.setDisable(true);
		btnActualizar.setDisable(true);
		btnNuevo.setDisable(false);
		imgFoto.setDisable(true);
		imgFile = null;
	}


	@FXML private void nuevo(){
		Image image = new Image("file:");
		imgFoto.setImage(image);
		txtCuenta.setText(null);
		txtPrimerNombre.setText(null);
		txtSegundoNombre.setText(null);
		txtPrimerApellido.setText(null);
		txtSegundoApellido.setText(null);
		cboSexo.getSelectionModel().select(null);
		cboOrigen.getSelectionModel().select(null);
		cboCarrera.getSelectionModel().select(null);
		txtEdad.setText(null);
		txtCorreo.setText(null);
		txtTelefono.setText(null);
		txtPosicion.setText(null);
		txtPreviamente.setText(null);
		txtPuntos.setText(null);
		btnSalvar.setDisable(false);
		btnActualizar.setDisable(true);
		btnNuevo.setDisable(false);
		imgFoto.setDisable(false);
		imgFile = null;
	}

	@FXML private void modificar(){

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
