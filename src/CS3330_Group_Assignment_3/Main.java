package CS3330_Group_Assignment_3;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./mystery_song.csv");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
