package CS3330_Group_Assignment_3;
/**
 * The basis of all non-abstract factory classes, defines the initialization of createNoteOn and createNoteOff which all 
 * non-abstract factory classes implement in the Abstract Factory Pattern
 */
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
