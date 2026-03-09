import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GenericLinkedListStudentTest {

    private GenericLinkedList<String> list;

    @Before
    public void setUp() {
        list = new GenericLinkedList<>();
    }

    @Test
    public void testAddFirst() {
        list.addFirst("B");
        list.addFirst("A");

        assertEquals("A", list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    public void testAddLast() {
        list.addLast("A");
        list.addLast("B");

        assertEquals("B", list.getLast());
        assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals("B", list.get(1));
    }

    @Test
    public void testRemoveFirst() {
        list.addLast("A");
        list.addLast("B");

        String removed = list.removeFirst();

        assertEquals("A", removed);
        assertEquals(1, list.size());
        assertEquals("B", list.getFirst());
    }

    @Test
    public void testRemoveLast() {
        list.addLast("A");
        list.addLast("B");

        String removed = list.removeLast();

        assertEquals("B", removed);
        assertEquals(1, list.size());
    }

    @Test
    public void testContains() {
        list.addLast("A");
        list.addLast("B");

        assertTrue(list.contains("A"));
        assertFalse(list.contains("C"));
    }

    @Test
    public void testClear() {
        list.addLast("A");
        list.addLast("B");

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testIterator() {
        list.addLast("A");
        list.addLast("B");

        String result = "";

        for (String s : list) {
            result += s;
        }

        assertEquals("AB", result);
    }
}