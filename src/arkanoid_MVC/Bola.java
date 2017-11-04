package arkanoid_MVC;
import java.awt.Rectangle;
import java.util.ArrayList;
import Beat.BPMObserver;
import Beat.BeatModelInterface;
import Beat.BeatObserver;
import arkanoid_MVC.Model;

import javax.sound.sampled.Clip;

public class Bola extends Model implements Runnable, BeatModelInterface {
	private static final int DIAMETER = 20;
	private int score = 0;
	Thread thread;
	Clip sonido;
	int speed;
	int a,b,c;
	
	ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();


	public Bola(int x, int y) {
		super(x,y,1,1);
		thread = new Thread(this);
		thread.start();
		speed = 10;	
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
					notifyBeatObservers();
				}
				
				if (x + xa > Width - DIAMETER) {
					setXA(-1);
					Sound.PELOTITA.play();
					notifyBeatObservers();
					
				}
				if (y + ya < 0) {
					setYA(1);
					Sound.PELOTITA.play();
					notifyBeatObservers();
				}
					
				setPosX(getPosX()+(2*getXA()));
				setPosY(getPosY()+(2*getYA()));
				
				try {Thread.sleep(speed);} 
				catch (Exception e) {}	
				}
		}

	public boolean gameOver() {
		if (getPosY() + getYA() > Height - DIAMETER) 
			return true;
		return false;
	}

	@Override
	public void initialize() {
		speed = 0;
	}

	@Override
	public void on() {
		speed =10;
	}

	@Override
	public void off() {
		speed =0;
	}

	@Override
	public void setBPM(int bpm) {
		speed = bpm;
		notifyBPMObservers();
	}

	@Override
	public int getBPM() {
		return speed;
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
	
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
	
	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}  
  
	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();	
		}
	}

	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}	
}
