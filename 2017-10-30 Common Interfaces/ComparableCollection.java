import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * @author mdalton31
 * @version 1.0
 * @param <T> type that extends Comparable to be stored
 */
public class ComparableCollection<T extends Comparable<T>>
    implements CollectionInterface<T>, Iterable<T> {
    /**
     * instance vars
     */
    private Comparable[] values;

    /**
     * No-args Constructor
     * creates backing array of initial size 5
     */
    public ComparableCollection() {
        this.values = new Comparable[5];
    }

    /**
     * Constructor
     * @param values initial elements to put in ComparableCollection
     */
    public ComparableCollection(Comparable[] values) {
        this.values = values;
    }

    /**
     * Adds an element into the collection.
     * If the new element would exceed the size of the backing array,
     * instead resize the array, doubling it in size and copy over the
     * old elements.
     *
     * @param elem The element being added.
     */
    public void add(T elem) {
        if (elem != null) {
            int size = this.size();
            if (size >= this.capacity()) {
                //resize backing array if full
                Comparable[] replace = new Comparable[this.values.length * 2];
                for (int i = 0; i < this.values.length; i++) {
                    replace[i] = this.values[i];
                }
                values = replace;
            }
            this.values[size] = elem;
        }
    }

    /**
     * Adds all elements in elems to the collection.
     *
     * @param elems Array of elements to be added.
     */
    public void addAll(T[] elems) {
        for (T elem : elems) {
            this.add(elem);
        }
    }

    /**
     * Remove elem from the collection. Removing an element
     * should shift all the elements behind it forward, ensuring
     * that the backing array is contiguous. For example:
     *
     * Collection = ["hi", "hello", "wsup", "hey", null]
     * Collection after remove("hello") = ["hi", "wsup", "hey", null, null]
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    public boolean remove(T elem) {
        if (elem == null || !(this.contains(elem))) {
            return false;
        }
        int ndx = this.find(elem);
        int last = this.size() - 1;
        values[ndx] = null;
        if (ndx < last) {
            //if anything other than last removed, null has to be
            //shifted back to end
            for (int i = ndx; i < (this.values.length - 1); i++) {
                values[i] = values[i + 1];
            }
            values[last] = null;
        }
        return true;
    }

    /**
     * Removes each element in elems from the collection.
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    public boolean removeAll(T[] elems) {
        boolean any = false;
        for (T elem : elems) {
            //this.remove(elem) must come first to avoid short circuit!
            any = this.remove(elem) || any;
        }
        return any;
    }

    /**
     * Checks to see if the collection contains a given element.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    public boolean contains(T elem) {
        for (Comparable currValue : values) {
            if (currValue != null
                && currValue.equals(elem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is within our backing array but more than our last
     * element, rather than returning null, this should throw
     * a java.util.NoSuchElementException.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     * @throws NoSuchElementException if index is in bounds but after
     * element
     */
    public T get(int index) throws NoSuchElementException {
        if (values[index] != null) {
            return (T) values[index];
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    public int size() {
        int size = 0;
        for (Comparable currVal : values) {
            if (currVal != null) {
                size++;
            }
        }
        return size;
    }

    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    public int capacity() {
        return this.values.length;
    }

    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    public void clear() {
        this.values = new Comparable[5];
    }

    /**
     * Tests if the collection is empty, i.e. it contains no elements.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return values[0] == null;
    }

    /**
     * While having toString be defined in the interface doesn't force you
     * to override the method in the implementing class, the format we
     * expect the toString() is as follows:
     *
     * [element1, element2, element3, ..., elementN]
     *
     * The end of the list should not contain any nulls, even if the
     * backing array is larger than the number of elements.
     *
     * @return [element1, element2, element3, ..., elementN]
     */
    public String toString() {
        String out = "[";
        for (int i = 0; i < this.capacity(); i++) {
            if (this.values[i] != null) {
                out += this.values[i].toString() + ", ";
            }
        }
        return out.substring(0, out.length() - 2) + "]";
    }

    /**
     * find the first occurence of an element
     * @param elem value to look for
     * @return index of elem, -1 if not found
     */
    public int find(T elem) {
        int ndx = -1;
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] != null
                && this.values[i].equals(elem)) {
                ndx = i;
                //break insures first occurence is found
                break;
            }
        }
        return ndx;
    }

    /**
     * iterator method -- called by Java when ComparableCollection used
     * in an enhanced for loop
     * @return ComparableCollectionIterator
     */
    public Iterator<T> iterator() {
        return new ComparableCollectionIterator();
    }

    //nested class, therefore has access to this.*
    class ComparableCollectionIterator implements Iterator<T> {
        //the current element
        private int current = 0;

        /**
         * @return whether or not there are more elements in the array that
         * have not been iterated over
         */
        public boolean hasNext() {
            if (current < ComparableCollection.this.size()) {
                return true;
            }
            return false;
        }

        /**
         * @return the next element of the iteration and move the current
         * index to the element after that
         */
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) values[current++];
        }
    }
}