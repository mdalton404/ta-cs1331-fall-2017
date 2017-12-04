public class RecursionExamples {
    /**
        the factorial of a non-negative integer n, denoted by n!, is the product of all positive integers less than or equal to n
        e.g. 5! = 5 * 4 * 3 * 2 * 1 = 120
        Note: 0! = 1 becuase an empty set can only be arranged one way (not important to know just a side note)
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    /**
        The Fibonacci sequence is characterized by the fact that every number after the first two is the sum of the two preceding
        F0	F1	F2	F3	F4	F5	F6	F7	F8	F9	F10	F11	F12	F13	F14	F15	F16	F17	 F18  F19  F20
        0	1	1	2	3	5	8	13	21	34	55	89	144	233	377	610	987	1597 2584 4181 6765
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fibonacci(3));
    }
}