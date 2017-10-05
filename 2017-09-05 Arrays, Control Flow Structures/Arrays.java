public class Arrays {
	
	public static void main(String[] args) {

		// Declaration and initialization of array of doubles
		double[] scores = new double[5];
		scores[0] = 9.0;
		// Numbering of the indicies begins with 0.
		// The indicies of scores range from 0 to 4.
		// System.out.println(scores[0]);

		// The size of the array is stored in a public final instance variable named length.
		int length = scores.length;
		// scores.length == 5

		// Declaration and initialziation of array of Strings
		// We can provide initial values for the array.
		// This sets the length of the array.
		String[] primaryColors = {"red", "blue", "yellow"};
		// primaryColors.length == 3
		// primaryColors[1] == "blue"

		// We can also use a loop to initialize the values in an array.
		int[] squares = new int[5]; 
		for (int i = 0; i < squares.length; ++i) {
			squares[i] = i*i;
			// System.out.println(squares[i]);
		}
        // int[] newSquares = new int[6];
        // for (int i = 0; i < squares.length; ++i) {
        //     newSquares[i] = squares[i];
        // }
        // squares = newSquares;
        // for (int i = 0; i < squares.length; ++i) {
		// 	squares[i] = i*i;
		// 	System.out.println(squares[i]);
		// }

		// System.out.println(squares[0]);
		// System.out.println(squares[squares.length]);

		//For-each loop
		for (int i : squares) {
			System.out.println(i);
		}

		// Gotchas
		// double[] grades = new double[-5];
		// int[] grades = new int[5];
		// grades[-1] = 100;

        int[][] arr = new int[2][3];
        int[][] arr2 = {{1,2,3}, {1,2,3}};
        for (int i = 0; i < arr2.length; ++i) {
            for (int j = 0; j < arr2[i].length; ++j) {
                System.out.println(arr2[i][j]);
            }
        }
 	}
}