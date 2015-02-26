import components.stack.StackSecondary;

/**
 * {@code Stack} represented as a singly linked list, done "bare-handed", with
 * implementations of primary methods.
 *
 * <p>
 * Execution-time performance of all methods implemented in this class is O(1).
 *
 * @param <T>
 *            type of Stack entries
 * @convention <pre>
 * $this.length >= 0  and
 * if $this.length == 0 then
 *   [$this.top is null]
 * else
 *   [$this.top is not null]  and
 *   [$this.top points to the first node of a singly linked list
 *    containing $this.length nodes]  and
 *   [next in the last node of that list is null]
 * </pre>
 * @correspondence this = [data in $this.length nodes starting at $this.top]
 */
public abstract class Stack2<T> extends StackSecondary<T> {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Node class for singly linked list nodes.
     */
    private final class Node {

        /**
         * Data in node.
         */
        private T data;

        /**
         * Next node in singly linked list, or null.
         */
        private Node next;

    }

    /**
     * Top node of singly linked list.
     */
    private Node top;

    /**
     * Number of nodes in singly linked list, i.e., length = |this|.
     */
    private int length;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.top = new Node();
        this.top.next = null;
        this.length = 0;

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * Default constructor.
     */
    public Stack2() {
        this.createNewRep();
    }

    /*
     * Standard methods removed to reduce clutter...
     */

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void push(T x) {
        assert x != null : "Violation of: x is not null";

        this.length++;
        Node p = this.top;
        Node q = new Node();
        q.data = x;
        q.next = p;
        this.top = q;

    }

    @Override
    public final T pop() {
        assert this.length() > 0 : "Violation of: this /= <>";

        this.length--;
        Node p = this.top;
        Node q = this.top.next;
        T data = p.data;
        this.top = q;
        return data;

    }

    @Override
    public final int length() {

        return this.length;

    }

    /*
     * Iterator code removed to reduce clutter...
     */

}
