package CS3330_Group_Assignment_3;

import java.util.List;

import javax.sound.midi.*;

public class Main {
	public static void main(String[] args) {
		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./src/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
			
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			PitchStrategy pitchStrategy = new LowerPitchStrategy();
			
			InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
			instrumentStrategy.applyInsturment(track, 0);
			instrumentStrategy.applyInsturment(track, 1);
			instrumentStrategy.applyInsturment(track, 2);
			instrumentStrategy.applyInsturment(track, 3);
			instrumentStrategy.applyInsturment(track, 4);
			
			for(MidiEventData event : midiEvents) {
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
