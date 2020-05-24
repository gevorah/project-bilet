package model;

import java.util.ArrayList;

import customExceptions.RepeatUserException;
import customExceptions.invalidInformationException;
import javafx.scene.image.Image;
import model.User;

public class Registry {

	private ArrayList<User> users;

	public Registry() {
		users = new ArrayList<User>();
	}

	public void addUser(Image avatar, String nickname) throws invalidInformationException, RepeatUserException {

		findUser(nickname);

		if (!nickname.trim().equals("")) {
			users.add(new User(avatar, nickname));
		} else {
			throw new invalidInformationException();
		}
	}

	public void findUser(String name) throws RepeatUserException {
	 
	  for (int i = 0; i < users.size(); i++) { 
		  
	  
		  if (users.get(i).getNickname().equals(name)) {
	  
			  throw new RepeatUserException();
		  } 
	  }
	}  

	

	public ArrayList<User> getUsers() {
		return users;
	}

	public void ordernarPuntajeMinToMax() {
		
		

		User userTemp;

		for (int i = 0; i < users.size(); i++) {
			for (int j = 1; j < (users.size() - i); j++) {

				if (users.get(j - 1).getScore() < users.get(j).getScore()) {
					userTemp = users.get(j - 1);
					users.set(j - 1, users.get(j));
					users.set(j, userTemp);

				}

			}
		}

	}
	
/*	public void ordenarPuntajeMaxToMin() {
		
		User userTemp;
		
		for (int i = 0 ; i<users.size();i++) {
			
			userTemp = users.get(i);
			int j = i-1;
			
			while( (j >-1)&&(users.get(j).getScore()>  )) {
				
			}
			


			
		}
		
	}*/

}