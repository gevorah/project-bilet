package model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Registry {
	
	private List<User> users;
	
	public Registry() {
		users=new ArrayList<>();
	}
	public void addUser(Image avatar, String nickname) {
		users.add(new User(avatar, nickname));
	}
	public List<User> getUsers() {
		return users;
	}
	
}