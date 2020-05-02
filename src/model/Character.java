package model;

import javafx.scene.image.Image;

public class Character extends Entity {
	private int speed;
	private int jump;
	private String skill;
	public Character(float x, float y, Image pj, int life, int speed, int jump, String skill) {
		super(x,y,pj,life);
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
