package model;

import javafx.scene.image.Image;

public class User {

	private Image avatar;
	private String nickname;
	private long score;
	private Player player1;
	public User(Image avatar, String nickname) {
		this.avatar = avatar;
		this.nickname = nickname;
		this.score = 0;
	}
	public Image getAvatar() {
		return avatar;
	}
	public String getNickname() {
		return nickname;
	}
	public long getScore() {
		return score;
	}
	public void setAvatar(Image avatar) {
		this.avatar = avatar;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}	
}
