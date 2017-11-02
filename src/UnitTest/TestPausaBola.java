package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import arkanoid_MVC.ArkanoidController;
import arkanoid_MVC.Bola;
import arkanoid_MVC.Raqueta;

public class TestPausaBola {

	@Test
	public void test() throws InterruptedException {
		Bola bola1 = new Bola(100,120);
		Bola bola2 = new Bola(30,60);
		Raqueta raq = new Raqueta();
		ArkanoidController controller = new ArkanoidController(bola1, bola2, raq);
		
		controller.pausa();
		int pos1x = bola1.getPosX();
		int pos2x = bola2.getPosX();
		Thread.sleep(20);
		assertEquals(pos1x, bola1.getPosX());
		assertEquals(pos2x, bola2.getPosX());
		
	
		controller.pausa();
		Thread.sleep(20);
		assertNotEquals(pos1x, bola1.getPosX());
		assertNotEquals(pos2x, bola2.getPosX());
	}
}
