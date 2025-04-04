package CS3330_Group_Assignment_3;

import javax.sound.midi.Track;
/**
 * This interface serves as the basis of InstrumentStrategy, a Strategy that facilitates the dynamic selection
 * of various instruments for a midi song channel
 */
public interface InstrumentStrategy {
	void applyInsturment(Track track, int channel);
}
