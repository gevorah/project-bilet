package model;



public class Character extends Entity {
	private int speed;
	private int jump;

	public Character(int x, int y, int speed, int jump) {
		super(x,y);
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

}
