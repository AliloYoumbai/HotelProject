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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Categorie;
import operation.Traitement;

public class ControlerCategorie implements Initializable {

	@FXML
	private TableView<Categorie> Table_cat;

	@FXML
	private TableColumn<Categorie, Integer> codeCate;

	@FXML
	private TableColumn<Categorie, String> descCat;

	@FXML
	private JFXTextField AddDesc;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		codeCate.setCellValueFactory(new PropertyValueFactory<Categorie,Integer>("codecat"));
		descCat.setCellValueFactory(new PropertyValueFactory<Categorie,String>("description"));
		ObservableList<Categorie> liste = FXCollections.observableArrayList(new Traitement().getAllCategories());
		Table_cat.setItems(liste);
		Table_cat.setEditable(true);
	}

	@FXML
	void AddCat(ActionEvent event) {
		if (!AddDesc.getText().equals("")) {
			Categorie cat = new Categorie(AddDesc.getText());
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Add Categorie ");
			alert.setHeaderText("Add Categorie " + cat.getDescription());
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				new Traitement().addCategorie(cat);
				Table_cat.getItems().add(cat);
				this.initialize(null, null);
			}
		}

	}

	@FXML
	void DeleteCat(ActionEvent event) {
		Categorie cat = Table_cat.getSelectionModel().getSelectedItems().get(0);

		if (cat != null) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete This Categorie"+cat.getDescription()+" ?", ButtonType.YES,
					ButtonType.NO, ButtonType.CANCEL);
			alert.showAndWait();

			if (alert.getResult() == ButtonType.YES) {
				ObservableList<Categorie> allCategorie = Table_cat.getItems();
				new Traitement().DeleteCategorie(cat);
				allCategorie.remove(cat);

			}
		}

	}

	@FXML
    void EditCat(ActionEvent event) {
    	
        Categorie cat = Table_cat.getSelectionModel().getSelectedItems().get(0);

        if (!AddDesc.getText().equals("")&&cat != null) 
        {
            
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Edit  Categorie ");
                alert.setHeaderText("Are You sure !!!");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    cat.setDescription(AddDesc.getText());
                    new Traitement().EditCategorie(cat);
                    Table_cat.refresh();
                }
            
        }
    }

	@FXML
	void showCat(MouseEvent event) {
		Categorie cat = Table_cat.getSelectionModel().getSelectedItems().get(0);
		this.AddDesc.setText(cat.getDescription());
	}

}
