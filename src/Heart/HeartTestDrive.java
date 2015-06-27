package Heart;
import Heart.HeartController;
import Heart.HeartModel;
import Menu.ControllerInterface;


public class HeartTestDrive {
	public static void main(String[] args){
		play();
	}
	
	public static void play(){
		HeartModel heartModel = new HeartModel();
		ControllerInterface model = new HeartController(heartModel);
	}
}