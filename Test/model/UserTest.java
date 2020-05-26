package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void userTest() throws Exception {
		User user = new User(null,"Nate");
		assertEquals(null, user.getAvatar(),"Incorrect avatar");
		assertEquals("Nate", user.getNickname(),"Incorrect nick");
		user.setNext(new User(null,"Adam"));
		assertEquals("Adam", user.getNext().getNickname(),"Incorrect next nick");
		user.setScore(1000);
		assertEquals(1000, user.getScore(), "Incorrect score");
	}

}
