package CS3330_Group_Assignment_3;
/**
 * the basis of the Abstract Factory Pattern for Midi Events, facilitates the creation of midi event factories by serving
 * as the basis for all abstract midi event factory classes, which each in turn facilitate the creation of their non-abstract counterparts
 */
public interface MidiEventFactoryAbstract {
	MidiEventFactoryAbstract factoryAbstract = null;
	MidiEventFactory createFactory();
}
