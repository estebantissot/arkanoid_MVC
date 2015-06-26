package arkanoid_MVC;

import java.awt.Rectangle;
import arkanoid_MVC.Model;
import java.util.*;


public class Bola extends Model implements Runnable {
	private static final int DIAMETER = 20;
	private int score = 0;
//	boolean loose;
	Thread thread;

	public Bola(int x, int y) {
		super(x,y,1,1);
		thread = new Thread(this);
		thread.start();
	//	loose = false;
	}

	
	public void incrementarScore() {score ++;}
	
	public int getScore() {return score;}
	
	public Rectangle getBounds() {return new Rectangle(x, y, DIAMETER, DIAMETER);}	
	
	void hayColision(){} 
	
	public void run() {
			while(true){
				//if ((bola1.gameOver())
				if (getPosX() + getXA() < 0) {setXA(1);}
				if (x + xa > Width - DIAMETER) {setXA(-1);}
				if (y + ya < 0) {setYA(1);}
					
				setPosX(getPosX()+(2*getXA()));
				setPosY(getPosY()+(2*getYA()));
				
				try {
					thread.sleep(10);
				} catch (Exception e) {}	
				}
		}

	public boolean gameOver() {
		if (getPosY() + getYA() > Height - DIAMETER) 
			return true;
		return false;
	}

	public int getDiameter() {
		return DIAMETER;
	}

									
}