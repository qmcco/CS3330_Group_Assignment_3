package CS3330_Group_Assignment_3;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class TrumpetStrategy implements InstrumentStrategy {

	@Override
	public void applyInsturment(Track track, int channel) {
		ShortMessage newMessage = new ShortMessage();
		try {
			newMessage.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
			MidiEvent InstrumentSetEvent = new MidiEvent(newMessage, track.ticks());
			track.add(InstrumentSetEvent);
			
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
	}

}
