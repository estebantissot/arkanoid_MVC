package arkanoid_beat;

import arkanoid_MVC.Bola;
import Beat.BPMObserver;
import Beat.BeatModelInterface;
import Beat.BeatObserver;

public class ArkanoidBeatAdapter implements BeatModelInterface{

	Bola bola1;
	
	public ArkanoidBeatAdapter(Bola bola1){
		this.bola1 = bola1;
	}

	public void initialize() {
		this.bola1.initialize();
	}

	public void on() {
		this.bola1.on();		
	}

	public void off() {
		this.bola1.off();
	}

	public void setBPM(int bpm) {
		this.bola1.setBPM(bpm);
	}

	public int getBPM() {
		return this.bola1.getBPM();
	}

	public void registerObserver(BeatObserver o) {
		this.bola1.registerObserver(o);
	}

	public void removeObserver(BeatObserver o) {
		this.bola1.removeObserver(o);
	}

	public void registerObserver(BPMObserver o) {
		this.bola1.registerObserver(o);
	}

	public void removeObserver(BPMObserver o) {
		this.bola1.removeObserver(o);
	}
	
	public Bola getBola() {
		return bola1;
	}
}
