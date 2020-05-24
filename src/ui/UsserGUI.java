package ui;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import customExceptions.RepeatUserException;
import customExceptions.invalidInformationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Character;
import model.Player;
import model.Registry;
import model.User;

public class UsserGUI {

	@FXML
	private Label nameUser;

	@FXML
	private BorderPane mainPane;

	@FXML
	private Label lmessage;

	@FXML
	private TextField tfNick;

	@FXML
	private ImageView ivAvatar;

	@FXML
	private Button bChooseAvatar;

	@FXML
	private Pane paneLevels;

	private GameZone gz;
	private Registry registry;
	private User user;
	@FXML
	private TableView<User> txScoreTV;

	@FXML
	private TableColumn<User, Long> tclScore;

	@FXML
	private TableColumn<User, String> tclName;

	public static HashMap<String, Image> images;

	@FXML
	public void loadViewProfile(ActionEvent event) throws Exception {

		// loadLevels(null);

	}

	public UsserGUI(Registry registry) {
		images = new HashMap<>();
		loadImages();
		this.registry = registry;
	}

	public void loadImages() {
		images.put("character_1",
				new Image("file:/C:/Users/onlyg/Documents/Projects/project-bilet/imgs/character_1.png"));
		images.put("tilemap", new Image("file:/C:/Users/onlyg/Documents/Projects/project-bilet/imgs/tilemap.png"));
		images.put("fondo", new Image("file:/C:/Users/onlyg/Documents/Projects/project-bilet/imgs/fondo-Azul.png"));
	}

	@FXML
	public void loadGameZone(ActionEvent event) {
		gz = new GameZone();
		mainPane.getChildren().clear();
		mainPane.setCenter(gz);
		gz.loop();
	}

	@FXML
	public void loadLevels(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LevelsWindow.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(registry);

	}

	@FXML
	public void registry(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProfileWindow.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(registry);

	}

	public void initialize() throws Exception {

		if (txScoreTV != null) {

			initializeScores();
		}

	}

	public void initializeScores() {
		ObservableList<User> observableList;
		observableList = FXCollections.observableArrayList(registry.getUsers());

		txScoreTV.setItems(observableList);
		tclName.setCellValueFactory(new PropertyValueFactory<User, String>("nickname"));
		tclScore.setCellValueFactory(new PropertyValueFactory<User, Long>("score"));

	}

	@FXML
	public void showScore(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ScoreWindow.fxml"));

		fxmlLoader.setController(this);
		BorderPane scorePane = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(scorePane);

	}

	@FXML
	public void loadUserWindow(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserWindow.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(registry);

	}

	@FXML
	public void chooseAvatar(ActionEvent event) {
		JFileChooser choose = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("All images", "jpg", "jpeg", "png");
		choose.setAcceptAllFileFilterUsed(false);
		choose.setFileFilter(filter);
		int op = choose.showOpenDialog(null);
		if (op == JFileChooser.APPROVE_OPTION) {
			Image avatar = new Image("file:" + choose.getSelectedFile().getAbsolutePath());
			ivAvatar.setImage(avatar);
		}
	}

	@FXML
	public void addUser(ActionEvent event) throws Throwable {
		Image avatar = ivAvatar.getImage();
		String nickname = tfNick.getText();

		
		try {

			registry.addUser(avatar, nickname);
			loadLevels(null);

		} catch (invalidInformationException iv) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(null);
			alert.setContentText("fill in the fields");
			alert.showAndWait();

		} catch (RepeatUserException re) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(null);
			alert.setContentText("There is already a registered user with this nickname");
			alert.showAndWait();
		}
	}


    @FXML
    public void back(ActionEvent event) throws Exception {
    	
    	loadUserWindow(null);
    }
    
	@FXML
	public void levelFour1(ActionEvent event) {

	}

	@FXML
	public void levelFour2(ActionEvent event) {

	}

	@FXML
	public void levelFour3(ActionEvent event) {

	}

	@FXML
	public void levelOne1(ActionEvent event) {

	}

	@FXML
	public void levelOne2(ActionEvent event) {

	}

	@FXML
	public void levelThree1(ActionEvent event) {

	}

	@FXML
	public void levelThree2(ActionEvent event) {

	}

	@FXML
	public void levelTwo1(ActionEvent event) {

	}

	@FXML
	public void levelTwo2(ActionEvent event) {

	}

	@FXML
	public void levelTwo3(ActionEvent event) {

	}

	@FXML
	void pilot(ActionEvent event) {

	}

	@FXML
	public void win(ActionEvent event) {

	}

}
