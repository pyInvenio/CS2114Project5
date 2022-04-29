package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 *  Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
 * 
 * This is the class for testing SinglyLinkedList
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 * 
 */
public class SinglyLinkedListTest extends student.TestCase {
    /**
     * Fields
     */
    private SinglyLinkedList<String> list;

    /**
     * Sets up before tests
     */
    public void setUp() {
        list = new SinglyLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("Str" + i);
        }
    }


    /**
     * tests size()
     */
    public void testSize() {
        assertEquals(10, list.size());
    }


    /**
     * This method is test adding an object to the list at an index
     */
    public void testAddIndex() {
        list.add(0, "Str0");
        assertEquals(11, list.size());
        assertEquals("Str0", list.get(0));
        IllegalArgumentException illegal = null;
        try {
            list.add(0, null);
        }
        catch (IllegalArgumentException e) {
            illegal = e;
        }
        assertNotNull(illegal);
        IndexOutOfBoundsException out = null;
        try {
            list.add(-1, "Str0");
        }
        catch (IndexOutOfBoundsException e) {
            out = e;
        }
        assertNotNull(out);
        out = null;
        try {
            list.add(12, "Str0");
        }
        catch (IndexOutOfBoundsException e) {
            out = e;
        }
        assertNotNull(out);
        list.add(6, "Str6");
        assertEquals("Str6", list.get(6));
        assertEquals(12, list.size());
    }


    /**
     * tests add()
     */
    public void testAdd() {
        list.add("Str0");
        assertEquals(11, list.size());
        assertEquals("Str0", list.get(10));
        IllegalArgumentException illegal = null;
        try {
            list.add(null);
        }
        catch (IllegalArgumentException e) {
            illegal = e;
        }
        assertNotNull(illegal);
    }


    /**
     * tests remove at index
     */
    public void testRemoveIndex() {
        assertTrue(list.remove(0));
        assertEquals(9, list.size());
        assertEquals("Str1", list.get(0));
        IndexOutOfBoundsException out = null;
        try {
            list.remove(-1);
        }
        catch (IndexOutOfBoundsException e) {
            out = e;
        }
        assertNotNull(out);
        out = null;
        try {
            list.remove(10);
        }
        catch (IndexOutOfBoundsException e) {
            out = e;
        }
        assertNotNull(out);
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>();
        assertFalse(empty.remove(0));
        assertTrue(list.remove(5));
    }


    /**
     * tests remove()
     */
    public void testRemove() {
        assertTrue(list.remove("Str0"));
        assertEquals(9, list.size());
        assertEquals("Str1", list.get(0));
        assertFalse(list.remove("Str0"));
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>();
        assertFalse(empty.remove("Str0"));
        IllegalArgumentException illegal = null;
        try {
            list.remove(null);
        }
        catch (IllegalArgumentException e) {
            illegal = e;
        }
        assertNotNull(illegal);
        assertTrue(list.remove("Str5"));

    }


    /**
     * tests get()
     */
    public void testGet() {
        assertEquals("Str0", list.get(0));
        assertEquals("Str9", list.get(9));
        IndexOutOfBoundsException out = null;
        try {
            list.get(-1);
        }
        catch (IndexOutOfBoundsException e) {
            out = e;
        }
        assertNotNull(out);
        out = null;
        try {
            list.get(10);
        }
        catch (IndexOutOfBoundsException e) {
            out = e;
        }
        assertNotNull(out);
    }


    /**
     * tests contains object
     */
    public void testContains() {
        assertTrue(list.contains("Str0"));
        assertTrue(list.contains("Str9"));
        assertFalse(list.contains("Str10"));
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>();
        assertFalse(empty.contains("Str0"));
        assertFalse(list.contains(null));
    }


    /**
     * tests isEmpty()
     */
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>();
        assertTrue(empty.isEmpty());
    }


    /**
     * tests clear()
     */
    public void testClear() {
        list.clear();
        assertEquals(0, list.size());
    }


    /**
     * tests toArray()
     */
    public void testToArray() {
        Object[] array = list.toArray();
        assertEquals(10, array.length);
        for (int i = 0; i < 10; i++) {
            assertEquals("Str" + i, array[i]);
        }
    }


    /**
     * tests equals()
     */
    public void testEquals() {
        SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            list2.add("Str" + i);
        }
        assertTrue(list.equals(list2));
        SinglyLinkedList<String> list3 = new SinglyLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            list3.add("Str" + (i + 1));
        }

        assertFalse(list.equals(list3));
        list3.add("Str10");
        assertFalse(list.equals(list3));
        assertFalse(list.equals(null));
        assertTrue(list.equals(list));
        assertFalse(list.equals("Str"));
    }


    /**
     * tests iterator()
     */
    public void testIterator() {
        Iterator<String> iter = list.iterator();
        for (int i = 0; i < 10; i++) {
            assertTrue(iter.hasNext());
            assertEquals("Str" + i, iter.next());
        }
        assertFalse(iter.hasNext());
        NoSuchElementException out = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException e) {
            out = e;
        }
        assertNotNull(out);
        Iterator<String> iter2 = list.iterator();
        IllegalStateException illegal = null;
        try {
            iter2.remove();
        }
        catch (IllegalStateException e) {
            illegal = e;
        }
        assertNotNull(illegal);
        iter2.next();
        iter2.remove();
        assertEquals(9, list.size());
    }


    /**
     * tests sorting
     */
    public void testInsertionSort() {
        SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        list2.add("E");
        list2.add("F");
        list2.add("G");
        list2.add("H");
        list2.add("I");
        list2.add("J");
        Comparator<String> c = Comparator.comparing(String::toString);
        list2.insertionSort(c);
        assertEquals("J", list2.get(0));
        assertEquals("I", list2.get(1));
        assertEquals("H", list2.get(2));
        assertEquals("G", list2.get(3));
        assertEquals("F", list2.get(4));
        assertEquals("E", list2.get(5));
        assertEquals("D", list2.get(6));
        assertEquals("C", list2.get(7));
        assertEquals("B", list2.get(8));
        assertEquals("A", list2.get(9));
    }

}