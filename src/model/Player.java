package model;

import javafx.scene.canvas.GraphicsContext;
import ui.GameZone;

public class Player {
	private Character pj;
	public Player(Character pj) {
		this.pj = pj;
	}

	
	public Character getPj() {
		return pj;
	}
	public void setPj(Character pj) {
		this.pj = pj;
	}
}
