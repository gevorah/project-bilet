package model;

public abstract class Entity {
	private int x,y;
	private String img;
	public Entity(int x, int y, String img) {
		this.x = x;
		this.y = y;
		this.img = img;
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
}
