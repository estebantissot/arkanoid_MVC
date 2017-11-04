package arkanoid_beat;
import arkanoid_MVC.Bola;
import Beat.BeatModelInterface;
import Menu.ControllerInterface;
import Strategy.ModelSelector;
import Beat.DJView;

  
public class ArkanoidBeatController implements ControllerInterface {
	BeatModelInterface model;
	DJView view1;
	Bola bola1;
	
	public ArkanoidBeatController(BeatModelInterface model, ModelSelector view) {
		this.model = model;
		view1 = new DJView(this, model);
		view1.createView();
        view1.createControls();
		view1.disableStopMenuItem();
		view1.enableStartMenuItem();
		model.initialize();
	}
  
	public ArkanoidBeatController(Bola bola1) {
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
 	
 	public BeatModelInterface getModel() {
 		
 		return model;
 	}
}
