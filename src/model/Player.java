package model;

import javafx.scene.canvas.GraphicsContext;
import ui.GameZone;

public class Player {
	private Character pj;
	public Player(Character pj) {
		this.pj = pj;
	}
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(pj.getPj(), pj.getX(), pj.getY());
	}
	public void handle() {
		if(GameZone.left) pj.setX(pj.getX()-pj.getSpeed());
		if(GameZone.right) pj.setX(pj.getX()+pj.getSpeed());
		if(GameZone.up) pj.setY(pj.getY()-pj.getJump());
	}
	public Character getPj() {
		return pj;
	}
	public void setPj(Character pj) {
		this.pj = pj;
	}
}
