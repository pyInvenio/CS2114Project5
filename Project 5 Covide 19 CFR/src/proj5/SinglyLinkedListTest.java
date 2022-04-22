package prj5;

import java.util.Comparator;
import java.util.Iterator;

public class SinglyLinkedListTest extends student.TestCase{
    private SinglyLinkedList<String> list;

    public void setUp(){
        list = new SinglyLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("Str" + i);
        }
    }
    public void testSize(){
        assertEquals(10, list.size());
    }
    /**
     * This method is test adding an object to the list at an index
     */
    public void testAddIndex(){
        list.add(0, "Str0");
        assertEquals(11, list.size());
        assertEquals("Str0", list.get(0));
        IllegalArgumentException illegal = null;
        try{
            list.add(0, null);
        }
        catch(IllegalArgumentException e){
            illegal = e;
        }
        assertNotNull(illegal);
        IndexOutOfBoundsException out = null;
        try{
            list.add(-1, "Str0");
        }
        catch(IndexOutOfBoundsException e){
            out = e;
        }
        assertNotNull(out);
        out = null;
        try{
            list.add(12, "Str0");
        }
        catch(IndexOutOfBoundsException e){
            out = e;
        }
        assertNotNull(out);
        list.add(6, "Str6");
        assertEquals("Str6", list.get(6));
        assertEquals(12, list.size());
    }

    public void testAdd(){
        list.add("Str0");
        assertEquals(11, list.size());
        assertEquals("Str0", list.get(10));
        IllegalArgumentException illegal = null;
        try{
            list.add(null);
        }
        catch(IllegalArgumentException e){
            illegal = e;
        }
        assertNotNull(illegal);
    }

    public void testRemoveIndex(){
        assertTrue(list.remove(0));
        assertEquals(9, list.size());
        assertEquals("Str1", list.get(0));
        IndexOutOfBoundsException out = null;
        try{
            list.remove(-1);
        }
        catch(IndexOutOfBoundsException e){
            out = e;
        }
        assertNotNull(out);
        out = null;
        try{
            list.remove(10);
        }
        catch(IndexOutOfBoundsException e){
            out = e;
        }
        assertNotNull(out);
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>();
        assertFalse(empty.remove(0));
    }

    public void testRemove(){
        assertTrue(list.remove("Str0"));
        assertEquals(9, list.size());
        assertEquals("Str1", list.get(0));
        assertFalse(list.remove("Str0"));
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>();
        assertFalse(empty.remove("Str0"));
        IllegalArgumentException illegal = null;
        try
        {
            list.remove(null);
        }
        catch(IllegalArgumentException e)
        {
            illegal = e;
        }
        assertNotNull(illegal);

    }

    public void testGet(){
        assertEquals("Str0", list.get(0));
        assertEquals("Str9", list.get(9));
        IndexOutOfBoundsException out = null;
        try{
            list.get(-1);
        }
        catch(IndexOutOfBoundsException e){
            out = e;
        }
        assertNotNull(out);
        out = null;
        try{
            list.get(10);
        }
        catch(IndexOutOfBoundsException e){
            out = e;
        }
        assertNotNull(out);
    }

    public void testContains(){
        assertTrue(list.contains("Str0"));
        assertTrue(list.contains("Str9"));
        assertFalse(list.contains("Str10"));
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>();
        assertFalse(empty.contains("Str0"));
        assertFalse(list.contains(null));
    }
    public void testIsEmpty(){
        assertFalse(list.isEmpty());
        SinglyLinkedList<String> empty = new SinglyLinkedList<String>();
        assertTrue(empty.isEmpty());
    }
    public void testClear(){
        list.clear();
        assertEquals(0, list.size());
    }
    public void testToArray(){
        Object[] array = list.toArray();
        assertEquals(10, array.length);
        for (int i = 0; i < 10; i++) {
            assertEquals("Str" + i, array[i]);
        }
    }
    public void testIterator(){
        Iterator<String> iter = list.iterator();
        for (int i = 0; i < 10; i++) {
            assertTrue(iter.hasNext());
            assertEquals("Str" + i, iter.next());
        }
        assertFalse(iter.hasNext());
    }

    public void testInsertionSort(){
        SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
        list2.add("J");
        list2.add("I");
        list2.add("H");
        list2.add("G");
        list2.add("F");
        list2.add("E");
        list2.add("D");
        list2.add("C");
        list2.add("B");
        list2.add("A");
        Comparator<String> c = Comparator.comparing(String::toString);
        list2.insertionSort(c);
        assertEquals("A", list2.get(0));
        assertEquals("B", list2.get(1));
        assertEquals("C", list2.get(2));
        assertEquals("D", list2.get(3));
        assertEquals("E", list2.get(4));
        assertEquals("F", list2.get(5));
        assertEquals("G", list2.get(6));
        assertEquals("H", list2.get(7));
        assertEquals("I", list2.get(8));
        assertEquals("J", list2.get(9));
    }

}
