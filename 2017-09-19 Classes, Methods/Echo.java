public class Echo {
	public static void main (String[] args) {
		for (String s : args) {
                //print formatted with 2 decimal places (%.2) then return (%n)
				System.out.printf("I have $%.2f dollars %s %n", Double.parseDouble(s), s);
                //Note: Integer.parseInt(<your string>) can be used for integers
		}
	}
}