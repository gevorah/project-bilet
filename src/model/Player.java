package model;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
