import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.stack.Stack;

/**
 * JUnit test fixture for {@code Stack<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class StackTest {

    /**
     * Invokes the appropriate {@code Stack} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new stack
     * @ensures constructorTest = <>
     */
    protected abstract Stack<String> constructorTest();

    /**
     * Invokes the appropriate {@code Stack} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new stack
     * @ensures constructorRef = <>
     */
    protected abstract Stack<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Stack<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsTest = [entries in args]
     */
    private Stack<String> createFromArgsTest(String... args) {
        Stack<String> stack = this.constructorTest();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /**
     *
     * Creates and returns a {@code Stack<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsRef = [entries in args]
     */
    private Stack<String> createFromArgsRef(String... args) {
        Stack<String> stack = this.constructorRef();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    // TODO - add test cases for constructor, push, pop, and length

    @Test
    public final void testDefaultConstructor() {
        Stack<String> s = this.constructorTest();
        Stack<String> sExpected = this.constructorRef();

        assertEquals(s, sExpected);
    }

    @Test
    public final void testNonEmptyConstructor() {
        Stack<String> s = this.createFromArgsTest("a", "b", "c");
        Stack<String> sExpected = this.createFromArgsRef("a", "b", "c");

        assertEquals(s, sExpected);
    }

    @Test
    public final void testNonEmptyLength() {
        Stack<String> s = this.createFromArgsTest("a", "b", "c");
        Stack<String> sExpected = this.createFromArgsRef("a", "b", "c");

        assertEquals(3, s.length());
        assertEquals(s, sExpected);
    }

    @Test
    public final void testEmptyLength() {
        Stack<String> s = this.createFromArgsTest();
        Stack<String> sExpected = this.createFromArgsRef();

        assertEquals(0, s.length());
        assertEquals(s, sExpected);
    }

    @Test
    public final void testNonEmptyPush() {
        Stack<String> s = this.createFromArgsTest("b", "c");
        Stack<String> sExpected = this.createFromArgsRef("a", "b", "c");

        s.push("a");
        assertEquals(s, sExpected);
    }

    @Test
    public final void testEmptyPush() {
        Stack<String> s = this.createFromArgsTest();
        Stack<String> sExpected = this.createFromArgsRef("a");

        s.push("a");
        assertEquals(s, sExpected);
    }

    @Test
    public final void testNonEmptyPop() {
        Stack<String> s = this.createFromArgsTest("a", "b", "c");
        Stack<String> sExpected = this.createFromArgsRef("b", "c");

        String x = s.pop();

        assertEquals("a", x);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testEmptyPop() {
        Stack<String> s = this.createFromArgsTest("a");
        Stack<String> sExpected = this.createFromArgsRef();

        String x = s.pop();

        assertEquals("a", x);
        assertEquals(s, sExpected);
    }
}
