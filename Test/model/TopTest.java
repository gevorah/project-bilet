package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TopTest {
	Top t;
	void setup2(){
		t = new Top();
		t.add(1000, "Carlos");
		t.add(500, "Finn");
		t.add(1300, "Jeff");
		t.add(1200, "Mata");
		t.add(860, "Elgoku");
	}
	@Test
	void addTest() {
		setup2();
		assertEquals(1000,t.search(1000).getScore(), "Incorrect root score");
		assertEquals(1200,t.search(1200).getScore(), "Incorrect root score");
		assertEquals("Mata",t.search(1200).getNickName(), "Incorrect nick");
		assertEquals(860,t.search(860).getScore(), "Incorrect score");
		assertEquals("Elgoku",t.search(860).getNickName(), "Incorrect nick");
	}
	@Test
	void searchTest() {
		setup2();
		assertEquals(1000,t.search(1000).getScore(), "Incorrect root score");
		assertEquals(1200,t.search(1200).getScore(), "Incorrect root score");
		assertEquals("Mata",t.search(1200).getNickName(), "Incorrect nick");
		assertEquals(860,t.search(860).getScore(), "Incorrect score");
		assertEquals("Elgoku",t.search(860).getNickName(), "Incorrect nick");
	}
	@Test
	void inOrdenTest() {
		setup2();
		assertEquals("Finn500", t.recorridoInorden().split("\n")[0].trim());
		assertEquals("Carlos1000", t.recorridoInorden().split("\n")[2].trim());
		assertEquals("Mata1200", t.recorridoInorden().split("\n")[3].trim());
		assertEquals("Jeff1300", t.recorridoInorden().split("\n")[4].trim());		
	}
}
