package ui;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
import model.Character;
import model.Player;
import model.Registry;
import model.User;

public class UsserGUI {

	@FXML
	private Label nameUser;
	  
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
	
	private GameZone gz;
	private Registry registry;
	private User user;  
	@FXML
    private TableView<User> txScoreTV;

    @FXML
    private TableColumn<User, Long > tclScore;

    @FXML
    private TableColumn<User , String > tclName;

    @FXML
    void loadBack(ActionEvent event) throws Exception {
    	
    	loadUserWindow(null);

    }

    @FXML
    void loadViewProfile(ActionEvent event) throws Exception {
    	
    	loadLevels(null);

    }
	
	public UsserGUI(Registry registry) {
		this.registry = registry;
		user = new User(new Image("file:"+"img\\default.jpeg"), "Gevorah");
		user.setPlayer1(new Player(new Character(0, 0, new Image("file:"+"img\\default.jpeg"), 2, 5, 5, "Any")));
		user.setPlayer2(new Player(new Character(0, 0, new Image("file:"+"img\\level1.png"), 2, 5, 5, "Any")));
		//gz = new GameZone(user,);
	}
	@FXML
	public void loadGameZone(ActionEvent event) {
		gz.manager();
		mainpanel.setCenter(gz.getCanvas());
		gz.gameLoop();
	}
	
	@FXML
	public void loadLevels(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LevelsWindow.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();
		nameUser.setText(tfNick.getText());
		mainpanel.getChildren().clear();
		mainpanel.setCenter(registry);
	}

	@FXML
	public void registry(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProfileWindow.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();

		mainpanel.getChildren().clear();
		mainpanel.setCenter(registry);

	
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
		tclName.setCellValueFactory(new PropertyValueFactory<User,String>("nickname"));
		tclScore.setCellValueFactory(new PropertyValueFactory<User,Long>("score"));

	}

	@FXML
	public void showScore(ActionEvent event) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ScoreWindow.fxml"));
		
		fxmlLoader.setController(this);
		BorderPane scorePane = fxmlLoader.load();
    	
		mainpanel.getChildren().clear();
    	mainpanel.setCenter(scorePane);
    	
		
		

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
		choose.setAcceptAllFileFilterUsed(false);
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

			loadLevels(null);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle(null);
    		alert.setContentText("Please fill.");
    		alert.showAndWait();
		}
	}
}
