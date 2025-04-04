package CS3330_Group_Assignment_3;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
