package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import arkanoid_MVC.Bola;

public class UnitTest {

	@Test
	public void test() {
		
		Bola bola1 = new Bola(190, 120);
		Bola bola2 = new Bola(420, 100);
		int pos1x = bola1.getPosX();
		int pos2x = bola2.getPosX();
		assertTrue(pos1x<400);
		assertTrue(pos2x<400);
	}
}
