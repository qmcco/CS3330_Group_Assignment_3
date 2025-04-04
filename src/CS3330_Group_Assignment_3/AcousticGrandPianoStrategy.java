package CS3330_Group_Assignment_3;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
/**
 * This class implements InstrumentStrategy for the AcousticGrandPiano selection
 */
public class AcousticGrandPianoStrategy implements InstrumentStrategy {
/**
 * Creates a ShortMessage with the PROGRAM_CHANGE command to indicate a change of instrument
 * the third field of the newMessage indicates the instrument, in this case, a 0 denotes an
 * acoustic grand piano
 * Creates a new MidiEvent using the created ShortMessage and the ticks of the passed track,
 * then adds the new event to the track
 * @param track, the current track representing the midi song
 * @param channel, the channel at which to change the instrument
 */
	@Override
	public void applyInsturment(Track track, int channel) {
		ShortMessage newMessage = new ShortMessage();
		try {
			newMessage.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
			MidiEvent InstrumentSetEvent = new MidiEvent(newMessage, track.ticks());
			track.add(InstrumentSetEvent);
			
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
	}

}
