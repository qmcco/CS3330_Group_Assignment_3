package CS3330_Group_Assignment_3;

import javax.sound.midi.*;
/**
 * This class implements InstrumentStrategy for the ElectricBassGuitar selection
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy {
	/**
	 * Creates a ShortMessage with the PROGRAM_CHANGE command to indicate a change of instrument
	 * the third field of the newMessage indicates the instrument, in this case, a 33 denotes an
	 * electric bass guitar
	 * Creates a new MidiEvent using the created ShortMessage and the ticks of the passed track,
	 * then adds the new event to the track
	 * @param track, the current track representing the midi song
	 * @param channel, the channel at which to change the instrument
	 */
	@Override
	public void applyInsturment(Track track, int channel) {
		ShortMessage newMessage = new ShortMessage();
		try {
			newMessage.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
			MidiEvent InstrumentSetEvent = new MidiEvent(newMessage, track.ticks());
			track.add(InstrumentSetEvent);
			
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
	}

}
