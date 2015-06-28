package arkanoid_beat;
import java.util.ArrayList;

import javax.sound.midi.*;

import Beat.BeatObserver;

public class Instrumento implements MetaEventListener, Secuencia {
	//MusicModel music;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	
	private int bpm, sonido;
	private String nombre;
	private long id;
	ArrayList Observadores = new ArrayList();
	
	public Instrumento(String n, int s, int i, ArrayList a){
		bpm= 0;
		nombre = n;
		sonido=s;
		id=i;
		sequencer=null;
		sequence=null;
		Observadores=a;
		
		System.out.println(Thread.currentThread().getName()+": Soy el objeto Instrumento: "+nombre);
	}
	public void crear(){
		//System.out.println("Instrumento Run! con time="+time+" y bpm="+bpm);
		try {
			 setUpMidi();
			 buildTrackAndStart();
			
		} catch (Exception e) {	System.out.println("Error");	}
		
	}

	public void setBpm(int valor){
		bpm = valor;
		sequencer.setTempoInBPM(getBpm());
		System.out.println("Ahora "+nombre+" tiene bpm: "+bpm);
	}
	
	public int getBpm(){
		return bpm;
		
	}
	
	
	public void iniciar(){
		
		sequencer.start();
		
		System.out.println("Reproduccion Iniciada! Instrumento: "+this.nombre);
	}
	
	public void parar(){
		sequencer.stop();
	}
	
	public boolean isPlaying(){
		if(sequencer.isRunning())
			return true;
		else return false;
	}
	public String getName(){
		return nombre;
	}
	//---------------------------------metodos MIDI
	
	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBpm());
		} catch(Exception e) {
				e.printStackTrace();
		}
    } 
	
	public void buildTrackAndStart() {
        
        int[] trackList = {sonido,0};
    
        sequence.deleteTrack(null);
        track = sequence.createTrack();

      	makeTracks(trackList);
		track.add(makeEvent(192,9,1,0,4));      
	 	try {
			sequencer.setSequence(sequence);                    
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	       
    public void makeTracks(int[] list) {        
       
       for (int i = 0; i < list.length; i++) {
          int key = list[i];

          if (key != 0) {
             track.add(makeEvent(144,9,key, 100, i));
             track.add(makeEvent(128,9,key, 100, i+1));
          }
       }
    }
    
    public  MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
            
        } catch(Exception e) {
			e.printStackTrace(); 
		}
        return event;
    }
	public void meta(MetaMessage message) {
		// TODO Auto-generated method stub
		if (message.getType() == 0x2F ) {
			//music.notifyBeatObservers();
			Informarbeat();
            sequencer.setTickPosition(0) ; 
            sequencer.start(); 
        	setBpm(getBpm());	
        }
	}
	
	public void Informarbeat(){
		for(int i = 0; i < Observadores.size(); i++) {
			System.out.println("Avise a todos los observadores de los Beats");
			BeatObserver observer = (BeatObserver)Observadores.get(i);
			observer.updateBeat();
		}
	}
	
}
