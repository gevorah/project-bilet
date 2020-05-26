package model;

import javafx.scene.image.Image;

public class Enemy extends Entity implements EnemyInterface  {
	
	@Override
	public int getDirection() {
		return direction;
	}

	@Override
	public int getJump() {
		return jump;
	}

	@Override
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	@Override
	public void setJump(int jump) {
		this.jump = jump;
	}

	private int direction;
	private int jump;
	
	public Enemy(int x, int y, Image pj, int direction, int jump) {
		
		super(x, y, pj);
		this.direction = direction;
		this.jump = jump;
	}
	
	@Override
	public void setX (int x) {
		super.setX(x);
	}
	
	@Override
	public void setY (int y) {
		super.setY(y);
	}
	
	@Override
	public int getX() {
		return super.getX();
	}
	
	@Override
	public int getY() {
		return super.getY();
	}

}
