package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class UsserGUI {

    @FXML
    private BorderPane mainpanel;
    
    
	@FXML
	void loadGame(ActionEvent event) {

	}

	@FXML
	void registry(ActionEvent event) {

	}
	
	@FXML
	public void loadUserWindow(ActionEvent event) throws Exception {

		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserWindow.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();

		mainpanel.getChildren().clear();
		mainpanel.setCenter(registry);
		
	}
}
