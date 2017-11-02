package UnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import arkanoid_MVC.ArkanoidController;
import arkanoid_MVC.Bola;
import arkanoid_MVC.Raqueta;


public class TestCollision {

	@Test
	public void test() {
		Bola bola1 = new Bola(100,120);
		Bola bola2 = new Bola(30,60);
		Raqueta raq = new Raqueta();
		ArkanoidController controller = new ArkanoidController(bola1, bola2, raq);
		
		int score1 = bola1.getScore();
		controller.collision(bola1);
		assertEquals((score1+1), bola1.getScore());
		assertEquals(bola1.getYA(), -1);
		assertTrue(bola1.getPosY() >= (raq.getTopY() - bola1.getDiameter()));
	}

}
