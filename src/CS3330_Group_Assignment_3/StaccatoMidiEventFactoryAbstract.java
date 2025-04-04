package CS3330_Group_Assignment_3;
/**
 * The basis of the abstract factory implementation of Staccato Midi Event Modification, implements MidiEventFactoryAbstract
 * is responsible for creating a factory instance of LegatoMidiEventFactory(), which in turn facilitates the creation off NoteOn and NoteOff
 * midi events
 */
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
