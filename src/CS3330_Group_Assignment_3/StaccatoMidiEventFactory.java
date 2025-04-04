package CS3330_Group_Assignment_3;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StaccatoMidiEventFactory implements MidiEventFactory {
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		
		int staccatoTick = tick;
		ShortMessage newMessage = new ShortMessage();
		newMessage.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent newEvent = new MidiEvent(newMessage, staccatoTick);
		return newEvent;
	}
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		int staccatoTick = tick-120;
		ShortMessage newMessage = new ShortMessage();
		newMessage.setMessage(ShortMessage.NOTE_ON, channel, note);
		MidiEvent newEvent = new MidiEvent(newMessage, staccatoTick);
		return newEvent;
	}
}
