package UnitTest;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xpath.internal.operations.Mod;

import arkanoid_MVC.Bola;
import arkanoid_MVC.Model;
import arkanoid_MVC.ModelObserver;
import arkanoid_beat.ArkanoidBeatAdapter;

public class TestModel {

	Model modelo;
	@Before
	public void Inicializacion() {
	modelo= new Model(0, 0, 1, 1) {
		
		@Override
		public Rectangle getBounds() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	}
	
	@Test
	public void pause() {
		modelo.setYA(-1);
		assertEquals(-1, modelo.getYA());
		
		modelo.pausa();
		modelo.setYA(1);
		assertEquals(-1, modelo.getYA());
		
		modelo.pausa();
		modelo.setYA(1);
		assertEquals(1, modelo.getYA());

	}
	@Test
	public void AddAndRem() {
		ModelObserver o = new ModelObserver() {
			
			@Override
			public void pausa() {
				// TODO Auto-generated method stub
				
			}
		};
		
		modelo.removeObserver(o);
		assertEquals(0, modelo.getObserver().size());
		
		modelo.registerObserver(o);
		assertEquals(1, modelo.getObserver().size());
		
		modelo.removeObserver(o);
		assertEquals(0, modelo.getObserver().size());
		
		
	}

}
