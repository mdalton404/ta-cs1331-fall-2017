/**
* Recitation generics example
* @author Isabella Plonk
* @version 3.0
*/
import java.util.ArrayList;
import java.util.Collections;

public class Magician {

	public static void main(String[] args) {

		// Hat h = new Hat();
		// h.add(new Rabbit("brown"));
		// h.add(new Rabbit("pink"));
		// h.add(new Rabbit("grey"));
		// h.add(new Rabbit("white"));
		// System.out.println("I pulled out a " + h.remove());
		// System.out.println("I pulled out a " + h.remove());

		// GenericHat<Rabbit> h = new GenericHat<>();
		// h.add(new Rabbit("brown"));
		// h.add(new Rabbit("pink"));
		// h.add(new Rabbit("grey"));
		// h.add(new Rabbit("white"));
		// System.out.println("I pulled out a " + h.remove());
		// System.out.println("I pulled out a " + h.remove());

		// GenericHat<Coin> h1 = new GenericHat<>();
		// h1.add(new Coin(25));
		// h1.add(new Coin(5));
		// h1.add(new Coin(10));
		// h1.add(new Coin(1));
		// System.out.println("I pulled out a " + h1.remove());
		// System.out.println("I pulled out a " + h1.remove());

		// GenericHat<Integer> integers = new GenericHat<>();
		// for (int i = 1; i < 11; ++i) {
		// 	integers.add(i);
		// }
		// System.out.println(integers.remove() + 2);

		ArrayList<Coin> coins = new ArrayList();
		coins.add(new Coin(25));
		coins.add(new Coin(50));
		coins.add(new Coin(5));
		coins.add(new Coin(10));
		coins.add(new Coin(1));

		System.out.println("Before sort");
		for (Coin c : coins) {
			System.out.println(c);
		}
		System.out.println("\nAfter sort");
		Collections.sort(coins);
		for (Coin c : coins) {
			System.out.println(c);
		}
	}
}