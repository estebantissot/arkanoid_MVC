package arkanoid_beat;

import Beat.BeatModelInterface;
import arkanoid_MVC.Bola;

public class ArkanoidBeatTestDrive {
	public static void main(String[] args){
		play();
	}
	
	public static void play(){
		BeatModelInterface model = new Bola(20,20);
		ArkanoidBeatController controller = new ArkanoidBeatController(model,null);
	}
}
