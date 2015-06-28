package arkanoid_beat;
import arkanoid_MVC.Bola;
import arkanoid_MVC.Model;
import Beat.BeatModelInterface;
import Menu.ControllerInterface;
import Beat.DJView;
import Beat.BeatBar;
//import Strategy.ModelSelector;

  
public class ArkanoidBeatController implements ControllerInterface {
	BeatModelInterface model;
	DJView view1;
	Bola bola1;
	
	public ArkanoidBeatController(BeatModelInterface model) {
		this.model = model;
		int bpm;
		view1 = new DJView(this, model);
    	System.out.println("Music Controller 1");
		view1.createView();
        view1.createControls();
		view1.disableStopMenuItem();
		view1.enableStartMenuItem();
		model.initialize();
	}
  
	public ArkanoidBeatController(Bola bola1) {
    	System.out.println("Music Controller 2");
		// TODO Auto-generated constructor stub
		//bola1 = bola1;
		this.model = model;
		this.view1 = view1;
		this.view1.disableStopMenuItem();
		this.view1.enableStartMenuItem();
		this.model.initialize();
		
	}


	public void start() {
		model.on();	
		view1.disableStartMenuItem();
		view1.enableStopMenuItem();	
	}
  
	public void stop() {
		model.off();
		view1.disableStopMenuItem();
		view1.enableStartMenuItem();
	}

   
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}

 	public void setBPM(int bpm) {
 		System.out.println("set BPM");
 		model.setBPM(bpm);
	}
}
