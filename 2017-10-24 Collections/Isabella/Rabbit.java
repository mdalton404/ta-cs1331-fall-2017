/**
* Class representing a rabbit
* @author Isabella Plonk
* @version 3.0
*/
public class Rabbit {

	private String color;

	/**
	* Initializes a rabbit object
	* @param color the color of the rabbit
	*/
	public Rabbit(String color) {
		this.color = color;
	}

	@Override
	/**
	* @return a String representation of the rabbit
	*/
	public String toString() {
		return color + " rabbit" ;
	}

	/**
	* @return the color of the rabbit
	*/
	public String getColor() {
		return color;
	}
}
