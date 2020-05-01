package model;

import javafx.scene.image.Image;

public class Player {
	public Image picture;
	private String nickname;
	private int score;
	public Player(Image picture, String nickname, int score) {
		this.picture=picture;
		this.nickname=nickname;
		this.score=score;
	}
	public Image getPicture() {
		return picture;
	}
	public String getNickname() {
		return nickname;
	}
	public int getScore() {
		return score;
	}
}
