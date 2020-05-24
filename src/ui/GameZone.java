package ui;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import model.Player;
import model.PrincipalClass;
import model.Character;
import model.Tile;
import model.User;

public class GameZone extends Canvas {
	private GraphicsContext graphics;
	private PrincipalClass pc;
	private Player player1,player2;
	private Character character;
	private ArrayList<Tile> tiles;
	public static boolean up;
	public static boolean down;
	public static boolean left;
	public static boolean right;
	public GameZone() {
		super(960,576);
		graphics = super.getGraphicsContext2D();
		pc = new PrincipalClass("maps/lvlTmp.txt");
		character = new Character(0,400,"character_1",10,10);
		inicializarTiles();
	}
	void loop() {
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				update();
				draw();
			}
		}.start();
	}
	void update() {
		character.handle();
	}
	void draw() {
		graphics.drawImage(UsserGUI.images.get("fondo"), 0, 0);
		for(Tile a:tiles) {
			a.draw(graphics);
		}
		character.draw(graphics);
	}
	void inicializarTiles() {
		tiles = new ArrayList<Tile>();
		int[][] tilemap = pc.getMatrix();
		for(int i=0;i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				switch (tilemap[i][j]) {
				case 0:
					
					break;
				case 1:
					this.tiles.add(new Tile(j*96, i*96, 1));
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				} 
			}
		}
	}
}
