package CS3330_Group_Assignment_3;

import javax.sound.midi.*;
/**
 * Represents a unique data type to store the values pertaining to a specific MidiEvent in a midi song
 * Class contains getters and setters for all elements to allow for their modification
 */
public class MidiEventData {
	private int startEndTick, velocity, note, channel, noteOnOff;
	private int instrument;
	
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	
	public int getStartEndTick() {
		return startEndTick;
	}
	
	public void setStartEndTick(int newStartEndTick) {
		this.startEndTick = newStartEndTick;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public void setVelocity(int newVelocity) {
		this.velocity = newVelocity;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int newNote) {
		this.note = newNote;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public void setChannel(int newChannel) {
		this.channel = newChannel;
	}
	
	public int getNoteOnOff() {
		return noteOnOff;
	}
	
	public void setNoteOnOff(int newNoteOnOff) {
		this.noteOnOff = newNoteOnOff;
	}
	public int getInstrument() {
		return instrument;
	}
	
	public void setInstrument(int newInstrument) {
		this.instrument = newInstrument;
	}
}


