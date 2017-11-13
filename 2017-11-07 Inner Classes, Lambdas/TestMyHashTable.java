public class TestMyHashTable {
    public static void main(String[] args) {
        // Hashtable with 2 bins
        MyHashTable<String> twoBinTable = new MyHashTable<>(2);
        // The 24 greek letters as strings
        String[] greekLetters = new String[]{"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta", "iota", "kappa", "lambda", "mu", "nu", "xi", "omicron", "pi", "rho", "sigma", "tau", "upsilon", "phi", "chi", "psi", "omega"};
        twoBinTable.addAll(greekLetters);

        System.out.println("Size of hashTable: " + twoBinTable.size());
        System.out.println("The hashTable: " + twoBinTable + "\n");
        System.out.println(twoBinTable.printByBin());
        System.out.println(twoBinTable.printHashCodeByBin());

        System.out.println("Trying to remove delta returns: " + twoBinTable.remove("delta"));
        System.out.println("Trying to remove a non-greek letter returns: " + twoBinTable.remove("zzz"));
        System.out.println("The hashTable now: " + twoBinTable);
        System.out.println("Size of hashTable: " + twoBinTable.size());
    }
}