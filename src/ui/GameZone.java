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
import model.User;


public class GameZone {
	private Canvas canvas;
	private GraphicsContext graphics;
	private Scene scene;
	private HandleKeyPressed hkp;
	private HandleKeyReleased hkr;
	private User user;
	public static boolean up;
	public static boolean left;
	public static boolean right;
	public GameZone(User user, Scene scene) {
		canvas = new Canvas(700,600);
		graphics = canvas.getGraphicsContext2D();
		this.scene = scene;
		this.user = user;
		hkp = new HandleKeyPressed();
		hkr = new HandleKeyReleased();
	}
	public void gameLoop() {
		AnimationTimer at = new AnimationTimer() {
			@Override
			public void handle(long now) {
				gameUpdate();
				draw();
			}
		};
		at.start();
	}
	public void gameUpdate() {
		user.getPlayer1().handle();
		user.getPlayer2().handle();
	}
	public void draw() {
		graphics.drawImage(new Image("file:imgs\\2020-04-19 (5).png"), 0, 0);
		user.getPlayer1().draw(graphics);
		user.getPlayer2().draw(graphics);
	}
	public void manager() {
		scene.setOnKeyPressed(hkp);
		scene.setOnKeyReleased(hkr);
	}
	private class HandleKeyPressed implements EventHandler<KeyEvent> {
		public HandleKeyPressed() {}
		@Override
		public void handle(KeyEvent event) {
			switch (event.getCode().toString()) {
			case "UP":
				up = true;
				break;
			case "LEFT":
				left = true;
				break;
			case "RIGHT":
				right = true;
				break;
			}
		}
	}
	private class HandleKeyReleased implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent event) {
			switch (event.getCode().toString()) {
			case "UP":
				up = false;
				break;
			case "LEFT":
				left = false;
				break;
			case "RIGHT":
				right = false;
				break;
			}
		}
		
	}
	public Canvas getCanvas() {
		return canvas;
	}
}
