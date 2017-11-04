package arkanoid_MVC;

import java.awt.Rectangle;

public class Raqueta extends Model{
	private static int y = 500;
	private static final int ANCHO = 100;
	private static final int ALTO = 10;
	
	public Raqueta() {
		super(0,y,0,0);
	}
	
	public int getAncho() {return ANCHO;}
	
	public int getAlto() {return ALTO;}

	public int getTopY() {return y - ALTO;}
	
	public Rectangle getBounds() { return new Rectangle(x, y, ANCHO, ALTO);}

	public void move() {
		if (getPosX() + getXA() > 0 && getPosX() + getXA() < Width - getAncho()){ 
			setPosX(getPosX() + getXA());
		}
	}

}
	
