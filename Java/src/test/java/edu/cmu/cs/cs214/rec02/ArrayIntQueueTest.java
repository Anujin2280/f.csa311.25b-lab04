package edu.cmu.cs.cs214.rec02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ArrayIntQueueTest {
    private ArrayIntQueue queue;

    @Before
    public void setUp() {
        queue = new ArrayIntQueue();
    }

    @Test
    public void testClear() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.clear();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
        assertNull(queue.dequeue());
    }

    @Test
    public void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    public void testEnqueue() {
        assertTrue(queue.enqueue(1));
        assertTrue(queue.enqueue(2));
        assertTrue(queue.enqueue(3));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeek() {
        assertNull(queue.peek());
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(Integer.valueOf(10), queue.peek());
        queue.dequeue();
        assertEquals(Integer.valueOf(20), queue.peek());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
    }

    @Test
    public void testEnsureCapacity() {
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }

        assertEquals(15, queue.size());

        for (int i = 0; i < 15; i++) {
            assertEquals(Integer.valueOf(i), queue.dequeue());
        }

        assertTrue(queue.isEmpty());
    }
}
