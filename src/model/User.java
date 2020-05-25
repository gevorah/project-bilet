package model;

import javafx.scene.image.Image;

public class User implements Comparable<User> {

	private Image avatar;
	private String nickname;
	private long score;
	private Player player1;
	private Player player2;
	//private LocalDateTime fecha;
	
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
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	@Override
	public int compareTo(User o) {
		if (getNickname().equals(o.getNickname()))		
			return 0;
		else if (getNickname().compareTo(o.getNickname())>0) 
			return 1;
		else 
			return -1;
	}
}
