
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Character;
import model.Player;
import model.Registry;
import model.Story;
import model.Top;
import model.TopInterface;
import model.User;
import threads.TimeKeeperThread;

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
    private GridPane gridPane;
    
    
    @FXML
    private Pane paneLevels;

    @FXML
    private Label information;

	private Registry registry;
	private Tablero tablero;
	private TimeKeeperThread tk;
	private TopInterface top;
	private boolean sortedByName = false;
	private boolean sortedByScore = false;
	@FXML
	private TableView<User> txScoreTV;

	@FXML
	private TableColumn<User, Long> tclScore;

	@FXML
	private TableColumn<User, String> tclName;

	public static HashMap<String, Image> images;

	@FXML
	void loadSortSandN(ActionEvent event) {
		
		registry.sortByScoreNick();
		
		initializeScores();


	
	}
	@FXML
	void loadSortByName(ActionEvent event) {
		
		if(!sortedByName) {
			
		sortedByName = true;
		registry.sortByNombreAtoZ();
		}else {
			sortedByName = false;
			
			registry.sortByNombreZtoA();
		}
		initializeScores();


	
	}
	@FXML
	void loadSortByScore(ActionEvent event) {
		
		if(!sortedByScore) {
			
		sortedByScore= true;
		registry.ordenarPuntajeMaxToMin();
		}else {
			sortedByScore= false;
			registry.ordernarPuntajeMinToMax();
		}
		
		initializeScores();


	
	}
	
	
	
	public UsserGUI(Registry registry) {
		this.registry = registry;
		top = new Top();
	}
	
	public void setRegistry(Registry registry)
	{
		this.registry = registry;
	}

	@FXML
	public void loadGameZone(ActionEvent event) throws Exception {
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("top.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();
		mainPane.getChildren().clear();
		
		mainPane.setCenter(registry);
	    
	    
	    if (top.recorridoInorden().equals("")) {
	    	information.setText("Vacío");
	    }else {	
	     information.setText(top.recorridoInorden());	
	    
	    }
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
	void chooseAvatar(ActionEvent event) {
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
			
			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter("data" + File.separator + "puntajes.txt"));
			bw.write(nickname + "\n");
			bw.close();
			
		} catch (invalidInformationException iv) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(null);
			alert.setContentText(iv.message());
			alert.showAndWait();

		} catch (RepeatUserException re) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle(null);
			alert.setContentText(re.Message(nickname));
			alert.showAndWait();
		}
	}


    @FXML
    public void back(ActionEvent event) throws Exception {
    	
    	loadUserWindow(null);
    }
    

    @FXML
    void searchUser(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchUser.fxml"));
		fxmlLoader.setController(this);
		Parent registry = fxmlLoader.load();
		mainPane.getChildren().clear();
		
		mainPane.setCenter(registry);
    	
    }

    
    @FXML
    void leveFour3(ActionEvent event) {
    	tablero = new Tablero("maps/lvlFour3.txt",this); 
    	
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    	
    }

    @FXML
    void levelFour1(ActionEvent event) {
    	tablero = new Tablero("maps/lvlFour1.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void levelFour2(ActionEvent event) {
    	tablero = new Tablero("maps/lvlFour2.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void levelOne1(ActionEvent event) {
    	tablero = new Tablero("maps/lvlOne1.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);;
    }

    @FXML
    void levelOne2(ActionEvent event) {
    	tablero = new Tablero("maps/lvlOne2.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void levelThree1(ActionEvent event) {
    	tablero = new Tablero("maps/lvlThree1.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void levelThree2(ActionEvent event) {
    	tablero = new Tablero("maps/lvlThree2.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void levelTwo1(ActionEvent event) {
    	tablero = new Tablero("maps/lvlTwo1.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void levelTwo2(ActionEvent event) {
    	tablero = new Tablero("maps/lvlTwo2.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void levelTwo3(ActionEvent event) {
    	tablero = new Tablero("maps/lvlTwo3.txt",this); 
    	mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void pilot(ActionEvent event) {
    	

		tablero = new Tablero("maps/lvlPilot.txt",this); 
		mainPane.setVisible(false);
    	tablero.setVisible(true);
    }

    @FXML
    void win(ActionEvent event) {

    }
    @FXML
    void statistics(ActionEvent event) throws Exception {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Pop-up.fxml"));
		loader.setController(this);
		DialogPane root = loader.load();
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setDialogPane(root);
		dialog.setTitle("Statistics");
    	dialog.show();
    	//GridPane gp = new GridPane();
		gridPane.add(pieChart(), 0, 0);
		gridPane.add(lineChart(), 1, 0);
		
		
		
		
		   	
    }
    
    public PieChart pieChart() {

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Yes", 80), new PieChart.Data("No", 20));
		final PieChart pieChart = new PieChart(pieChartData);
		pieChart.setTitle("Should you play this game ?");

		return pieChart;

	}
    
    public LineChart lineChart() {
		// defining the axes
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Enjoy lvl ");
		// creating the chart
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		lineChart.setTitle("Levels Difficulty");
		// defining a series
		XYChart.Series series = new XYChart.Series();
		series.setName("Project Bilet");
		// populating the series with data
		series.getData().add(new XYChart.Data(1, 30));
		series.getData().add(new XYChart.Data(2, 28));
		series.getData().add(new XYChart.Data(3, 26));
		series.getData().add(new XYChart.Data(4, 22));
		series.getData().add(new XYChart.Data(5, 20));
		series.getData().add(new XYChart.Data(6, 18));
		series.getData().add(new XYChart.Data(7, 16));
		series.getData().add(new XYChart.Data(8, 14));
		series.getData().add(new XYChart.Data(9, 10));
		series.getData().add(new XYChart.Data(10, 8));
		series.getData().add(new XYChart.Data(11, 6));
		series.getData().add(new XYChart.Data(12, 4));

		lineChart.getData().add(series);

		return lineChart;
	}
    public void updateData(boolean win, String level, int score, int op){
    	mainPane.setVisible(true);
    	if(win) {
    		//user.setScore(score);
    		ArrayList<User> usuariosTmp = registry.getUsers();
    		usuariosTmp.get(usuariosTmp.size()-1).setScore(score);
    		System.out.println(level);
    		top.add(score, usuariosTmp.get(usuariosTmp.size()-1).getNickname());
    		switch (level) {
			case "lvlPilot.txt":
				if(op==0) usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLONE1,true);
				if(op==1) usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLONE2,true);
				break;
			case "lvlOne1.txt":
				if(op==0) usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLTWO1,true);
				if(op==1) usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLTWO2,true);
				break;
			case "lvlOne2.txt":
				usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLTWO3,true);
				break;
			case "lvlTwo1.txt":
				usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLTHREE1,true);
				break;
			case "lvlTwo3.txt":
				usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLTHREE2,true);
				System.out.println(usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().search(Story.LVLTHREE2).isFree());
				break;
			case "lvlThree1.txt":
				usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLFOUR1,true);
				break;
			case "lvlThree2.txt":
				if(op==0) usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLFOUR2,true);
				if(op==1) usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.LVLFOUR3,true);
				break;
			case "lvlFour3.txt":
				usuariosTmp.get(usuariosTmp.size()-1).getStoryLine().modify(Story.WIN,true);
				break;
			}
    		manageLevels(usuariosTmp.get(usuariosTmp.size()-1));
    	}
    }
    void manageLevels(User usuario) {
    	if(usuario.getStoryLine().search(Story.LVLONE1).isFree()) bLvl11.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.LVLONE2).isFree()) bLvl12.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.LVLTWO1).isFree()) bLvl21.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.LVLTWO2).isFree()) bLvl22.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.LVLTWO3).isFree()) bLvl23.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.LVLTHREE1).isFree()) bLvl31.setDisable(false);
    	if(usuario.getStoryLine().search(Story.LVLTHREE2).isFree()) bLvl32.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.LVLFOUR1).isFree()) bLvl41.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.LVLFOUR2).isFree()) bLvl42.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.LVLFOUR3).isFree()) bLvl43.setDisable(false);	
    	if(usuario.getStoryLine().search(Story.WIN).isFree()) bWin.setDisable(false);
    }
    @FXML
    private Button bPilot;

    @FXML
    private Button bLvl11;

    @FXML
    private Button bLvl42;

    @FXML
    private Button bLvl41;

    @FXML
    private Button bLvl32;

    @FXML
    private Button bLvl31;

    @FXML
    private Button bLvl23;

    @FXML
    private Button bLvl22;

    @FXML
    private Button bLvl21;

    @FXML
    private Button bLvl12;

    @FXML
    private Button bWin;

    @FXML
    private Button bLvl43;
    

    @FXML
    private TextField txtByName;

    @FXML
    private TextField txtByScore;
    
    @FXML
    private Label laUser;

    @FXML
    void searchs(ActionEvent event) throws Exception {
    	
    	String name=txtByName.getText();
    	String score=txtByScore.getText();
    	
    	if(name.equals("")) {
    		int value=Integer.parseInt(score);
    		laUser.setText(registry.binarySearchByScore(value));
    	}
    	else if(score.equals("")) {
    		laUser.setText(registry.binarySearchByName(name));
    	}
    }
}
