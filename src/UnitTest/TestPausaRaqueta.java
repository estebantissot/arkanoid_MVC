package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import arkanoid_MVC.ArkanoidController;
import arkanoid_MVC.Bola;
import arkanoid_MVC.Raqueta;

public class TestPausaRaqueta {

	@Test
	public void test() {
		Bola bola1 = new Bola(100,120);
		Bola bola2 = new Bola(30,60);
		Raqueta raq = new Raqueta();
		ArkanoidController controller = new ArkanoidController(bola1, bola2, raq);
		
		controller.pausa();
		int pos1x = raq.getPosX();
		controller.moveRigth();
		controller.move();
		controller.move();
		assertEquals(pos1x, raq.getPosX());
		controller.moveLeft();
		controller.move();
		assertEquals(pos1x, raq.getPosX());
		
		
		int pos2x = raq.getPosX();
		controller.pausa();
		controller.moveRigth();
		controller.move();
		controller.move();
		controller.move();
		assertNotEquals(pos2x, raq.getPosX());
		controller.moveLeft();
		controller.move();
		assertNotEquals(pos2x, raq.getPosX());;
	}

}
