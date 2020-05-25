package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void userTest() {
		User user = new User(null,"Nate");
		assertEquals(null, user.getAvatar(),"");
		assertEquals("Nate", user.getNickname(),"Incorrect nick");
	}

}
