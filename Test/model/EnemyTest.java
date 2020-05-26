package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnemyTest {

	@Test
	public void test() {
		Enemy pj = new Enemy(0, 0, null, 1, 1);
		assertEquals(0, pj.getX(), "Incorrect value of X");
		assertEquals(0, pj.getY(), "Incorrect value of Y");;
		assertEquals(1, pj.getDirection(), "Incorrect direction");
		assertEquals(1, pj.getJump(), "Incorrect jump");
	}

}
