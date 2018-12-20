package start;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login {

	@FXML
	private JFXTextField user;

	@FXML
	private JFXPasswordField pass;
    @FXML
    private Label testP;
    @FXML AnchorPane All;
    @FXML
    private Label testU;

    @FXML
    private JFXSpinner spiner;

    @FXML
	void login(ActionEvent event) {
		if (user.getText().equals("") && pass.getText().equals("")) {
			try {
				 GestionHotel.changeScene("/view/base_interface.fxml");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else 
		{
			this.testU.setVisible(true);
			this.testP.setVisible(true);

		}

	}

}
