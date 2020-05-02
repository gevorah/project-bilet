package model;

import javafx.scene.image.Image;

public abstract class Entity {
	private float x,y;
	private Image pj;
	private int life;
	/**
	 * @param x
	 * @param y
	 * @param pj
	 * @param life
	 */
	public Entity(float x, float y, Image pj, int life) {
		super();
		this.x = x;
		this.y = y;
		this.pj = pj;
		this.life = life;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
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
