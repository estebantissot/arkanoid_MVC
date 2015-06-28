package arkanoid_MVC;

public interface ArkanoidModelInterface {
	void initialize();
	  
	//void on();
  
	//void off();
  
    //void setBPM(int bpm);
  
	//int getBPM();
  
	void registerObserver(ModelObserver o);
  
	void removeObserver(ModelObserver o);
  
}
