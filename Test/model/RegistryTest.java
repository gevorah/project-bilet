package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customExceptions.RepeatUserException;
import customExceptions.invalidInformationException;

class RegistryTest {
	Registry r;
	void setup3() throws Exception {
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
		setup3();
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
		setup3();
		try{ 
			r.findUser("Adam");
		} catch (RepeatUserException e) {
			System.err.println("FindUserTest: RepeatUserException caught");
		}
	}
	@Test 
	void bubbleSortMinToMaxTest() throws Exception {
		setup3();
		r.ordernarPuntajeMinToMax();
		assertEquals(50, r.getUsers().get(0).getScore(), "No sorted");
		assertEquals(70, r.getUsers().get(1).getScore(), "No sorted");
		assertEquals(100, r.getUsers().get(2).getScore(), "No sorted");
	}
	@Test 
	void insertionSortMaxToMinTest() throws Exception {
		setup3();
		r.ordenarPuntajeMaxToMin();
		assertEquals(100, r.getUsers().get(0).getScore(), "No sorted");
		assertEquals(70, r.getUsers().get(1).getScore(), "No sorted");
		assertEquals(50, r.getUsers().get(2).getScore(), "No sorted");
	}
	@Test 
	void sortByNombreAtoZTest() throws Exception {
		setup3();
		r.sortByNombreAtoZ();
		assertEquals("Adam", r.getUsers().get(0).getNickname(), "No sorted");
		assertEquals("Jack", r.getUsers().get(1).getNickname(), "No sorted");
		assertEquals("Mike", r.getUsers().get(2).getNickname(), "No sorted");
	}
	@Test 
	void sortByNombreZtoATest() throws Exception {
		setup3();
		r.sortByNombreZtoA();
		assertEquals("Mike", r.getUsers().get(0).getNickname(), "No sorted");
		assertEquals("Jack", r.getUsers().get(1).getNickname(), "No sorted");
		assertEquals("Adam", r.getUsers().get(2).getNickname(), "No sorted");
	}
	@Test 
	void sortByScoreNickTest() throws Exception {
		setup3();
		r.addUser(null, "Fer");
		r.getUsers().get(3).setScore(50);
		r.sortByScoreNick();
		assertEquals(100, r.getUsers().get(0).getScore(), "No sorted score");
		assertEquals("Jack", r.getUsers().get(0).getNickname(), "No sorted");
		assertEquals(70, r.getUsers().get(1).getScore(), "No sorted score");
		assertEquals("Adam", r.getUsers().get(1).getNickname(), "No sorted");
		assertEquals(50, r.getUsers().get(2).getScore(), "No sorted score");
		assertEquals("Fer", r.getUsers().get(2).getNickname(), "No sorted");
		assertEquals(50, r.getUsers().get(3).getScore(), "No sorted score");
		assertEquals("Mike", r.getUsers().get(3).getNickname(), "No sorted");
	}
	@Test
	void binarySearchByScoreTest() throws Exception {
		setup3();
		assertTrue(r.binarySearchByScore(0).equals("user not found"),"User found");
		assertTrue(r.binarySearchByScore(50).equals("Mike , puntaje: 50."),"User found");
	}
	@Test
	void binarySearchByNickTest() throws Exception {
		setup3();
		assertTrue(r.binarySearchByName("LoL").equals("user not found"),"User found");
		assertTrue(r.binarySearchByName("Mike").equals("Mike , puntaje: 50."),"User found");
	}
}
