package model;

import java.io.Serializable;

import javafx.scene.image.Image;

public abstract class Entity extends GameOb implements Serializable{
	
	private transient Image pj;
	public Entity(int x, int y, Image pj) {
		super(x,y);
		this.pj = pj;
		
	}
	@Override
	public int getX() {
		return super.getX();
	}
	@Override
	public void setX(int x) {
		super.setX(x);
	}
	@Override
	public int getY() {
		return super.getY();
	}
	@Override
	public void setY(int y) {
		super.setY(y);
	}
	public Image getPj() {
		return pj;
	}
	public void setPj(Image pj) {
		this.pj = pj;
	}
}
