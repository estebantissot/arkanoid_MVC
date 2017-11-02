package arkanoid_MVC;


public class ArkanoidController {
	ArkanoidView view;
	Raqueta raqueta;
	Bola bola1;
	Bola bola2;

	public ArkanoidController(Bola bola1, Bola bola2, Raqueta raqueta) {
		ArkanoidView view = new ArkanoidView(bola1, bola2, raqueta, this);
		this.raqueta = raqueta;
		this.bola1 = bola1;
		this.bola2 = bola2;
	}

	public void released() {raqueta.setXA(0);}

	public void moveLeft() {raqueta.setXA(-8);}
	
	public void moveRigth() {raqueta.setXA(8);}
	
	public void move() {
		if (raqueta.getBounds().intersects(bola1.getBounds())) {collision(bola1);} 
		if (raqueta.getBounds().intersects(bola2.getBounds())) {collision(bola2);}
		raqueta.move();
	}
	
	public void collision(Bola bola){ 
		bola.incrementarScore(); 
		bola.setYA(-1);
		bola.setPosY(raqueta.getTopY() - bola.getDiameter());
		if (((raqueta.getPosX() + (raqueta.getAncho() / 2) - 1) > bola.getPosX()) && (bola.getXA() == 1)){
			bola.setXA(-1);
			Sound.PELOTITA.play();
		}
			
		if (((raqueta.getPosX() + (raqueta.getAncho() / 2) - 1) < bola.getPosX()) && (bola.getXA() == -1)){
			bola.setXA(1);
			Sound.PELOTITA.play();
		}
			
	}

	public void pausa() {
		raqueta.pausa();
		bola1.pausa();
		bola2.pausa();			
	}
}

