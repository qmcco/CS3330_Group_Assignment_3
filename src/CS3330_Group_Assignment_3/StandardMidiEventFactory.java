package CS3330_Group_Assignment_3;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
/**
 * Implementation of MidiEventFactory that implements a standard rhythm leaving the basic rhythm of the midi song unchanged
 */
public class StandardMidiEventFactory implements MidiEventFactory {
	/**
	 * Method creates the NoteOn instance of the given note, this is meant to be when the note is played
	 * @param tick, a counter indicating the position of the note in the song, modifying this value can effectively change the duration of the note
	 * @param note, the note value for the current MidiEvent to be implemented
	 * @param velocity, the speed at which a note is played
	 * @param channel, the channel in which the note is present
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage newMessage = new ShortMessage();
		newMessage.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent newEvent = new MidiEvent(newMessage, tick);
		return newEvent;
	}
	/**
	 * Method creates the NoteOff instance of the given note, this is the fading of the note after it has been played
	 * @param tick, a counter indicating the position of the note in the song, modifying this value can effectively change the duration of the note
	 * @param note, the note value for the current MidiEvent to be implemented
	 * @param channel, the channel in which the note is present
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage newMessage = new ShortMessage();
		newMessage.setMessage(ShortMessage.NOTE_ON, channel, note);
		MidiEvent newEvent = new MidiEvent(newMessage, tick);
		return newEvent;
	}
}
