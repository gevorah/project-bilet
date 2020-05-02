package model;

import javafx.scene.image.Image;

public class Registry {
	
	private User firtsUser;

	public User getFirtsUser() {
		return firtsUser;
	}

	public void setFirtsUser(User firtsUser) {
		this.firtsUser = firtsUser;
	}

	public Registry() {
			
		firtsUser=null;
		
	}

	public void addUser(Image pic, String nickname) {
		User tmp = new User(pic, nickname);

		if (firtsUser == null) {
			setFirtsUser(tmp);
			firtsUser = getFirtsUser();
			
		} else {
			tmp.setNextUser(firtsUser);;
			setFirtsUser(tmp);;
			firtsUser = getFirtsUser();
		}
}
}