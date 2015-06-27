package arkanoid_MVC;
import java.awt.Rectangle;

import arkanoid_MVC.Model;

import javax.sound.sampled.Clip;

public class Bola extends Model implements Runnable {
	private static final int DIAMETER = 20;
	private int score = 0;
	Thread thread;
	Clip sonido;


	public Bola(int x, int y) {
		super(x,y,1,1);
		thread = new Thread(this);
		thread.start();
	}

	public int getDiameter() {return DIAMETER;}					
	
	public void incrementarScore() {score ++;}
	
	public int getScore() {return score;}
	
	public Rectangle getBounds() {return new Rectangle(x, y, DIAMETER, DIAMETER);}	
	
	public void run() {
			while(true){
		
				if (getPosX() + getXA() < 0) {
					setXA(1);
					Sound.PELOTITA.play();
				}
				if (x + xa > Width - DIAMETER) {
					setXA(-1);
					Sound.PELOTITA.play();
					Sound.PELOTITA.loop();
				}
				if (y + ya < 0) {
					setYA(1);
					Sound.PELOTITA.play();
				}
					
				setPosX(getPosX()+(2*getXA()));
				setPosY(getPosY()+(2*getYA()));
				
				try {Thread.sleep(10);} 
				catch (Exception e) {}	
				}
		}

	public boolean gameOver() {
		if (getPosY() + getYA() > Height - DIAMETER) 
			return true;
		return false;
	}
  
	
}