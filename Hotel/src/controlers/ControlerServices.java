package controlers;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Chambre;
import model.Service;
import operation.Traitement;

public class ControlerServices implements Initializable {

	@FXML
	private TableView<Service> Table_Services;

	@FXML
	private TableColumn<Service, Integer> IDS;

	@FXML
	private TableColumn<Service, String> NomS;

	@FXML
	private TableColumn<Service, Double> PrixS;

	@FXML
	private JFXTextField AddNomS;

	@FXML
	private JFXTextField AddPrixS;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		IDS.setCellValueFactory(new PropertyValueFactory<>("ids"));
		NomS.setCellValueFactory(new PropertyValueFactory<>("noms"));
		PrixS.setCellValueFactory(new PropertyValueFactory<>("prixs"));
		ObservableList<Service> liste = FXCollections.observableArrayList(new Traitement().getAllServices());
		// --------------------------
		Table_Services.setItems(liste);
		Table_Services.setEditable(true);

	}

	@FXML
	void AddServices(ActionEvent event) {
		if (!AddNomS.getText().equals("") && !AddPrixS.getText().equals("")) {
			// JUST FOR TESTING
			Service serve = new Service(200, AddNomS.getText(), Double.parseDouble(AddPrixS.getText()));
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Add Service ");
			alert.setHeaderText("Add Service " + serve.getNoms());
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// ch = new Traitement().addChambre(ch);
				Table_Services.getItems().add(serve);
			}
		}

	}

	@FXML
	void DeleteServices(ActionEvent event) {
		Service service = Table_Services.getSelectionModel().getSelectedItems().get(0);
		if (service != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Delete This Service ?", ButtonType.YES, ButtonType.NO,
					ButtonType.CANCEL);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.YES) {
				ObservableList<Service> allServices = Table_Services.getItems();

				// new Traitement().deleteChambre(chambre);
				allServices.remove(service);
			}
		}

	}

	@FXML
	void EditServices(ActionEvent event) {
		Service serve = Table_Services.getSelectionModel().getSelectedItems().get(0);

		if (!AddNomS.getText().equals("") && !AddPrixS.getText().equals("")&& serve !=null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Edit  Chambre ");
			alert.setHeaderText("Are You sure !!!");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				serve.setNoms(AddNomS.getText());
				serve.setPrixs(Double.parseDouble(AddPrixS.getText()));
				// new Traitement().editChambre(cd);
				Table_Services.refresh();
			}
		}
	}

	@FXML
	void showServe(MouseEvent event) {
		Service serv = Table_Services.getSelectionModel().getSelectedItems().get(0);
		this.AddNomS.setText(serv.getNoms());
		this.AddPrixS.setText(serv.getPrixs() + "");
	}

}
