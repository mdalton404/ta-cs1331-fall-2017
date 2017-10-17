public class ExceptionPractice {
	public static void main(String[] args) {
        //System.out.println(divideOneBy(0));
        /*
		try {
			System.out.println(divideOneBy(0));  //arithmetic exception 
		} catch (ArithmeticException e) {
			System.err.println("Don't divide by zero!"); //std err output
		} finally {
            //code here will always run 
            //the finally block is executed even if an unexpected exception occurs
            //put cleanup code here
            //avoids having cleanup code accidentally bypassed by a return, continue, or break
			System.out.println("Cleaning up stuff");
		}
        */
        //System.out.println(finallyDemo());

        
        try {
            method1();
            System.out.println("You won't see this output if method1() throws any exception!");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException from method1 caught");
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException from method1 caught");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            //functions like if statement logic, so go from most specific to least
            System.out.println("A generic exception occured");
        }
        
		System.out.println("Done!");
	}
    public static double divideOneBy (int divisor) {
        return 1/divisor;
    }
    public static String finallyDemo()
    {
       try {
            System.out.println("try");
            return "method returns";
       }
       finally {
            System.out.println("Inside Finally block");
       }
    }
    
    //throws Exception specifies that whenever method1 is called, 
    //Exceptions must be handled
    public static void method1() throws NullPointerException,
        StringIndexOutOfBoundsException, NumberFormatException {
        //NullPointerException an unchecked exception
        String nothing = null;
        System.out.println(nothing.length());

        //StringIndexOutOfBoundsException, a checked exception
        //String b = "blah";
        //System.out.println(b.charAt(10));

        //NumberFormatException, an unchecked exception
        //int num = Integer.parseInt ("not an int");
    }
}