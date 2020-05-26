package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import customExceptions.RepeatUserException;
import customExceptions.invalidInformationException;
import javafx.scene.image.Image;
import model.User;


public class Registry implements Serializable {

	private ArrayList<User> users;
	
	
	//private transient BufferedWriter bw;
	private User head;

	public Registry() {
		users = new ArrayList<User>();
	}
	
	public void add(Image a,String nickname) throws Exception {
		head = recursiveAdd(head,a,nickname);
	}
	private User recursiveAdd(User current, Image a, String nickname) throws Exception {
		if(current==null) {
			return new User(a,nickname);
		} else {
			current.setNext(recursiveAdd(current.getNext(),a,nickname));
		}
		return current;
	}
	public User search(String nickname) {
		return recursiveSearch(head,nickname);
	}
	private User recursiveSearch(User current, String nickname) {
		if(current==null) {
			return null;
		} else if(current.getNickname().equals(nickname)) {
			return current;
		}
		return recursiveSearch(current.getNext(),nickname);
	}
	public void delete(String nick) {
		
		User current = head;
		
		if (current != null && current.getNickname().equals(nick)) {
			
			head = current.getNext();
			
		}
		else if(current.getNext() != null && current.getNext().getNickname().equals(nick)){
			
			current.setNext(current.getNext().getNext());
			
			
		}else if(current != null && current.getNext() != null) {
			recursiveDelete(current, nick);
		}
	}
	
	private void recursiveDelete(User current, String nick) {
		
		
		if (current.getNext() != null && current.getNext().getNickname().equals(nick)) {
			
			current.setNext(current.getNext().getNext());
			
			
		}else if (current.getNext()!= null) {
			
			recursiveDelete (current.getNext(),nick);
			
		}
		
		
	
	}
	
	public void toArrayList() {
		User temp = head;
		users.removeAll(users);
		while(temp!=null) {
			users.add(temp);
		}
	}

	public void addUser(Image avatar, String nickname) throws invalidInformationException, RepeatUserException {

		findUser(nickname);

		if (!nickname.trim().equals("")) {
			try {
				users.add(new User(avatar, nickname));
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	
		// Burbuja sort 1
		
		

		User userTemp;

		for (int i = 0; i < users.size(); i++) {
			for (int j = 1; j < (users.size() - i); j++) {

				if (users.get(j - 1).getScore()> users.get(j).getScore()) {
					userTemp = users.get(j - 1);
					users.set(j - 1, users.get(j));
					users.set(j, userTemp);

				}

			}
		}

	}
	
	public void ordenarPuntajeMaxToMin() {
		
		//Insertion sort 1
		
		User userTemp;
		
		for (int i = 0 ; i<users.size();i++) {
			
			userTemp = users.get(i);
			int j = i-1;
			
			while( (j >-1)&&(users.get(j).getScore() < userTemp.getScore())) {
				
				users.set(j+1,users.get(j));
				j--;
				
			
			}
			
			users.set(j+1,userTemp);
		
		}
		
	}
	
	

	public void sortByNombreAtoZ() {
		User userTemp;

		for (int i = 0; i < users.size(); i++) {
			for (int j = 1; j < (users.size() - i); j++) {

				if (users.get(j - 1).compareTo(users.get(j))>0) {
					userTemp = users.get(j - 1);
					users.set(j - 1, users.get(j));
					users.set(j, userTemp);

				}

			}
		}
	}
	public void sortByNombreZtoA() {
		
		//Selection Sort
		User userTemp;
		int temp;
		
		for (int i = 0 ; i< users.size()-1 ; i++) {
			temp = i;
			for (int j = i+1 ; j< users.size() ; j++ ) {
				if(users.get(j).compareTo(users.get(temp)) > 0) {
					temp = j;
				}
			}
			
			userTemp = users.get(temp);
			users.set(temp, users.get(i));
			users.set(i, userTemp);
		}
		
		
		
		
		
		
		
	}
	
	public void sortByScoreNick() {
		Comparator<User> cu = new Comparator<User>(){
			@Override
			public int compare(User o1, User o2) {
				if(o1.getScore()==o2.getScore()) {
					if (o1.getNickname().equals(o2.getNickname()))		
						return 0;
					else if (o1.getNickname().compareTo(o2.getNickname())<0) 
						return 1;
					else 
						return -1;
				} else if(o1.getScore()<o2.getScore()) {
					return 1;
				} else
					return -1;
			}
			
		};
		users.sort(cu);
	}
	public static void main(String[] args) throws Exception {
		Registry r = new Registry();
		r.addUser(null, "Jack");
		r.users.get(0).setScore(10);
		r.addUser(null, "Mike");

		r.users.get(1).setScore(100);
		r.addUser(null, "Adam");

		r.users.get(2).setScore(20);
		//r.sortByNombreAtoZ();
		//System.out.println(r.users.get(0).getNickname());
		
		System.out.println(r.binarySearchByName("Jack"));
		
	}
	
	
	public  String binarySearchByName (String name) throws Exception {
		
		sortByNombreAtoZ();
		
		User tmp=new User(null, name);
			int min = 0;
			int max = users.size();
			String user="";
			while (min <= max && user.equals("")) {

				int m = (min + max) / 2;

				if (users.get(m).compareTo(tmp) == 0) {
					user= users.get(m).getNickname() + " , puntaje: "+ users.get(m).getScore()+".";
				} else if (users.get(m).compareTo(tmp) ==1) {
					max = m - 1;
				} else if (users.get(m).compareTo(tmp) ==-1) {
					min = m + 1;
				}
			}

			return user;
		}
	
}