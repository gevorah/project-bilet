package model;

import javafx.scene.canvas.GraphicsContext;
import ui.GameZone;
import ui.UsserGUI;

public class Character extends Entity {
	private int speed;
	private int jump;
	private Character previous;
	private Character next;
	public Character(int x, int y, String img, int speed, int jump) {
		super(x,y,img);
		this.speed=speed;
		this.jump=jump;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getJump() {
		return jump;
	}
	public void setJump(int jump) {
		this.jump = jump;
	}
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(UsserGUI.images.get("character_1"), 437, 5, 11, 15, super.getX(), super.getY(), 33, 45);
	}
	public void handle() {
		if(GameZone.left) super.setX(super.getX()-speed);
		if(GameZone.right) super.setX(super.getX()+speed);
		if(GameZone.up) super.setY(super.getY()-speed);
	}
}
