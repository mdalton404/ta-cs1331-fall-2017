import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        MinionList list = new MinionList();
        list.enqueue(new Minion("Bob", 1.0, 130));
        list.enqueue(new Minion("Tim", 1.1, 120));
        list.enqueue(new Minion("Jay", 1.2, 110));
        list.enqueue(new Minion("Ned", 1.3, 100));
        list.enqueue(new Minion("Ned", 1.3, 100));
        System.out.println(list);

        System.out.println("");

        for (Minion m : list) {
            System.out.println(m);
        }

        System.out.println("");

        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.reverse());

        System.out.println("");

        System.out.println((list.get(0)).equals(list.get(4)));
        System.out.println((list.get(3)).equals(list.get(4)));
        System.out.println((list.get(0)).hashCode());
        System.out.println((list.get(3)).hashCode());
        System.out.println((list.get(4)).hashCode());

        Comparator<Minion> ciq = list.get(0).compareByIQ();
        Comparator<Minion> ch = list.get(0).compareByHeight();

        System.out.println((list.get(4)).compareTo(list.get(0)));
        System.out.println(ciq.compare(list.get(4), list.get(0)));
        System.out.println(ch.compare(list.get(4), list.get(0)));

        System.out.println("");

        ArrayList<Minion> ma = new ArrayList<>();
        ma.add(new Minion("Bob", 1.0, 130));
        ma.add(new Minion("Tim", 1.1, 120));
        ma.add(new Minion("Jay", 1.2, 110));
        ma.add(new Minion("Ned", 1.3, 100));
        ma.add(new Minion("Ned", 1.3, 100));

        System.out.println("Unsorted:\n" + ma);
        Collections.sort(ma);
        System.out.println("\nSorted natural order:\n" + ma);
        Collections.sort(ma, list.get(0).compareByHeight());
        System.out.println("\nSorted by height:\n" + ma);
        Collections.sort(ma, list.get(0).compareByIQ());
        System.out.println("\nSorted by IQ:\n" + ma);
    }
}