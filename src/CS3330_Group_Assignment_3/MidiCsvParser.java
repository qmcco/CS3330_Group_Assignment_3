package CS3330_Group_Assignment_3;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.ShortMessage;

/**
 * parses a given CSV of a predetermined layout, in which each line contains six elements of type int, barring the second element of each line
 * which is a string and is used to determine the int value that a field should be assigned
 */
public class MidiCsvParser {
	/**
	 * Method produces a list of MidiEventData elements, by creating a MidiEventData element using the information stored in each
	 * line of a given CSV file. Each line is taken and split by the commas present into 6 unique elements, 5 of which are directly
	 * cast as ints and assigned to their respective fields, and another is used as a string to determine what value should be assigned to
	 * a field
	 * @param filePath, the filePath of the csv that ought to be parsed
	 * @return a list of MidiEventData elements
	 */
	public static List<MidiEventData> parseCsv(String filePath){
		List<MidiEventData> midiEvents = new ArrayList<MidiEventData>();
		File file = new File(filePath);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String[] tempStringArr;
				int tempStartEndTick = 0;
				int tempInstrument = 0;
				int tempVelocity = 0;
				int tempNote = 0;
				int tempChannel = 0;
				int tempNoteOnOff = 0;
				tempStringArr = scanner.nextLine().split("\\s*,\\s*");
				tempStartEndTick = Integer.parseInt(tempStringArr[0]);
				tempInstrument = Integer.parseInt(tempStringArr[5]);
				tempVelocity = Integer.parseInt(tempStringArr[4]);
				tempNote = Integer.parseInt(tempStringArr[3]);
				tempChannel = Integer.parseInt(tempStringArr[2]);
				if(tempStringArr[1].equals("Note_on_c")) {
					tempNoteOnOff = ShortMessage.NOTE_ON;
				}
				else {
					tempNoteOnOff = ShortMessage.NOTE_OFF;
				}
				MidiEventData tempMidiEventData = new MidiEventData(tempStartEndTick, tempVelocity, tempNote, tempChannel, tempInstrument, tempNoteOnOff);
				midiEvents.add(tempMidiEventData);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return midiEvents;
	}
}
