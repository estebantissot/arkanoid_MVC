package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import arkanoid_MVC.ArkanoidController;
import arkanoid_MVC.Bola;
import arkanoid_MVC.Raqueta;

public class TestModelo {

	@Test
	public void test() {
		Bola bola1 = new Bola(100,120);
		Bola bola2 = new Bola(30,60);
		Raqueta raq = new Raqueta();
		ArkanoidController controller = new ArkanoidController(bola1, bola2, raq);
		
		
		controller.moveLeft();
		controller.move();
		int pos1x = raq.getPosX();
		assertTrue(pos1x>=0);
		
		raq.setPosX(300);
		controller.moveRigth();
		controller.move();
		controller.move();
		int pos2x = raq.getPosX();
		assertTrue(pos2x<=400);
	}

}
