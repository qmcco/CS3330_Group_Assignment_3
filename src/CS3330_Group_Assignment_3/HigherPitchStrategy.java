package CS3330_Group_Assignment_3;
/**
 * This class implements PitchStrategy for an increase in pitch
 */
public class HigherPitchStrategy implements PitchStrategy {
/**
 * Given a note, creates a new note whose value is the passed notes value increased by 2, and returns the new note
 * @param note, a given note whose pitch should be increased
 */
	@Override
	public int modifyPitch(int note) {
		int newNote = note + 2;
		return newNote;
	}

}
