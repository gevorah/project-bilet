package ui;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Registry;

public class UsserGUI {

	@FXML
	private BorderPane mainpanel;

	@FXML
	private Label lmessage;

	@FXML
	private TextField tfNick;

	@FXML
	private ImageView ivAvatar;

	@FXML
	private Button bChooseAvatar;

	@FXML
	public void loadGame(ActionEvent event) {

	}

	@FXML
	public void registry(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProfileWindow.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();

		mainpanel.getChildren().clear();
		mainpanel.setCenter(registry);

	}

	@FXML
	public void showScore(ActionEvent event) {

	}

	private Registry registry;

	public UsserGUI(Registry registry2) {
		registry = registry2;
	}

	@FXML
	public void loadUserWindow(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserWindow.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();

		mainpanel.getChildren().clear();
		mainpanel.setCenter(registry);

	}

	@FXML
    void chooseAvatar(ActionEvent event) {
		JFileChooser choose = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("All images","jpg","jpeg","png");
		choose.setFileFilter(filter);
		int op = choose.showOpenDialog(null);
		if(op==JFileChooser.APPROVE_OPTION) {
			Image avatar = new Image("file:"+choose.getSelectedFile().getAbsolutePath());
			ivAvatar.setImage(avatar);
		}
    }

	@FXML
	void addUser(ActionEvent event) throws Exception {

		Image avatar = ivAvatar.getImage();
		String nickname = tfNick.getText();
		
		if (!nickname.trim().equals("")) {
			registry.addUser(avatar,nickname);

			loadUserWindow(null);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle(null);
    		alert.setContentText("Please fill.");
    		alert.showAndWait();
		}
	}
}
