package CS3330_Group_Assignment_3;

import java.util.List;
import java.util.Scanner;

import javax.sound.midi.*;

/**
 * Main class, allows users to select Rhythm type, do pitch adjustments, and select instruments for each channel for a given midi song
 */
public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("******************** Welcome to My Little Mozart! ********************");
			System.out.println("");
			System.out.println("*** My Little Mozart allows for selection of rhythm type, pitch adjustment, and instrument selection for a midi song based on user input");
			System.out.println("");
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./src/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			int selection = 0;
			Scanner userInp = new Scanner(System.in);
			MidiEventFactoryAbstract factoryAbstract = null;
			while(selection == 0) {
				System.out.println("Choose Rhythm Type standard, staccato, or legato (1,2, or 3): ");
				try {
					int choice = Integer.parseInt(userInp.nextLine());
					if (choice == 1) {
						factoryAbstract = new StandardMidiEventFactoryAbstract();
						selection = 1;
					}
					else if (choice == 2) {
						factoryAbstract = new StaccatoMidiEventFactoryAbstract();
						selection = 1;
					}
					else if (choice == 3){
						factoryAbstract = new LegatoMidiEventFactoryAbstract();
						selection = 1;
					}
					else {
						System.out.println("Invalid entry, please try again");
					}
				}
				catch(Exception e){
					System.out.println("Invalid entry, please try again");
				}
			}
			
			selection = 0;
			
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			PitchStrategy pitchStrategy = null;
			
			
			
			int noOfAdj = 0;
			while(selection == 0) {
				System.out.println("Choose higher, lower, or no pitch adjustment (1,2, or 3): ");
				try {
					int choice = Integer.parseInt(userInp.nextLine());
					if (choice == 1) {
						pitchStrategy = new HigherPitchStrategy();
						noOfAdj = 1;
						selection = 1;
					}
					else if (choice == 2) {
						pitchStrategy = new LowerPitchStrategy();
						noOfAdj = 1;
						selection = 1;
					}
					else if (choice == 3){
						selection = 1;
					}
					else {
						System.out.println("Invalid entry, please try again");
					}
				}
				catch(Exception e){
					System.out.println("Invalid entry, please try again");
				}
			}
			
			selection = 0;
			
			if (noOfAdj != 0) {
				while(selection == 0) {
					System.out.println("Choose number of pitch adjustments to perform (1-13): ");
					try {
						noOfAdj = Integer.parseInt(userInp.nextLine());
						if (noOfAdj<14 & noOfAdj>0) {
							selection = 1;
						}
						else {
							System.out.println("Invalid entry, please try again");
						}
					}
					catch(Exception e){
						System.out.println("Invalid entry, please try again");
					}
				}
			}
			
			selection = 0;
			
			
			
			InstrumentStrategy instrumentStrategy = null;
			//instrumentStrategy.applyInsturment(track, 0);
			while(selection != 5) {
				System.out.println("Choose instrument type for channel " + selection + ", electric bass, trumpet, grand piano (1,2, or 3): ");
				try {
					int choice = Integer.parseInt(userInp.nextLine());
					if (choice == 1) {
						instrumentStrategy = new ElectricBassGuitarStrategy();
						instrumentStrategy.applyInsturment(track, selection);
						selection++;
					}
					else if (choice == 2) {
						instrumentStrategy = new TrumpetStrategy();
						instrumentStrategy.applyInsturment(track, selection);
						selection++;
					}
					else if (choice == 3){
						instrumentStrategy = new AcousticGrandPianoStrategy();
						instrumentStrategy.applyInsturment(track, selection);
						selection++;
					}
					else {
						System.out.println("Invalid entry, please try again");
					}
				}
				catch(Exception e){
					System.out.println("Invalid entry, please try again");
				}
			}
			
			selection = 0;
			
			for(MidiEventData event : midiEvents) {
				int modifiedNote = event.getNote();
				int loopAdj = noOfAdj;
				if (loopAdj != 0) {
					modifiedNote = pitchStrategy.modifyPitch(event.getNote());
					loopAdj--;
					while(loopAdj != 0) {
						modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
						loopAdj--;
					}
				}
				
				
				if(event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				}
				else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}
			
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			while(sequencer.isRunning() | sequencer.isOpen()) {
				Thread.sleep(100);
			}
			Thread.sleep(500);
			sequencer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
