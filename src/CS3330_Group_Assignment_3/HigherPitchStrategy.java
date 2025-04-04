package CS3330_Group_Assignment_3;

public class HigherPitchStrategy implements PitchStrategy {

	@Override
	public int modifyPitch(int note) {
		int newNote = note + 2;
		return newNote;
	}

}
