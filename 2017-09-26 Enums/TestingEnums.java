public class TestingEnums {
    public static void main(String[] args) {
        System.out.println(CardinalDirection.WEST.ordinal());
        for (CardinalDirection d : CardinalDirection.values()) {
            System.out.println(d.printAbbr());
        }
    }
}