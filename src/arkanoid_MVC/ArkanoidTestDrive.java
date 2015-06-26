package arkanoid_MVC;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class ArkanoidTestDrive {
	public static void main(String[] args) throws InterruptedException{
		Bola bola1 = new Bola(0,0);
		Bola bola2 = new Bola(190,150);
		Raqueta raqueta = new Raqueta();
		ArkanoidController controller = new ArkanoidController(bola1,bola2,raqueta);
		//ArkanoidView view = new ArkanoidView(bola1, bola2, raqueta);
	}
}

