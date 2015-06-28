package Menu;

import arkanoid_MVC.ArkanoidController;
import arkanoid_MVC.Bola;
import arkanoid_MVC.Raqueta;
import Beat.BeatController;
import Beat.BeatModelInterface;
import Beat.BeatModel;
import Menu.ControllerInterface;
import Heart.HeartController;
import Heart.HeartModel;

public class AllinOneTestDrive {
	public static void main(String[] args){
		play();
	}
	
	public static void play(){
		
		BeatModelInterface modelBeat = new BeatModel();
		ControllerInterface controller = new BeatController(modelBeat);
		
		HeartModel heartModel = new HeartModel();
		ControllerInterface model = new HeartController(heartModel);
		
		Bola bola1 = new Bola(0,0);
		Bola bola2 = new Bola(190,150);
		Raqueta raqueta = new Raqueta();
		ArkanoidController controllerArkanoid = new ArkanoidController(bola1,bola2,raqueta);
	}
}


