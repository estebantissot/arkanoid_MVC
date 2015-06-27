package Beat;

import Beat.BeatController;
import Beat.BeatModelInterface;
import Beat.BeatModel;
import Menu.ControllerInterface;


public class DJTestDrive {
	public static void main(String[] args){
		play();
	}
	
	public static void play(){
		BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
	}
}


