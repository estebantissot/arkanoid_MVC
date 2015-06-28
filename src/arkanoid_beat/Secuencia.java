package arkanoid_beat;

import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;

public interface Secuencia {
	void crear();
	void setBpm(int valor);
	int getBpm();
	void iniciar();
	void parar();
	//void setUpMidi();
	//void buildTrackAndStart();
	//void makeTracks(int[] list);
    //MidiEvent makeEvent(int comd, int chan, int one, int two, int tick);
    //void meta(MetaMessage message);
}
