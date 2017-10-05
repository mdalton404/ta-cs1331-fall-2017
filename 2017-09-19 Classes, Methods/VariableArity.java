public class VariableArity {
    public static void main(String[] args) {
        System.out.println(doMath("multiply",2,4,6));
        System.out.println(doMath("add",2,4,6,6,3,234,14));
        System.out.println(doMath("divide",22,2));
        System.out.println(doMath("foo"));
    } 
    public static int doMath(String operator, int...operands) {
        switch (operator) {
            case "add":
                int sum = 0;
                for(int i = 0; i < operands.length; i++) {
                    sum += operands[i];
                }
                return sum;
            case "divide":
                return operands[0] / operands[1];
            case "multiply":
                int product = 1;
                for(int i = 0; i < operands.length; i++) {
                    product *= operands[i];
                }
                return product;
            default:
                return Integer.MIN_VALUE;
        }
    }
}