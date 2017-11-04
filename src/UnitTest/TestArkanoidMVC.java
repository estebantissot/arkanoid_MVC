package UnitTest;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import arkanoid_MVC.ArkanoidController;
import arkanoid_MVC.ArkanoidView;
import arkanoid_MVC.Bola;
import arkanoid_MVC.Interface;
import arkanoid_MVC.Model;
import arkanoid_MVC.Raqueta;

public class TestArkanoidMVC{
	
	Bola bola1;
	Bola bola2; 
	Raqueta raq;
	ArkanoidController controller;
	ArkanoidView vista;
	
	@Before
	public void Inicializacion() {
		bola1= new Bola(0,0);
		bola2= new Bola(30,60);
	
	}
	@Test
	public void perdio(){
		raq = new Raqueta();
		controller = new ArkanoidController(bola1, bola2, raq);
		vista = new ArkanoidView(bola1, bola2, raq, controller);
		
		bola1.setYA(1);
		bola1.setPosY(530);
		bola2.setPosY(100);
		bola2.setYA(1);
		
		assertTrue(vista.perdio());
		
		bola2.setYA(1);
		bola2.setPosY(530);
		
		assertTrue(vista.perdio());
		
		bola1.setYA(-1);
		bola1.setPosY(100);
		
		assertTrue(vista.perdio());
		
	}
	@Test
	public void move() {
		raq = new Raqueta();
		controller = new ArkanoidController(bola1, bola2, raq);
		vista = new ArkanoidView(bola1, bola2, raq, controller);
		
		bola1.setPosY(500);
    
		controller.move();
		assertEquals(-1, bola1.getXA());
		
		bola1.setPosY(5);	
		controller.move();
	
		
		bola2.setPosX(4);
		bola2.setPosY(500);
		
		
		controller.move();
		assertEquals(-1, bola2.getXA());
		bola2.setPosY(5);
		controller.move();
	}
	
	@Test
	public void interfa_botonBeatM() {
		Interface window = new Interface();
		
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		
		window.BeatM .doClick();
		
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
		
		assertEquals("Beat Model\n", os.toString());
		
	}
	
	@Test
	public void interfa_boton_btnHeartModel() {
		Interface window = new Interface();
		
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		
		window.btnHeartModel .doClick();
		
		PrintStream originalOut = System.out;
		System.setOut(originalOut);	
		
		assertEquals("Heart Model\n", os.toString());
		
	}
	
	
	@Test
	public void interfa_boton_btnArkanoidTestdrive() {
		Interface window = new Interface();
		
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		
		window.btnArkanoidTestdrive.doClick();
		
		PrintStream originalOut = System.out;
		System.setOut(originalOut);	
		
		assertEquals("Arkanoid\n", os.toString());
		
	}
	
	
	@Test
	public void interfa_boton_btnArkanoidBeat() {
		Interface window = new Interface();
		
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		
		window.btnArkanoidBeat.doClick();
		
		PrintStream originalOut = System.out;
		System.setOut(originalOut);	
		
		assertEquals("Arkanoid Beat\n", os.toString());
		
	}
	
	@Test
	public void interfa_boton_btnModelsIn() {
		Interface window = new Interface();
		
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		
		window.btnModelsIn.doClick();
		
		PrintStream originalOut = System.out;
		System.setOut(originalOut);	
		
		assertEquals("3models\n", os.toString());
		
	}
	@Test
	public void interfa_boton_btnStrategy() {
		Interface window = new Interface();
		
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		
		window.btnStrategy.doClick();
		

		PrintStream originalOut = System.out;
		System.setOut(originalOut);	
		
		assertEquals("Strategy\n", os.toString());
		
	}
	
	@Test
	public void collision_2() {
		raq = new Raqueta();
		controller = new ArkanoidController(bola1, bola2, raq);
		vista = new ArkanoidView(bola1, bola2, raq, controller);
		
		bola1.setPosX(50);
		bola1.setXA(1);
		
		controller.collision(bola1);
		assertEquals(1, bola1.getXA());
		
		
		bola1.setXA(-1);
		controller.collision(bola1);
		assertEquals(1,bola1.getXA());
		
		bola1.setXA(-1);
		bola1.setPosX(40);
		controller.collision(bola1);
		assertEquals(-1, bola1.getXA());
		
	}
	
	
	@Test
	public void collision_1() {
		raq = new Raqueta();
		controller = new ArkanoidController(bola1, bola2, raq);
		vista = new ArkanoidView(bola1, bola2, raq, controller);
		
		bola1.setPosX(40);
		bola1.setXA(1);
		
		controller.collision(bola1);
		assertEquals(-1, bola1.getXA());
		
		
		bola1.setXA(-1);
		controller.collision(bola1);
		assertEquals(-1,bola1.getXA());

	}
	
	@Test
	public void realeased() {
		raq = new Raqueta();
		controller = new ArkanoidController(bola1, bola2, raq);
		vista = new ArkanoidView(bola1, bola2, raq, controller);
		
		controller.released();
		assertEquals(0,raq.getXA());
		
	}
}
