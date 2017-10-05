public class TwoDArrs {
    public static void main(String[] args) {
        //Initializing 2D arrays
        char[][] charGrid = new char[4][12];
        //Individual element addressed by supplying two indices:
        charGrid[3][2] = '*';

        int[][] arr2 = {{1,2,3}, {4,5,6}};
        //Traversing 2D arrays
        //Done by nesting loops. Key is to use the right lengths
        //Row Major
        for (int i = 0; i < arr2.length; ++i) {
            for (int j = 0; j < arr2[0].length; ++j) {
                System.out.println(arr2[i][j]);
            }
        }
        //Col Major
        for (int i = 0; i < arr2[0].length; ++i) {
            for (int j = 0; j < arr2.length; ++j) {
                System.out.println(arr2[j][i]);
            }
        }
        //Initializing 2D arrays literally
        char[][] flag = {{'9', ':', ':', ':', ':', '=', '=', '=', '=', '=', '=', '='},
			{'|', ':', ':', ':', ':', '=', '=', '=', '=', '=', '=', '='},
			{'|', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '='},
			{'|', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '='}};
        //Problem: How do we display the flag in the command window?
        //Hint: it's not quite the same as the previous example
        

        //Answer
        for (int i = 0; i < flag.length; ++i) {
            for (int j = 0; j < flag[i].length; ++j) {
                System.out.print(flag[i][j]);
            }
            System.out.print("\n");
        }
    }
}