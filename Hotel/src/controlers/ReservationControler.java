package controlers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.Categorie;
import model.Chambre;
import operation.Traitement;

public class ReservationControler implements Initializable {

	
	@FXML
	private JFXComboBox<Chambre> Chambre;



	@FXML
	private JFXDatePicker DateFin;

	@FXML
	private JFXDatePicker DateDebut;

	public Stage stage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Chambre.setItems(FXCollections.observableArrayList(new Traitement().getAllChambre()));
	}

	@FXML
	void Close(ActionEvent event) 
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Close ");
		alert.setHeaderText("Are You Sure ");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			
			Contorler.bigLocal.setDisable(false);
			ClientControler.stage.hide();
		}

		
	}

	@FXML
	void Confirme(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Close ");
		alert.setHeaderText("Are You Sure ");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			
			Contorler.bigLocal.setDisable(false);
			ClientControler.stage.hide();
		}

	}

}
