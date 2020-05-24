package model;

public class Enemy extends Entity  {
	
	private int direction;
	private int jump;
	
	public Enemy(int x, int y, int dir, int jum) {
		
		super(x,y);
		
		direction = dir;
		jump = jum;
		
		
	}
	
	

}
