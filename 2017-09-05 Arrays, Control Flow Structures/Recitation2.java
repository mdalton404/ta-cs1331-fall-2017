// Java automatically imports from java.lang.
// However, Scanner is in java.util, so we must explicitly import it.
// For this class import each class individually from a package.
// Do not use * to import the entire package.
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class Recitation2 {
    public static void main(String[] args) throws Exception {  
        // Switch statements
        int expr = 3;

        switch (expr) { //expr can be a char, int, short, byte, or String
            case 1:
                // executed only when expr == 1
                System.out.println("Switch case 1");
                break;
            case 2:
                // executed only when expr == 2
                System.out.println("Switch case 2");
            case 3:
                // executed when expr == 3 || expr == 2, note the lack of break in 2
                System.out.println("Switch case 3");
                break;
            case 4:
                // executed only when expr == 4
                System.out.println("Switch case 4");
                break;
            default:
                // executed when none of the above cases are matched
                System.out.println("Switch default");
        }

        //Loops

        //While loops:
        //Condition tested before the loop body is executed,
        //loop body executes as long as condition is true
        int x = 10;
        while (x > 0) {
            System.out.println(x);
            x--;
        }

        //Do-While loops: Condition tested after the loop body is executed
        //Body is always executed at least once
        int y = 0;
        do {
            System.out.println(y);
            y++;
        } while (y > 0 && y < 5);

        //For loops: Body executed as long as condition is true
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        //Special note: If by themselves ++variable and variable++ (or --variable and variable--) are equivalent.
        //If with something else, it does not do the same thing.
        int a = 2;
        int b = 2; 
        int c = ++a; // increments a, then assigns value
        int d = b++; // assigns value, then increments b
        System.out.printf("a = %d, b = %d, c = %d, and d = %d.\n", a, b, c, d);

        //Scanner

        System.out.print("Prompt1: ");
        Scanner sc = new Scanner(System.in);
        //next() method reads the next complete token
        String input = sc.next();
        //useDelimiter() sets how tokens are delimited
        //sc.useDelimiter(", |");
        //nextLine() reads input including space between the words (that is, it reads till the end of line \n
        //String input = sc.nextLine();
        //nextInt() reads an integer but not the newline char \n
        System.out.print("Prompt2: ");
        int input2 = sc.nextInt();
        //nextDouble() reads a double
        //double input = sc.nextDouble();
        System.out.print("Prompt3: ");
        String input0 = sc.nextLine(); //addresses the \n after the parseInt()
        String input3 = sc.nextLine();
        System.out.print("You said " + input + ", then " + input2 + ", then " + input3);
        sc.close();
        
        //Scanner with Files

        String filename = "grades.csv";
        System.out.println(showLineNumbers(filename));

        // Writing to a file

        PrintStream outFile = new PrintStream(new File("tennesseeGame.txt"));
        outFile.println("And when Georgia Tech needed him most, Harrison Butker disappeared.");
        // flushes the output stream and forces any buffered output bytes to be written out
        outFile.flush();
        // saves and closes stream
        outFile.close();
    }


    public static String showLineNumbers(String name) throws Exception {
        String out = "";
        int line = 1;
        Scanner sc = new Scanner(new File(name));
        while (sc.hasNextLine()) {
            //parse each line
            String currLine = sc.nextLine();
            out = out + "\n" + line + "   " + currLine;
            line++;
        }
        sc.close();
        return out;
    }
}