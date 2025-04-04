package CS3330_Group_Assignment_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidiCsvParser {
	public static List<MidiEventData> parseCsv(String filePath){
		List<MidiEventData> midiEvents = new ArrayList<MidiEventData>();
		Scanner scanner = new Scanner(filePath);
		while(scanner.hasNextLine()) {
			String[] tempStringArr;
			int tempStartEndTick = 0;
			int tempInstrument = 0;
			int tempVelocity = 0;
			int tempNote = 0;
			int tempChannel = 0;
			int tempNoteOnOff = -1;
			tempStringArr = scanner.nextLine().split("\\s*,\\s*");
			tempStartEndTick = Integer.parseInt(tempStringArr[0]);
			tempInstrument = Integer.parseInt(tempStringArr[5]);
			tempVelocity = Integer.parseInt(tempStringArr[4]);
			tempNote = Integer.parseInt(tempStringArr[3]);
			tempChannel = Integer.parseInt(tempStringArr[2]);
			if(tempStringArr[1].equals("Note_on_c")) {
				tempNoteOnOff = 0;
			}
			else {
				tempNoteOnOff = 1;
			}
			MidiEventData tempMidiEventData = new MidiEventData(tempStartEndTick, tempVelocity, tempNote, tempChannel, tempInstrument, tempNoteOnOff);
			midiEvents.add(tempMidiEventData);
		}
		scanner.close();
		return midiEvents;
	}
}
