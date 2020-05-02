package model;

import javafx.scene.image.Image;

public class User {

	private Image avatar;
	private String nickname;
	private long score;
	private User nextUser;
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
	public User getNextUser() {
		return nextUser;
	}
	public void setNextUser(User nextUser) {
		this.nextUser = nextUser;
	}
	
	

	
}
