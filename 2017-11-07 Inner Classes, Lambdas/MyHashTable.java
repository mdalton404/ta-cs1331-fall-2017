import java.util.LinkedList;
/**
 * @author mdalton31
 * @version 1.0
 * @param <E> type of elements to be stored in MyHashTable
 */
public class MyHashTable<E> {
    //array of LinkedLists of type E to back MyHashTable
    private LinkedList<E>[] bins;

    public MyHashTable(int size) {
        bins = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            bins[i] = new LinkedList<>();
        }
    }

    public void addAll(E[] toAdd) {
        for (E e : toAdd) {
            add(e);
        }
    }

    public void removeAll(E[] toRemove) {
        for (E e : toRemove) {
            remove(e);
        }
    }

    public void add(E toAdd) {
        int binNdx = Math.abs(toAdd.hashCode()) % bins.length;
        bins[binNdx].add(toAdd);
    }

    public boolean remove(E toRemove) {
        int binNdx = Math.abs(toRemove.hashCode()) % bins.length;
        return bins[binNdx].remove(toRemove);
    }

    public String toString() {
        StringBuilder out = new StringBuilder("[");
        for (LinkedList<E> currBin : bins) {
            for (E currE : currBin) {
                out.append(currE);
                out.append(",");
            }
        }
        //remove last comma
        out.setLength(out.length() - 1);
        return out + "]";
    }

    public int size() {
        int count = 0;
        for (LinkedList<E> currBin : bins) {
            for (E currE : currBin) {
                count++;
            }
        }
        return count;
    }

    public String printByBin() {
        StringBuilder out = new StringBuilder("Bin 0\n[");
        int currBinNdx = 0;
        for (LinkedList<E> currBin : bins) {
            for (E currE : currBin) {
                out.append(currE);
                out.append(",");
            }
            currBinNdx++;
            out.append("]\nBin " + currBinNdx + "\n[");
        }
        String outString = out.toString();
        //trim off last bin label (does not exist) and return
        out.setLength(out.length() - 8);
        return out.toString();
    }

    public String printHashCodeByBin() {
        StringBuilder out = new StringBuilder("Bin 0\n[");
        int currBinNdx = 0;
        for (LinkedList<E> currBin : bins) {
            for (E currE : currBin) {
                out.append(currE.hashCode());
                out.append(",");
            }
            currBinNdx++;
            out.append("]\nBin " + currBinNdx + "\n[");
        }
        //trim off last bin label (does not exist) and return
        out.setLength(out.length() - 8);
        String outString = out.toString();
        return out.toString();
    }
}