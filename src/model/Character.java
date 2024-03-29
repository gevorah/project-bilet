package model;

import java.awt.Rectangle;
import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import ui.UsserGUI;

public class Character extends Entity implements Serializable {
	private int speed;
	private int jump;
	private String skill;
	public Character(int x, int y, Image pj, int speed, int jump, String skill) {
		super(x,y,pj);
		this.speed=speed;
		this.jump=jump;
		this.skill=skill;
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
}
