package model;

import javafx.scene.image.Image;

public class Enemy extends Entity  {
	
	private int direction;
	private int jump;
	
	public Enemy(int x, int y, Image pj, int life, int direction, int jump) {
		
		super(x, y, pj, life);
		this.direction = direction;
		this.jump = jump;
	}
	
	/*public Enemy(int x, int y, int dir, int jum, String img) {
		
		super(x,y, img);
		
		direction = dir;
		jump = jum;
		
		
	}*/
	
	
	
	

}
