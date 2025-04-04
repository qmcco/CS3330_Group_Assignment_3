package CS3330_Group_Assignment_3;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
/**
 * Implementation of MidiEventFactory that implements a legato rhythm by increasing the duration of the NoteOff, creating
 * a smoother transition from NoteOff to the next NoteOn
 */
public class LegatoMidiEventFactory implements MidiEventFactory {
	/**
	 * Method creates the NoteOn instance of the given note, this is meant to be when the note is played
	 * @param tick, a counter indicating the position of the note in the song, modifying this value can effectively change the duration of the note
	 * @param note, the note value for the current MidiEvent to be implemented
	 * @param velocity, the speed at which a note is played
	 * @param channel, the channel in which the note is present
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		int legatoTick = tick;
		ShortMessage newMessage = new ShortMessage();
		newMessage.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent newEvent = new MidiEvent(newMessage, legatoTick);
		return newEvent;
	}
	/**
	 * Method creates the NoteOff instance of the given note, this is the fading of the note after it has been played
	 * its duration has been increased to create a legato effect, smoothing out the transition from NoteOff to NoteOn
	 * @param tick, a counter indicating the position of the note in the song, modifying this value can effectively change the duration of the note
	 * @param note, the note value for the current MidiEvent to be implemented
	 * @param channel, the channel in which the note is present
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		int legatoTick = tick + 80;
		ShortMessage newMessage = new ShortMessage();
		newMessage.setMessage(ShortMessage.NOTE_ON, channel, note);
		MidiEvent newEvent = new MidiEvent(newMessage, legatoTick);
		return newEvent;
	}
}
