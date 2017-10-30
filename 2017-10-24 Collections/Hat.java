import java.util.Random;

/**
* Class representing a hat that hold rabbits
* @author Isabella Plonk
* @version 1.0
*/
public class Hat {

	private Rabbit[] rabbits;
	private int numRabbits;
	private Random rand = new Random();

	/**
	* Initializes hat object
	*/
	public Hat() {
		rabbits = new Rabbit[10];
		numRabbits = 0;
	}

	/**
	* Adds a rabbit to the hat
	* @param r the rabbit to add to the hat
	* @return whether or not the rabbit was added
	*/
	public boolean add(Rabbit r) {
		boolean isSpace = false;
		if (numRabbits != rabbits.length) {
			rabbits[numRabbits] = r;
			++numRabbits;
			isSpace = true;
		}
		return isSpace;
	}

	/**
	* Removes a random rabbit from the hat
	* Throws an IllegalStateException if the hat is empty
	* @return the rabbit that was removed
	*/
	public Rabbit remove() {
		if (numRabbits == 0) {
			throw new IllegalStateException("Cannot remove rabbit from an empty hat.");
		}
		int num = rand.nextInt(numRabbits);
		Rabbit removed = rabbits[num];
		for (int i = num; i < rabbits.length - 1; ++i) {
			rabbits[num] = rabbits[num + 1];
		}
		--numRabbits;
		return removed;
	}

}