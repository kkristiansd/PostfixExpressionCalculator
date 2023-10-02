import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;
public class unitTestStack {
    private LinkedList<Integer> stack;

    @Before
    public void setUp() {
        stack = new LinkedList<>();
    }

    @Test
    public void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(42);
        assertEquals(Integer.valueOf(42), stack.peek());

        stack.push(99);
        assertEquals(Integer.valueOf(99), stack.peek());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(5);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopOnEmptyStack() {
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekOnEmptyStack() {
        stack.peek();
    }
}
