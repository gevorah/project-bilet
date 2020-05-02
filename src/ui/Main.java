package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import model.Registry;

public class Main extends Application {

	private Registry registry;
	private UsserGUI usserGUI;

	public Main() {
		registry = new Registry();
		usserGUI = new UsserGUI(registry);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));

		loader.setController(usserGUI);
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Tech Suvery");
		usserGUI.loadUserWindow(null);
		stage.show();

	}

}