package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CharacterTest {

	@Test
	void characterTest() {
		Character pj = new Character(0, 0, null, 10, 10, "Jump");
		assertEquals(0, pj.getX(), "Incorrect value of X");
		assertEquals(0, pj.getY(), "Incorrect value of Y");
		assertEquals(10, pj.getLife(), "Incorrect lifes");
		assertEquals(10, pj.getSpeed(), "Incorrect speed");
		assertEquals(16, pj.getJump(), "Incorrect jump");
	}

}
