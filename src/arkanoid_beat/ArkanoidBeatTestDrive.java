package arkanoid_beat;

import Beat.BeatController;
import Beat.BeatModel;
import Beat.BeatModelInterface;
import Menu.ControllerInterface;
import arkanoid_MVC.ArkanoidController;
import arkanoid_MVC.Bola;
import arkanoid_MVC.Raqueta;

public class ArkanoidBeatTestDrive {
	public static void main(String[] args){
		play();
	}
	
	public static void play(){
		BeatModelInterface model = new Bola(20,20);
		ArkanoidBeatController controller = new ArkanoidBeatController(model);
	}
}
