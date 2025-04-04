package CS3330_Group_Assignment_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.ShortMessage;

public class MidiCsvParser {
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
				System.out.println(tempInstrument);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return midiEvents;
	}
}
