package arkanoid_MVC;



public class ArkanoidTestDrive {
	public static void main(String[] args){
		play();
	}
	
	public static void play(){
		Bola bola1 = new Bola(0,0);
		Bola bola2 = new Bola(190,150);
		Raqueta raqueta = new Raqueta();
		ArkanoidController controller = new ArkanoidController(bola1,bola2,raqueta);
	}
	
}

