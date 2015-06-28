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
		//Bola bola1 = new Bola(0,0);
		//Bola bola2 = new Bola(190,150);
		//Raqueta raqueta = new Raqueta();
		BeatModelInterface model = new Bola(20,20);
		//MusicController controller2 = new MusicController (model);
		MusicController controller = new MusicController(model);
		
    //	BeatModelInterface model = new MusicModel();
   	//	ControllerInterface controller = new MusicController(model);
	}
}
