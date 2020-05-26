package model;

import java.io.Serializable;

public abstract class GameOb implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y ;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public GameOb(int x, int y) {
		this.x =x;
		this.y = y;
				
	}
	
	
	

}
