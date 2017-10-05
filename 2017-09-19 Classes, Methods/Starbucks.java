/**
 * Class representation of Starbucks
 * @author Isabella Plonk
 * @version 1.0
 */
public class Starbucks {

    public static void main(String[] args) {

        // Create PSL objects
        PSL psl1 = new PSL("Ezabila");
        PSL psl2 = new PSL("Mat", "Venti", true);
        PSL psl3 = new PSL("Cark");
        PSL psl4 = new PSL("Pawl", "Grande", false);
        PSL psl5 = new PSL("Ezabila", "Venti", false);

        // Store PSL objects into an array
        PSL[] drinks = {psl1, psl2, psl3, psl4, psl5};

        // Print out each PSL object in the array
        for (int i = 0; i < PSL.getNumberSold(); ++i) {
            System.out.println(drinks[i]);
        }

        // Use getters and setters
        // System.out.println(drinks[1].getName());
        // drinks[1].setName("Matt");
        // System.out.println(drinks[1].getName());

        // Checking equality
        // System.out.println(drinks[0].equals(drinks[1]));
        // System.out.println(drinks[0].equals(drinks[4]));
    }
}