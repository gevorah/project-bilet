package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodoAbbTest {
	@Test
	void test() {
		NodoABB root = new NodoABB(1000, "Art");
		root.setRight(new NodoABB(1200, "Lem"));
		root.setLeft(new NodoABB(500, "Paul"));
		assertEquals("Art", root.getNickName(), "Incorrect root nickname");
		assertEquals("Lem", root.getRight().getNickName(), "Incorrect nickname");
		assertEquals(500, root.getLeft().getScore(), "Incorrect root nickname");
	}

}
