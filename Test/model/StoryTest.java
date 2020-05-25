package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StoryTest {
	Story st;
	void setup1() {
		st = new Story();
		st.add(50, "Level: Pilot");
		st.add(30, "Level: One Down");
		st.add(34, "Level: Two Down");
		st.add(60, "Level: One Up");
		st.add(70, "Level: Two Up");
		st.add(56, "Level: Three Up");
	}
	@Test
	void addTest() {
		setup1();
		assertEquals("Level: Pilot", st.search(50),"Error no root");
		assertEquals("Level: One Up", st.search(60), "Error next level");
		assertEquals("Level: Two Down", st.search(34), "No level");
	}
	@Test
	void deleteTest() {
		setup1();
		st.delete(60);
		assertEquals(null, st.search(60), "Value 60 exist");
		st.delete(50);
		assertEquals(null, st.search(50), "The root value 50 exist");
	}
}
