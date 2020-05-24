package model;

import java.util.ArrayList;
import java.util.List;

import customExceptions.invalidInformationException;
import javafx.scene.image.Image;
import model.User;

public class Registry {
	
	
	
	private ArrayList<User> users;
	
	public Registry() {
		users=new ArrayList<User>();
	}
	public void addUser(Image avatar, String nickname) throws invalidInformationException {
		if(nickname.trim().equals("")&& avatar==null){
			throw new invalidInformationException();
		}
		else {
		users.add(new User(avatar, nickname));
		}
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public void ordernarPuntajeMin(){
		
		
		User userTemp;
		int puntTemp = 0;
		
		
		for (int i = 0; i<users.size();i++) {
			for (int j=1; j<(users.size()-i);j++) {
				
				if(users.get(j-1).getScore() < users.get(j).getScore()  ) {
				userTemp =users.get(j-1);
				users.set(j+1,users.get(j));
				
				
				}
				
			}
		}
		
		
		
	}
	
}