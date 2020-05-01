package model;

import javafx.scene.image.Image;

public class User {

	private Image pic;
	private String nickname;
	private long score;
	private User nextUser;
	
	public User(String nickname) {
		this.pic = new Image("default.jpg");
		this.nickname = nickname;
		this.score = 0;
	}
	public User(Image pic, String nickname) {
		this.pic = pic;
		this.nickname = nickname;
		this.score = 0;
	}
	public Image getPic() {
		return pic;
	}
	public String getNickname() {
		return nickname;
	}
	public long getScore() {
		return score;
	}
	public void setPic(Image pic) {
		this.pic = pic;
	}
	public User getNextUser() {
		return nextUser;
	}
	

	
}
