package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StoryTest {
	Story st;
	void setup1() {
		st = new Story();
		st.add(50, "Level: Pilot", false);
		st.add(30, "Level: One Down", false);
		st.add(34, "Level: Two Down", false);
		st.add(60, "Level: One Up", false);
		st.add(70, "Level: Two Up", false);
		st.add(56, "Level: Three Up", false);
	}
	@Test
	void addTest() {
		setup1();
		assertEquals(st.getRoot(), st.search(50),"Error no root");
		assertEquals(st.getRoot().getRight(), st.search(60), "Error no line 60");
		assertEquals(st.getRoot().getLeft().getRight(), st.search(34), "Error no line 34");
	}
	@Test
	void searchTest() {
		setup1();
		assertEquals(50, st.search(50).getValue(),"Incorrect root value");
		assertEquals("Level: One Up", st.search(60).getData(), "Incorrect data");
		assertEquals(false, st.search(34).isFree(), "Incorrect condition");
	}
	@Test
	void modifyTest() {
		setup1();
		st.modify(30, true);
		st.modify(60, true);
		st.modify(56, true);
		assertEquals(true, st.search(30).isFree(),"Incorrect condition in 30");
		assertEquals(true, st.search(60).isFree(), "Incorrect condition in 60");
		assertEquals(true, st.search(56).isFree(), "Incorrect condition in 56");
	}
}
