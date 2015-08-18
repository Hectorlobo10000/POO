package RankingPro;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class RankingProController  implements Initializable{

	@FXML private MenuItem mnuTorneo;
	@FXML private MenuItem mnuRanking;
	@FXML private MenuItem mnuConfiguraciones;
	@FXML private MenuItem mnuSalir;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML public void abrirRanking(){
		main.mostrarRanking();
	}


	//Referencias
	private Main main;
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
