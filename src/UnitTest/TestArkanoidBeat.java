package UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Beat.BPMObserver;
import Beat.BeatModelInterface;
import Beat.BeatObserver;
import Strategy.ModelSelector;
import arkanoid_MVC.ArkanoidView;
import arkanoid_MVC.Bola;
import arkanoid_beat.ArkanoidBeatAdapter;
import arkanoid_beat.ArkanoidBeatController;

public class TestArkanoidBeat{

	ArkanoidBeatAdapter adp;
	Bola bola1;
	ArkanoidView vista;
	
	@Before
	public void Inicializacion() {
		bola1= new Bola(0,0);
		adp= new ArkanoidBeatAdapter(bola1);
	}
	
	@Test
	public void asignacion_objeto() {
		assertEquals(bola1, adp.getBola());
	}
	
	@Test
	public void inicializar() {
		adp.initialize();
		assertEquals(0, adp.getBPM());
	}
	
	
	@Test
	public void bola_on() {
		adp.on();
		assertEquals(10, adp.getBPM());
	}
	
	@Test
	public void bola_off() {
		adp.off();
		assertEquals(0, adp.getBPM());
	}
	
	
	
	@Test
	public void bola_BPM() {
		adp.setBPM(12);
		assertEquals(12, adp.getBPM());
	}
	
	@Test
	public void Beat_RegAndRem() {
		
		ArrayList<BeatObserver> bO= adp.getBola().getBetOber();
		
		assertEquals(0, bO.size());
		BeatObserver o = new BeatObserver() {
			
			@Override
			public void updateBeat() {
				// TODO Auto-generated method stub
				
			}
		};
		
		adp.registerObserver(o);
		
		bO= bola1.getBetOber();
		assertEquals(1, bO.size());
		
		adp.removeObserver(o);
		assertEquals(0, bO.size());
		
	}
	
	@Test
	public void BPM_RegAndRem() {
		
		ArrayList<BPMObserver> bpm= adp.getBola().getbpmObs();
		
		assertEquals(0, bpm.size());
		BPMObserver o = new BPMObserver() {
			
			@Override
			public void updateBPM() {
				// TODO Auto-generated method stub
				
			}
		};
		
		adp.removeObserver(o);
		assertEquals(0, bpm.size());
		
		adp.registerObserver(o);
		assertEquals(1, bpm.size());
		
		adp.removeObserver(o);
		assertEquals(0, bpm.size());
		
		
	}
	
	@Test
	public void ArkController() {
	
		BeatModelInterface model = new Bola(20,20);
		ArkanoidBeatController controller = new ArkanoidBeatController(model,null);
		
		assertEquals(0, controller.getModel().getBPM());
		
		controller.start();
		assertEquals(10, controller.getModel().getBPM());
		
		controller.stop();
		assertEquals(0, controller.getModel().getBPM());
		
		controller.increaseBPM();
		assertEquals(1, controller.getModel().getBPM());
		
		controller.decreaseBPM();
		assertEquals(0, controller.getModel().getBPM());

		controller.setBPM(3);
		assertEquals(3, controller.getModel().getBPM());
	
	}
	
}
