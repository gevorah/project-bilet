package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customExceptions.RepeatUserException;
import customExceptions.invalidInformationException;

class RegistryTest {
	Registry r;
	void setup1() throws Exception {
		r = new Registry();
		r.addUser(null, "Jack");
		r.getUsers().get(0).setScore(100);
		r.addUser(null, "Mike");
		r.getUsers().get(1).setScore(50);
		r.addUser(null, "Adam");
		r.getUsers().get(2).setScore(70);
	}
	@Test
	void addUserTest() throws Exception {
		setup1();
		try {
			r.addUser(null, "Rock");
			r.addUser(null, " ");
		} catch (invalidInformationException e) {
			System.err.println("AddUserTest: invalidInformationException caught");
		} 
		try{ 
			r.addUser(null, "Jack");
		} catch (RepeatUserException e) {
			System.err.println("AddUserTest: RepeatUserException caught");
		}
	}
	@Test
	void findUserTest() throws Exception {
		setup1();
		try{ 
			r.findUser("Adam");
		} catch (RepeatUserException e) {
			System.err.println("FindUserTest: RepeatUserException caught");
		}
	}
	@Test 
	void bubbleSortMinToMaxTest() throws Exception {
		setup1();
		r.ordernarPuntajeMinToMax();
		assertEquals(50, r.getUsers().get(0).getScore(), "No sorted");
		assertEquals(70, r.getUsers().get(1).getScore(), "No sorted");
		assertEquals(100, r.getUsers().get(2).getScore(), "No sorted");
	}
	@Test 
	void insertionSortMaxToMinTest() throws Exception {
		setup1();
		r.ordenarPuntajeMaxToMin();
		assertEquals(100, r.getUsers().get(0).getScore(), "No sorted");
		assertEquals(70, r.getUsers().get(1).getScore(), "No sorted");
		assertEquals(50, r.getUsers().get(2).getScore(), "No sorted");
	}
}
