package Strategy;

import Beat.BeatModelInterface;
import Menu.ControllerInterface;
import Strategy.ModelSelector;

public class ModelSelectorTestDrive extends Beat.DJView {
	
	public ModelSelectorTestDrive(ControllerInterface controller, BeatModelInterface model) {
		super(controller, model);
		// TODO Auto-generated constructor stub
	}

	public static void main (String[] args) {
    	play();
    }
	
	public static void play(){
		ModelSelector vistaGeneral = new ModelSelector();
		vistaGeneral.createView();
		vistaGeneral.createControls();
	}
	
}
