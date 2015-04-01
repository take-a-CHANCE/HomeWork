import java.util.Comparator;

import components.queue.Queue;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author Chance Davis
 */
public final class HelloWorld {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HelloWorld() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("Hello World!");
        out.close();
    }

    /**
     * Inserts the given {@code T} in the {@code Queue<T>} sorted according to
     * the given {@code Comparator<T>} and maintains the {@code Queue<T>}
     * sorted.
     *
     * @param <T>
     *            type of {@code Queue} entries
     * @param q
     *            the {@code Queue} to insert into
     * @param x
     *            the {@code T} to insert
     * @param order
     *            the {@code Comparator} defining the order for {@code T}
     * @updates q
     * @requires <pre>
     * IS_TOTAL_PREORDER([relation computed by order.compare method])  and
     * IS_SORTED(q, [relation computed by order.compare method])
     * </pre>
     * @ensures <pre>
     * perms(q, #q * <x>)  and
     * IS_SORTED(q, [relation computed by order.compare method])
     * </pre>
     */
    private static <T> void insertInOrder(Queue<T> q, T x, Comparator<T> order) {
        boolean sorted = false;
        Queue<T> holder = q.newInstance();
        while (!sorted) {
            T deq = q.dequeue();
            //int z = compare(deq, x);
            if (0 > 0) {
                q.replaceFront(deq);
                q.replaceFront(x);
                sorted = true;
            } else {
                holder.enqueue(deq);
            }
        }
        holder.append(q);
        q.transferFrom(holder);
    }

//    /**
//     * Sorts {@code this} according to the ordering provided by the
//     * {@code compare} method from {@code order}.
//     *
//     * @param order
//     *            ordering by which to sort
//     * @updates this
//     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
//     * @ensures <pre>
//     * perms(this, #this)  and
//     * IS_SORTED(this, [relation computed by order.compare method])
//     * </pre>
//     */
//    public void sort(Comparator<T> order) {
//        Queue<T> sorted = this.newInstance();
//        while (this.size() > 0) {
//            insertInOrder(sorted, this.dequeue(), order);
//        }
//        this.transferFrom(sorted);
//    }

    /**
     * Evaluates a Boolean expression and returns its value.
     *
     * @param tokens
     *            the {@code Queue<String>} that starts with a bool-expr string
     * @return value of the expression
     * @updates tokens
     * @requires [a bool-expr string is a prefix of tokens]
     * @ensures <pre>
     * valueOfBoolExpr =
     *   [value of longest bool-expr string at start of #tokens]  and
     * #tokens = [longest bool-expr string at start of #tokens] * tokens
     * </pre>
     */
    public static boolean valueOfBoolExpr(Queue<String> tokens) {
        boolean result = false;

        String token = tokens.dequeue();
        if (token.charAt(0) == '(') {
            result = valueOfBoolExpr(tokens);
            String operator = tokens.dequeue();
            if (operator.equals("AND")) {
                result &= valueOfBoolExpr(tokens);
            } else if (operator.equals("OR")) {
                result |= valueOfBoolExpr(tokens);
            }
        } else if (token.equals("NOT")) {
            result = !valueOfBoolExpr(tokens);
        } else if (token.equals("T")) {
            result = true;
        } else if (token.equals("F")) {
            result = false;
        }

        return result;
    }
}
