package arkanoid_MVC;

import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Model {
	int x;
	int y;
	int xa;
	int ya;
	int Width;
	int Height;
	boolean pausa;
	ArrayList ModelObserver = new ArrayList();

	
	public Model (int x, int y, int xa, int ya){
		this.x = x;
		this.y = y;
		this.xa = xa;
		this.ya = ya;
		Width = 400;
		Height = 550;
		pausa = false;
	}
	
	public int getPosX() {return x;}
	
	public void setPosX(int x) {
		if (!pausa) {this.x=x;}
	}
	
	public int getPosY() {return y;}
	
	public void setPosY(int y) {
		if (!pausa) {this.y=y;}
	}
	
	public void setXA(int x) {
		if (!pausa) {xa=x;}
	}
	
	public void setYA(int y) {
		if (!pausa) {ya=y;}
	}
	
	public int getXA() {return xa;}
	
	public int getYA() {return ya;}
	
	public void pausa() {
		pausa = !pausa;
		notifyModelObserver();
	}
	
	public abstract Rectangle getBounds();
	
	public void registerObserver(ModelObserver o) {
		ModelObserver.add(o);
	}
  
	public void notifyModelObserver() {
		for(int i = 0; i < ModelObserver.size(); i++) {
			ModelObserver observer = (ModelObserver)ModelObserver.get(i);
			observer.pausa();
		}
	}
	public void removeObserver(ModelObserver o) {
		int i = ModelObserver.indexOf(o);
		if (i >= 0) {
			ModelObserver.remove(i);
		}
	}
	
	public ArrayList getObserver() {
		
		return ModelObserver;
		
	}
}
	
	
