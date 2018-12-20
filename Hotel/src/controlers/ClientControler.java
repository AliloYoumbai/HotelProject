package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Client;
import operation.Traitement;
import start.GestionHotel;

public class ClientControler implements Initializable {

	@FXML
	private TableView<Client> Table_Clients;

	@FXML
	private TableColumn<Client, Integer> codecl;

	@FXML
	private TableColumn<Client, String> Nomcl, prenomcl;

	@FXML
	private JFXTextField AddNomcl, Addprenomcl;
	public static Stage stage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.showReserve();
		codecl.setCellValueFactory(new PropertyValueFactory<Client, Integer>("codecl"));
		Nomcl.setCellValueFactory(new PropertyValueFactory<Client, String>("nomcl"));
		prenomcl.setCellValueFactory(new PropertyValueFactory<Client, String>("prenomcl"));

		ObservableList<Client> listeClient = FXCollections.observableArrayList(new Traitement().getAllClients());
		Table_Clients.setItems(listeClient);
		Table_Clients.setEditable(true);
	}

	@FXML
	void AddClient(ActionEvent event) {
		if (!AddNomcl.getText().equals("") && !Addprenomcl.getText().equals("")) {
			// juste for testing
			Client client = new Client(AddNomcl.getText(), Addprenomcl.getText());
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Add Client ");
			alert.setHeaderText("Add Client " + client.getNomcl() + " / " + client.getPrenomcl());
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				new Traitement().AddClient(client);
				Table_Clients.getItems().add(client);
				this.initialize(null, null);
			}
		}
	}

	@FXML
	void DeleteClient(ActionEvent event) {
		Client client = Table_Clients.getSelectionModel().getSelectedItems().get(0);
		if (client != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Delete This Client ?", ButtonType.YES, ButtonType.NO,
					ButtonType.CANCEL);
			alert.showAndWait();
			if (alert.getResult() == ButtonType.YES) {
				ObservableList<Client> allClient = Table_Clients.getItems();
				new Traitement().DeleteClient(client);
				allClient.remove(client);

			}
		}

	}

	@FXML
	void EditClient(ActionEvent event) {
		Client client = Table_Clients.getSelectionModel().getSelectedItems().get(0);

		if (!AddNomcl.getText().equals("") && !Addprenomcl.getText().equals("") && client != null) {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Edit  Client ");
			alert.setHeaderText("Are You sure !!!");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				client.setNomcl(AddNomcl.getText());
				client.setPrenomcl(Addprenomcl.getText());
				new Traitement().EditClient(client);
				Table_Clients.refresh();
			}

		}

	}

	@FXML
	void showClient(MouseEvent event) {
		Client client = Table_Clients.getSelectionModel().getSelectedItems().get(0);
		this.AddNomcl.setText(client.getNomcl());
		this.Addprenomcl.setText(client.getPrenomcl());
	}

	@FXML
	void Reserver(ActionEvent event) {
		Client client = Table_Clients.getSelectionModel().getSelectedItems().get(0);
		if (client != null) {
			Contorler.bigLocal.setDisable(true);
			stage.show();
			stage.setOnCloseRequest(e -> {
				Contorler.bigLocal.setDisable(false);

			});
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setContentText("Please Select Client !!!");

			alert.showAndWait();
		}

	}

	public void showReserve() {
		try {
			stage = new Stage();
			Parent root = FXMLLoader.load(GestionHotel.class.getResource("/view/reserve_interface.fxml"));
			stage.initStyle(StageStyle.DECORATED);
			stage.setScene(new Scene(root));
			stage.setResizable(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
