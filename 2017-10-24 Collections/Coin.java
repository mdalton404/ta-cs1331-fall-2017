/**
* Class representing a coin
* @author Isabella Plonk
* @version 3.0
*/
public class Coin implements Comparable<Coin> {

	private int worth;

	/**
	* Initializes a coin object
	* @param worth the value of the coin in cents
	*/
	public Coin(int worth) {
		this.worth = worth;
	}


	@Override
	/**
	* @return a String representation of the coin
	*/
	public String toString() {
		return worth + " cent coin";
	}

	@Override
	/**
	* @param c an instance of Coin to be compared
	* @return integer value representing comparison
	*/
	public int compareTo(Coin c) {
		return this.worth - c.worth;
	}
}
