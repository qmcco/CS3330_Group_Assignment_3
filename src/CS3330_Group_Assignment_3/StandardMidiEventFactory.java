package CS3330_Group_Assignment_3;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StandardMidiEventFactory implements MidiEventFactory {
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage newMessage = new ShortMessage();
		newMessage.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent newEvent = new MidiEvent(newMessage, tick);
		return newEvent;
	}
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage newMessage = new ShortMessage();
		newMessage.setMessage(ShortMessage.NOTE_ON, channel, note);
		MidiEvent newEvent = new MidiEvent(newMessage, tick);
		return newEvent;
	}
}
