package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void test() {
		Player player = new Player(new Character(0, 0, null, 10, 10, "Jump"));
		assertTrue(player!=null,"No player");
		assertTrue(player.getPj().getSkill().equals("Jump"),"The player character skill is not equal");
		assertTrue(player.getPj().getX()==0,"The player character X is not equal");
		assertTrue(player.getPj().getPj()==null,"The player character image is not equal");
	}

}
