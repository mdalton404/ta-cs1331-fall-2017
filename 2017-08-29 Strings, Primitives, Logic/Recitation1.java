// Defining a class
public class Recitation1 {
	
	// Main method
	public static void main(String[] args) {

		// Using args: run with java Recitation1 <arg0> <arg1>
		System.out.println(args[0]);
		System.out.println(args[1]);

		// Printing
		System.out.print("Hello World!"); 
		System.out.println("No new line :(");
		System.out.print("On a new line\n");
		
		System.out.println(Math.PI);
		System.out.printf("Pi is %.2f %n", Math.PI);

		int num = 3;
		String str = new String("pizza");
		System.out.printf("I ate %d slices of %s. %n", num, str);
		System.out.printf("Number of slices of %s I ate:%3d %n", str, num);


		// Comparison Operators
		System.out.println(3 == 3);
		System.out.println(3 != 3);
		System.out.println(3 <= 3);
		System.out.println(3 > 3);

		// Logical operators
		boolean tuesday = true;
		boolean monday = false;
        boolean wednesday = true;

		System.out.println(monday && tuesday);
		System.out.println(!(monday) && tuesday);
		System.out.println(tuesday || monday);
		System.out.println(monday || tuesday);
        System.out.println(monday ^ tuesday);
        System.out.println(tuesday ^ wednesday);


		// Conditionals
		int x = 10;
		if (x < 5) {
			System.out.println("x is less than 5");
		} else if (x < 10) {
			System.out.println("x is less than 10");
		} else {
			System.out.println("x is greater than or equaled to 10");
		}

		// Ternary Operator
		String bestTA = null;
		if (true) {
			bestTA = "Isabella";
		} else {
			bestTA = "Matt";
		}

		String bestTATernary = (true) ? "Isabella" : "Matt";
	}	
}