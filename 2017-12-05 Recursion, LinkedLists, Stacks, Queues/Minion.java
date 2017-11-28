import java.util.Comparator;
/**
* MinionList class.
* @author mdalton31
* @version 1
*/
public class Minion implements Comparable<Minion> {
    /**
     * instance vars
     */
    private String name;
    private double height;
    private int iQLevel;

    /**
     * Constructor
     * @param name name to pass
     * @param height height to pass
     * @param iQLevel iQLevel to pass
     */
    public Minion(String name, double height, int iQLevel) {
        this.name = name;
        this.height = height;
        this.iQLevel = iQLevel;
    }

    /**
     * equals method overriden from Object
     * @param o Object to be compared
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Minion)) {
            return false;
        }
        Minion m = (Minion) o;
        boolean check = m.name.equals(name); // -5 for use of ==
        check = m.height == height && check;
        check = m.iQLevel == iQLevel && check;
        return check;
    }

    /**
     * hashCode method overriden from Object
     * @return hashCode of this
     */
    @Override
    public int hashCode() {
        int hash = 17;
        if (name != null) {
            hash = 31 * hash + name.hashCode();
        } else {
            hash = 31 * hash;
        }
        long h = Double.doubleToLongBits(height);
        hash = 31 * hash + (int) (h ^ (h >>> 32));
        hash = 31 * hash + iQLevel;
        return hash;
    }

    /**
     * toString method overriden from Object
     * @return String in the format:
     * name has IQ of iQLevel and height of height cm.
     * with height rounded to 2 decimal places
     */
    @Override
    public String toString() {
        return String.format("%s has IQ of %d and height of %.2f cm.",
            name, iQLevel, height);
    }
    /**
     * natural ordering of Minion is by name
     * @param m Minion to compare this to
     * @return -1 if this.name comes after m.name,
     *      1 if this.name is before m.name,
     *      0 if this.name equals m.name
     */
    public int compareTo(Minion m) {
        return name.compareTo(m.name);
    }

    /**
     * @return HeightComparator
     */
    public Comparator<Minion> compareByHeight() {
        return new HeightComparator();
    }

    /**
     * @return IQComparator
     */
    public Comparator<Minion> compareByIQ() {
        return new IQComparator();
    }

    /**
    * Comparator for specifying ordering by height
    */
    private class HeightComparator implements Comparator<Minion> {
        public int compare(Minion a, Minion b) {
            if (a.height < b.height) {
                return -1;
            } else if (a.height > b.height) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
    * Comparator for specifying ordering by iQLevel
    */
    class IQComparator implements Comparator<Minion> {
        public int compare(Minion a, Minion b) {
            return a.iQLevel - b.iQLevel;
        }
    }
}