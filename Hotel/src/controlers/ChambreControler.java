package controlers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Categorie;
import model.Chambre;
import operation.Traitement;

public class ChambreControler implements Initializable {

	@FXML
	private TableView<Chambre> Table_Chambre;

	@FXML
	private TableColumn<Chambre, Integer> numCH,categorie ;

	@FXML
	private TableColumn<Chambre, String> descCh, typeCH;
	@FXML
	private TableColumn<Chambre, Float> prixch;

	@FXML
	private JFXTextField AdddescCH, AddTypeCH, AddPrixCh;
	@FXML
	private ChoiceBox<Categorie> AddCate;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		descCh.setCellValueFactory(new PropertyValueFactory<Chambre,String>("desch"));
		typeCH.setCellValueFactory(new PropertyValueFactory<Chambre,String>("typech"));
		prixch.setCellValueFactory(new PropertyValueFactory<Chambre,Float>("prixch"));
		categorie.setCellValueFactory(new PropertyValueFactory<Chambre,Integer>("codecat"));
		numCH.setCellValueFactory(new PropertyValueFactory<Chambre,Integer>("numch"));

		// -------get data from database
		ArrayList<Categorie> lis = new Traitement().getAllCategories();
		
		AddCate.setItems(FXCollections.observableArrayList(lis));

		ObservableList<Chambre> listeChambres = FXCollections.observableArrayList(new Traitement().getAllChambre());
		// --------------------------
		Table_Chambre.setItems(listeChambres);
		Table_Chambre.setEditable(true);

	}

	@FXML
	void AddChambre(ActionEvent event) {
		if (!AdddescCH.getText().equals("") && !AddTypeCH.getText().equals("") && !AddPrixCh.getText().equals("")
				&& !AddCate.getValue().equals("")) {
			Chambre ch = new Chambre(AdddescCH.getText(), AddTypeCH.getText(), Float.parseFloat(AddPrixCh.getText()),
					AddCate.getValue().getCodecat());

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Add Chambre ");
			alert.setHeaderText("Add Chambre " + ch.getDesch());
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				new Traitement().addChambre(ch);
				Table_Chambre.getItems().add(ch);
				this.initialize(null, null);
			}
		}

	}

	@FXML
	void removeChambre(ActionEvent event) {
		Chambre chambre = Table_Chambre.getSelectionModel().getSelectedItems().get(0);
		if (chambre != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Delete This Chamber ?", ButtonType.YES, ButtonType.NO,
					ButtonType.CANCEL);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.YES) {
				ObservableList<Chambre> allChambre = Table_Chambre.getItems();
				new Traitement().deleteChambre(chambre);
				allChambre.remove(chambre);
			}
		}

	}

	@FXML
	void EditChambre(ActionEvent event) {
		Chambre cd = Table_Chambre.getSelectionModel().getSelectedItems().get(0);

		if (!AdddescCH.getText().equals("") && !AddTypeCH.getText().equals("") && !AddPrixCh.getText().equals("")
				&& !AddCate.getValue().equals("") && cd != null) {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Edit  Chambre ");
			alert.setHeaderText("Are You sure !!!");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				cd.setDesch(AdddescCH.getText());
				cd.setTypech(AddTypeCH.getText());
				cd.setPrixch(Float.parseFloat(AddPrixCh.getText()));
				cd.setCodecat(AddCate.getValue().getCodecat());
				new Traitement().editChambre(cd);
				Table_Chambre.refresh();
			}
		}

	}

	@FXML
	void showData(MouseEvent event) {
		Chambre cd = Table_Chambre.getSelectionModel().getSelectedItems().get(0);
		this.AdddescCH.setText(cd.getDesch());
		this.AddPrixCh.setText(cd.getPrixch() + "");
		this.AddTypeCH.setText(cd.getTypech());

	}
	
	

}
