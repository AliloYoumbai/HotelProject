/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package start;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Youmbai
 */
public class GestionHotel extends Application {
	public static Stage stage;

	@Override
	public void start(Stage primarystage) throws Exception {
		stage = primarystage;

		Parent root = FXMLLoader.load(GestionHotel.class.getResource("/view/login.fxml"));

		stage.initStyle(StageStyle.DECORATED);
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.show();
	}

	/**
	 *
	 * @param sceneName
	 * @throws IOException
	 */
	public static void changeScene(String sceneName) throws IOException {
		Parent root = FXMLLoader.load(GestionHotel.class.getResource(sceneName));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/view/style.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.setOnCloseRequest(e->	Platform.exit());
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}