package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import javafx.scene.image.Image;

public class User implements Comparable<User>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient Image avatar;
	private String nickname;
	private long score;
	private User next;
	private Story storyLine;
	private Player player1;
	
	
	
	private final String FILE_NEW = "data/lvls.txt";
	//private LocalDateTime fecha;
	
	public User(Image avatar, String nickname) throws Exception {
		this.avatar = avatar;
		this.nickname = nickname;
		this.score = 0;
		storyLine = new Story();
		newStoryLine();
	}
	public void newStoryLine() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(FILE_NEW)));
		String line = null;
		line = br.readLine();
		String data[] = line.split(",");
		for(String a:data) {
			String tmp[] = a.split(":");
			storyLine.add(Integer.parseInt(tmp[0]), tmp[1], Boolean.parseBoolean(tmp[2]));
		}
		br.close();
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

	
	public void setScore(long score) {
		this.score = score;
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
	public User getNext() {
		return next;
	}
	public void setNext(User next) {
		this.next = next;
	}
	public Story getStoryLine() {
		return storyLine;
	}
	public void setStoryLine(Story storyLine) {
		this.storyLine = storyLine;
	}
	
}
