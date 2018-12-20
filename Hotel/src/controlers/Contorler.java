/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import start.GestionHotel;

public class Contorler implements Initializable {

	@FXML
	private Pane AllContenet;
	@FXML
	private AnchorPane big;
	public static AnchorPane bigLocal;

	// ---------------------------------------------------------//
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bigLocal = big;
		this.ChambrePane(null);
	}

	@FXML
	public void CategoriePane(ActionEvent event) {

		try {
			Pane root = FXMLLoader.load(GestionHotel.class.getResource("/view/categori_interface.fxml"));
			AllContenet.getChildren().removeAll(AllContenet.getChildren());
			AllContenet.getChildren().add(root);

		} catch (IOException ex) {
			Logger.getLogger(Contorler.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@FXML
	public void ServicePane(ActionEvent event) {
		try {
			Pane root = FXMLLoader.load(GestionHotel.class.getResource("/view/servise_interface.fxml"));
			AllContenet.getChildren().removeAll(AllContenet.getChildren());
			AllContenet.getChildren().add(root);

		} catch (IOException ex) {
			Logger.getLogger(Contorler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void ClientPane(ActionEvent event) {
		try {
			Pane root = FXMLLoader.load(GestionHotel.class.getResource("/view/client_interface.fxml"));
			AllContenet.getChildren().removeAll(AllContenet.getChildren());
			AllContenet.getChildren().add(root);

		} catch (IOException ex) {
			Logger.getLogger(Contorler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void EmployePane(ActionEvent event) {
		try {
			Pane root = FXMLLoader.load(GestionHotel.class.getResource("/view/employe_interface.fxml"));
			AllContenet.getChildren().removeAll(AllContenet.getChildren());
			AllContenet.getChildren().add(root);

		} catch (IOException ex) {
			Logger.getLogger(Contorler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void ChambrePane(ActionEvent event) {
		try {
			Pane root = FXMLLoader.load(GestionHotel.class.getResource("/view/chambre_interface.fxml"));
			AllContenet.getChildren().removeAll(AllContenet.getChildren());
			AllContenet.getChildren().add(root);

		} catch (IOException ex) {
			Logger.getLogger(Contorler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void logout(ActionEvent event) {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Logout");
			alert.setHeaderText("Are You sure to Logout");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				AllContenet = null;
				GestionHotel.changeScene("/view/login.fxml");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
