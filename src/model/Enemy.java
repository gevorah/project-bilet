package model;

public class Enemy extends Entity  {
	
	private int direction;
	private int jump;
	
	public Enemy(int x, int y, int dir, int jum, String img) {
		
		super(x,y, img);
		
		direction = dir;
		jump = jum;
		
		
	}
	
	

}
