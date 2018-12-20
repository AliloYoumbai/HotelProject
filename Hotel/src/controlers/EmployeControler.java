package controlers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Employe;
import operation.Traitement;

public class EmployeControler implements Initializable {

	@FXML
	private TableView<Employe> Table_Employes;

	@FXML
	private TableColumn<Employe, Integer> codeemp;

	@FXML
	private TableColumn<Employe, String> nomemp, prenomemp, adresseemp;
	@FXML
	private TableColumn<Employe, Float> salaireemp;
	@FXML
	private JFXTextField AddNom, Addprenom, AddAdres;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		codeemp.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("codeemp"));
		nomemp.setCellValueFactory(new PropertyValueFactory<Employe, String>("nomemp"));
		prenomemp.setCellValueFactory(new PropertyValueFactory<Employe, String>("prenomemp"));
		adresseemp.setCellValueFactory(new PropertyValueFactory<Employe, String>("adremp"));
		salaireemp.setCellValueFactory(new PropertyValueFactory<Employe, Float>("salaireemp"));
		ObservableList<Employe> listeEmp = FXCollections.observableArrayList(new Traitement().gettAllEmployes());

		Table_Employes.setItems(listeEmp);
		Table_Employes.setEditable(true);
	}

	@FXML
	void AddEmploye(ActionEvent event) {
		if (!this.AddAdres.getText().equals("") && !this.AddNom.getText().equals("")
				&& !this.Addprenom.getText().equals("")) {
			Employe emp = new Employe(this.AddNom.getText(), this.Addprenom.getText(), this.AddAdres.getText(), 2000000,
					1);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Add Employe ");
			alert.setHeaderText("Add Employe " + emp.getNomemp() + " / " + emp.getPrenomemp());
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				new Traitement().AddEmplye(emp);
				Table_Employes.getItems().add(emp);
				this.initialize(null, null);
			}
		}
	}

	@FXML
	void DeleteEmploye(ActionEvent event) {
		Employe emp = Table_Employes.getSelectionModel().getSelectedItems().get(0);
		if (emp != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Delete This Employe ?", ButtonType.YES, ButtonType.NO,
					ButtonType.CANCEL);
			alert.showAndWait();
			if (alert.getResult() == ButtonType.YES) {
				ObservableList<Employe> allEmp = Table_Employes.getItems();
				new Traitement().DeleteEmplye(emp);
				allEmp.remove(emp);
			}
		}

	}

	@FXML
	void EditEmploye(ActionEvent event) {
		Employe emp = Table_Employes.getSelectionModel().getSelectedItems().get(0);

		if (!this.AddAdres.getText().equals("") && !this.AddNom.getText().equals("")
				&& !this.Addprenom.getText().equals("") && emp != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Edit  Employe ");
			alert.setHeaderText("Are You sure !!!");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				emp.setAdremp(this.AddAdres.getText());
				emp.setNomemp(this.AddNom.getText());
				emp.setPrenomemp(this.Addprenom.getText());
				new Traitement().EditEmplye(emp);
				Table_Employes.refresh();
			}
		}
	}

	@FXML
	void showEmploye(MouseEvent event) {
		Employe emp = Table_Employes.getSelectionModel().getSelectedItems().get(0);
		this.AddAdres.setText(emp.getAdremp());
		this.AddNom.setText(emp.getNomemp());
		this.Addprenom.setText(emp.getPrenomemp());
	}

}
