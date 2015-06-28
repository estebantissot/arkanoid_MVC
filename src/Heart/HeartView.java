package Heart;

import Beat.BeatModelInterface;
import Beat.DJView;
import Menu.ControllerInterface;

public class HeartView extends DJView {
	
	public HeartView(ControllerInterface controller, BeatModelInterface model) {	
		super(controller, model);
    }
	
	public void updateBPM() {
		if (model != null) {
			if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("Instancias: " + model.getBPM());
			}
		}
	}
}
