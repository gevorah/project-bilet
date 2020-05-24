package model;

import javafx.scene.canvas.GraphicsContext;
import ui.UsserGUI;

public class Tile {
	private int posX,posY;
	private int drawX,drawY;
	public Tile(int drawX, int drawY, int type) {
		this.drawX=drawX;
		this.drawY=drawY;
		switch (type) {
		case 0:
			this.posX=0;
			this.posY=49;
			break;
		case 1:
			this.posX=96;
			this.posY=0;
			break;
		case 2:
			this.posX=272;
			this.posY=64;
			break;
		case 3:
			this.posX=192;
			this.posY=64;
			break;
		}
	}
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(UsserGUI.images.get("tilemap"), posX, posY, 48, 48, drawX, drawY, 96, 96);
	}
}
