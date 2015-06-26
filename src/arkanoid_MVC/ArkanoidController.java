package arkanoid_MVC;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArkanoidController extends JPanel {
	ArkanoidView view;
	Raqueta raqueta;
	Bola bola1;
	Bola bola2;

   
	public ArkanoidController(Bola bola1, Bola bola2, Raqueta raqueta) {
		ArkanoidView view = new ArkanoidView(bola1, bola2, raqueta, this);
		this.raqueta = raqueta;
		this.bola1 = bola1;
		this.bola2 = bola2;
		
		/*
		JFrame frame = new JFrame("Mini Tennis");
		raqueta.registerObserver((ModelObserver)view);
		frame.add(view);
		frame.setSize(400, 580);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}

	public void move() {
		
		if (raqueta.getBounds().intersects(bola1.getBounds())) {collision(bola1);} 
		if (raqueta.getBounds().intersects(bola2.getBounds())) {collision(bola2);}
	
		raqueta.move();
		
		/*if ((bola1.gameOver()) || (bola2.gameOver())) {
			System.out.println("perdiiiiiiiiiiiiiiiiiii");
			//view.pausa();
			//raqueta.removeObserver((ModelObserver)this);
			view.terminarJuego();
			*/
		//	JOptionPane.showMessageDialog(this, "your score is: " + (bola2.getScore() + bola1.getScore()),"Game Over", JOptionPane.YES_NO_OPTION);
		//	System.exit(ABORT);
			//sonido.GAMEOVER.play();
		//}
	}
	
	public void tema() {
		//model.tema();
		//view.disableStartMenuItem();
		//view.enableStopMenuItem();
	}
	
	public void released() {
		raqueta.setXA(0);
		}

	public void moveLeft() {
		raqueta.setXA(-8);
	
		/*model.tema();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
		*/
		
	}
	public void moveRigth() {
		raqueta.setXA(8);
		/*model.tema();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
		*/
	}


	
	void collision(Bola bola){ 
		bola.incrementarScore(); 
		if (((raqueta.getPosX() + (raqueta.getAncho() / 2) - 1) > bola.getPosX()) && (bola.getXA() == 1))	
			bola.setXA(-1);
		if (((raqueta.getPosX() + (raqueta.getAncho() / 2) - 1) < bola.getPosX()) && (bola.getXA() == -1))
			bola.setXA(1); //CONTROLER
		bola.setYA(-1); //CONTROLER
		//y = game.raqueta.getTopY() - DIAMETER; //MODEL PUEDE Q NO HAGA FALTA
	}

	

	public void pausa() {
		raqueta.pausa();
		bola1.pausa();
		bola2.pausa();
				
	}
								
	
}

