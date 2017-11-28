import java.util.NoSuchElementException;
import java.util.Iterator;
/**
* MinionList class.
* @author mdalton31
* @version 1
*/
public class MinionList
    implements Iterable<Minion>, MinionQueue, MinionStack {

    private Node head;

    /**
     * Node class
     */
    private class Node {
        private Minion data;
        private Node next;

        public Node(Minion data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Create a default list
     */
    public MinionList() {
    }

    /**
     * Create a list from an array of Minions
     * @param minions initial contents of list to add
     */
    public MinionList(Minion[] minions) {
        for (int i = 0; i < minions.length; i++) {
            enqueue(minions[i]);
        }
    }

    /**
     * Checks if list is empty
     * @return true if this list has no elements, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * ------------------= Must be implemented recursively! =-------------------
     */
    /**
     * Finds and returns the Minion at specified index i
     * @param i specified index
     * @throws IndexOutOfBoundsException if i is < 0 or >= size
     * @return Minion at specified index
     */
    public Minion get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return recGet(i, head);
    }
    /**
     * Recursive helper for get method
     * @param i current index
     * @param current node being traversed
     * @return recursive call until Minion at specified index
     */
    private Minion recGet(int i, Node current) {
        if (i == 0) {
            return current.data;
        }
        return recGet(--i, current.next);
    }

    /**
     * @return String representation of the list in this format:
     * [minion1,minion2,minion3,]
     */
    @Override
    public String toString() {
        return recToString(new StringBuilder("["), head).toString();
    }
    /**
     * Recursive helper for toString method
     * @param result current state of StringBuilder output
     * @param current node being traversed
     * @return recursive call until Minion at specified index
     */
    private StringBuilder recToString(StringBuilder result, Node current) {
        if (current == null) {
            return result.append("]");
        }
        result.append(current.data);
        result.append(",");
        return recToString(result, current.next);
    }
    /**
     * @return this MinionList but in reverse
     */
    public MinionList reverse() {
        return recReverse(new MinionList(), head);
    }
    /**
     * Recursive helper for reverse method
     * @param currList current state of list being reversed
     * @param current node being traversed
     * @return recursive call until all Nodes counted
     */
    private MinionList recReverse(MinionList currList, Node current) {
        if (current == null) {
            return currList;
        }
        currList.push(current.data);
        return recReverse(currList, current.next);
    }
    /**
     * @return the number of elements in the MinionList
     */
    public int size() {
        return recSize(0, head);
    }
    /**
     * Recursive helper for size method
     * @param size current size value
     * @param current node being traversed
     * @return recursive call until all Nodes counted
     */
    private int recSize(int size, Node current) {
        if (current == null) {
            return size;
        }
        return recSize(++size, current.next);
    }

    /**
     * -----------------------= Methods from MinionQueue =----------------------
     */
    /**
     * Add a Minion to the back of the queue.
     *
     * @param m the Minion to add.
     * @throws IllegalArgumentException if Minion is null
     * adds to end of LinkedList
     */
    public void enqueue(Minion m) throws IllegalArgumentException {
        if (m == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(m, null);
        if (head == null) {
            head = newNode;
        } else {
            //find tail
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
        }


    }

    /**
     * Remove a Minion from the queue.
     *
     * @return the Minion from the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty
     * removes head of LinkedList
     */
    public Minion dequeue() throws java.util.NoSuchElementException {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        Node temp = head;
        head = head.next;
        return temp.data;
    }

    /**
     * -----------------------= Methods from MinionStack =----------------------
     */
    /**
     * Push a Minion on to the stack.
     *
     * @param m the Minion to push.
     * @throws IllegalArgumentException if data is null.
     * adds to head of LinkedList
     */
    public void push(Minion m) throws IllegalArgumentException {
        if (m == null) {
            throw new IllegalArgumentException();
        }
        Node newNode;
        if (head == null) {
            newNode = new Node(m, null);
        } else {
            newNode = new Node(m, head);
        }
        head = newNode;
    }

    /**
     * Pop from the stack.
     *
     * @return the Minion from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty.
     * Removes head of LinkedList
     */
    public Minion pop() throws java.util.NoSuchElementException {
        dequeue();
    }

    /**
     * iterator method -- called by Java when MinionList used
     * in an enhanced for loop
     * @return MinionListIterator
     */
    public Iterator<Minion> iterator() {
        return new MinionListIterator();
    }

    class MinionListIterator implements Iterator<Minion> {
        //the current element
        private Node currentNode = head;

        /**
         * @return whether or not there are more elements in the array that
         * have not been iterated over
         */
        public boolean hasNext() {
            return (currentNode != null);
        }

        /**
         * @return the next element of the iteration and move the current
         * index to the element after that
         */
        public Minion next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node temp = currentNode;
            currentNode = currentNode.next;
            return temp.data;
        }
    }
}