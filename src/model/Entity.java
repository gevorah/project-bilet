package model;

import javafx.scene.image.Image;

public abstract class Entity {
	private int x,y;
	private Image pj;
	private int life;
	public Entity(int x, int y, Image pj, int life) {
		super();
		this.x = x;
		this.y = y;
		this.pj = pj;
		this.life = life;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Image getPj() {
		return pj;
	}
	public void setPj(Image pj) {
		this.pj = pj;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
}
