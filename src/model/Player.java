package model;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;

public class Player implements Serializable {
	private Character pj;
	public Player(Character pj) {
		this.pj = pj;
	}
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(pj.getPj(), pj.getX(), pj.getY());
	}
	
	public Character getPj() {
		return pj;
	}
	public void setPj(Character pj) {
		this.pj = pj;
	}
}
