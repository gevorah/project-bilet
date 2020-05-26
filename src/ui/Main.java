package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.User;
import model.Registry;



	
	public class Main extends Application {

		
		 
		 
		private static Registry registry;
		private static UsserGUI usserGUI;
		private Scene scene;
		
		public Main() {
			if (registry == null) registry = new Registry();
			usserGUI = new UsserGUI(registry);
		}

		public static void main(String[] args) throws IOException, ClassNotFoundException {
			
			ObjectInputStream entrada = null;
			try
			{
				entrada = new ObjectInputStream(new FileInputStream("data" + File.separator + "Registry.txt")); 
				registry = (Registry)entrada.readObject(); 
				entrada.close();
			}
			catch(Exception e)
			{
				if(entrada != null) entrada.close();
			}
			
			launch(args);
			
			
			ObjectOutputStream salida = new ObjectOutputStream(
			new FileOutputStream("data" + File.separator + "Registry.txt"));
			salida.writeObject(registry);
			salida.close();
		}

		@Override
		public void start(Stage stage) throws Exception {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));

			loader.setController(usserGUI);
			Parent root = loader.load();

			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Project Bilet");
			usserGUI.loadUserWindow(null);
			stage.show();
			stage.sizeToScene();

		}

		
}