package arkanoid_MVC;

import arkanoid_MVC.ModelObserver;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import arkanoid_MVC.Raqueta;


public class ArkanoidView extends JPanel implements  ModelObserver, Runnable  {
	
	Raqueta raqueta;
	Bola bola1;
	Bola bola2;
	ArkanoidController controller;
	Thread thread;
	boolean pausa;
	boolean perdi;
    
	public ArkanoidView(Bola bola1, Bola bola2, Raqueta raqueta, ArkanoidController controller) {	
		
		this.raqueta = raqueta;
		this.bola1 = bola1;
		this.bola2 = bola2;
		this.controller = controller;
		JFrame frame = new JFrame("Mini Tennis");
		raqueta.registerObserver((ModelObserver)this);
		bola1.registerObserver((ModelObserver)this);
		bola2.registerObserver((ModelObserver)this);
		frame.add(this);
		frame.setSize(400, 580);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		perdi = false;
		
		addKeyListener(new MyKeyListener());
		setFocusable(true);
		thread = new Thread(this);
		thread.start();
		
		
}

	public boolean perdio() {
		if ((bola1.gameOver()) || (bola2.gameOver())) {
			System.out.println("perdiiiiiiiiiiiiiiiiiii2222222222222222222");
			JOptionPane.showMessageDialog(this, "your score is: " + (bola2.getScore() + bola1.getScore()),
			"Game Over", JOptionPane.YES_NO_OPTION);
			System.exit(ABORT);
			return true;
			//sonido.GAMEOVER.play(); 
		}
		else return false;
	}
	

	public void paint(Graphics g) {
		
		super.paint(g);
		Image background;
		String imagen = "Oceano";
		if (imagen == "Nieve" ) {background = new ImageIcon("./src/Imagenes/Nieve.jpg").getImage();}
		else if (imagen == "Desierto") {background = new ImageIcon("./src/Imagenes/Desierto.jpg").getImage();}
		else {background = new ImageIcon("./src/Imagenes/Oceano.jpg").getImage();}
		int ancho = this.getSize().width;
		int alto = this.getSize().height;
		g.drawImage(background, 0, 0, ancho, alto, null);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		
		//pinto puntaje
		g2d.setColor(Color.BLUE);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString("SCORE:",150,100);
		g2d.drawString(String.valueOf(bola1.getScore() + bola2.getScore()), 190, 130);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Verdana", Font.BOLD, 10));
		g2d.drawString("Presionar P para pausar",250,545);
		
		if (pausa){ 
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("Verdana", Font.BOLD, 80));
			g2d.drawString("PAUSE",50,300);
		}
		else{
		// pinto bola1
		g2d.setColor(Color.RED);
		g2d.fillOval(bola1.getPosX(), bola1.getPosY(), bola1.getDiameter(), bola1.getDiameter());
		// pinto bola2
		g2d.fillOval(bola2.getPosX(), bola2.getPosY(), bola2.getDiameter(), bola2.getDiameter());
		//pinto raqueta
		controller.move();
		g2d.setColor(Color.GREEN);
		g2d.fillRect(raqueta.getPosX(), raqueta.getPosY(), raqueta.getAncho(), raqueta.getAlto());
		}	
	
	}
	

/*public void terminarJuego() {
	System.out.println("perdiiiiiiiiiiiiiiiiiii2222222222222222222");
	JOptionPane.showMessageDialog(this, "your score is: " + (bola2.getScore() + bola1.getScore()),
	"Game Over", JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
}*/
	
	
	public void pausa() {
		pausa = !pausa;
	}


	public void run() {	
		
		while (!(perdio())){
			repaint();
			
			try {
				thread.sleep(10);
				
			} catch (Exception e) {
				
			}
		}
	}
//	e.getKeyCode() == KeyEvent.VK_LEFT

class MyKeyListener extends KeyAdapter {
	
	public void keyTyped(KeyEvent e) {
		System.out.println("key pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		controller.released();
		//raqueta.setXA(0);
	}

	@Override
	public void keyPressed(KeyEvent evt) {
	
		//System.out.println("key pressed");
		if (evt.getKeyCode() == KeyEvent.VK_LEFT){
			controller.moveLeft();
			}
		
		if (evt.getKeyCode() == KeyEvent.VK_RIGHT){
			controller.moveRigth();
		} 		
		if (evt.getKeyCode() == KeyEvent.VK_P)	{
			controller.pausa();
		}
	}
  
}


}
	