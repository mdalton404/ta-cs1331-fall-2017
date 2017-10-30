import java.util.Random;

/**
* Class representing a hat using generics
* @author Isabella Plonk
* @version 1.0
*/
public class GenericHat<E> {

	private E[] items;
	private int numItems;
	private Random rand = new Random();

	/**
	* Initializes generic hat object
	*/
	public GenericHat() {
		items = (E[]) new Object[10];
		numItems = 0;
	}

	/**
	* Adds an item to the hat
	* @param item the item to add to the hat
	* @return whether or not an item was added
	*/
	public boolean add(E item) {
		boolean isSpace = false;
		if (numItems != items.length) {
			items[numItems] = item;
			++numItems;
			isSpace = true;
		}
		return isSpace;
	}

	/**
	* Removes a random item from the hat
	* Throws an IllegalStateException if the hat is empty
	* @return the item that was removed
	*/
	public E remove() {
		if (numItems == 0) {
			throw new IllegalStateException("Cannot remove item from an empty hat.");
		}
		int num = rand.nextInt(numItems);
		E removed = items[num];
		for (int i = num; i < items.length - 1; ++i) {
			items[num] = items[num + 1];
		}
		--numItems;
		return removed;
	}

}