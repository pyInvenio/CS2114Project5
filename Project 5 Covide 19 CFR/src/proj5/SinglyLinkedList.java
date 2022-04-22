package prj5;

import java.util.Comparator;
import java.util.Iterator;

/**
 * This class is to create a singly linked list with Node and Iterator nested
 * classes
 * 
 * @author Forrest Meng
 * @version 4/17/2022
 * @param <E> the type that is stored in the list
 */
public class SinglyLinkedList<E> implements Iterable<E> {

    /**
     * Fields
     */
    private Node<E> head;
    private int size;

    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;

    }

    /**
     * This method is to get the size of the list
     * 
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * This method is to add an object to the list at an index
     * 
     * @param index the index to add the object
     * @param obj   the object to add
     */
    public void add(int index, E obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        Node<E> current = head;
        if (isEmpty()) {
            head = new Node<E>(obj);
            size++;
        } else if (index == 0) {
            head = new Node<E>(obj, current);
            size++;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(new Node<E>(obj, current.getNext()));
            size++;
        }
    }

    /**
     * This method is to add an object to the list
     * 
     * @param obj the object to add to the list
     */
    public void add(E obj) {
        add(size, obj);
    }

    /**
     * This method is to remove an object from a list
     * 
     * @param obj the object to find and remove
     * @return true if the object is removed, false if not
     */
    public boolean remove(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            return false;
        }
        Node<E> current = head;
        Node<E> previous = null;
        while (current != null) {
            if (current.getData().equals(obj)) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    /**
     * This method is to remove an object at a certain index
     * 
     * @param index the index to remove the object at
     * @return true if the removal is successful, false if not
     */
    public boolean remove(int index) {
        if (isEmpty()) {
            return false;
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = head;
        Node<E> previous = null;
        if (index == 0) {
            head = current.getNext();
        } else {
            for (int i = 0; i < index - 1; i++) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(current.getNext());
        }
        size--;
        return true;
    }

    /**
     * This method is to get the object at a certain index
     * 
     * @param index the index to get the object at
     * @return the data of the object at the index
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * This method is to check if the list has an object
     * 
     * @param obj the object to look for
     * @return true if object was found, false if not
     */

    public boolean contains(E obj) {
        if (obj == null) {
            return false;
        }
        if (isEmpty()) {
            return false;
        }
        Node<E> current = head;
        while (current != null) {
            if (current.getData().equals(obj)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * This method is to check if the list is empty
     * 
     * @return true if the head is null
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Method is to clear the list
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * This method is to turn the list to an array
     * 
     * @return array of the list
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }
        return array;
    }

    /**
     * This method is to get the iterator of the list
     * 
     * @return the singlylinkedlistiterator
     */
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

    /**
     * This method is to sort the list using insertion sort with a comparator
     * 
     * @param comparator the comparator to use for the sort
     */
    public void insertionSort(Comparator<E> comparator) {
        Node<E> sorted = null;
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next;
            sorted = sortedInsert(sorted, current, comparator);
            current = next;
        }
        head = sorted;
    }

    /**
     * This method is to insert a node into a sorted list for insertion sort
     * 
     * @param sortedHead the head of the sorted list
     * @param current    the current node to be inserted
     * @param comparator the comparator to compare the nodes
     * @return the sorted head
     */
    private Node<E> sortedInsert(Node<E> sortedHead, Node<E> current, Comparator<E> comparator) {
        if (sortedHead == null || comparator.compare(head.data, current.data) >= 0) {
            current.setNext(sortedHead);
            return current;
        } else {
            Node<E> temp = sortedHead;
            while (temp.next != null && comparator.compare(temp.next.data, current.data) < 0) {
                temp = temp.next;
            }
            current.setNext(temp.next);
            temp.setNext(current);
        }
        
        return sortedHead;
    }

    /**
     * This nested class is to create nodes for the list
     * 
     * @param <E> the type of the data
     * 
     */
    private class Node<E> {
        /**
         * fields
         */
        private E data;
        private Node<E> next;

        /**
         * Constructor
         * 
         * @param data data for the node
         */
        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Constructor
         * 
         * @param data data for the node
         * @param next the next node
         * 
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * This method is to get the data of the node
         * 
         * @return next
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * this method is to get the data of a node
         * 
         * @return data
         */
        public E getData() {
            return data;
        }

        /**
         * This method is to set the data of a node
         * 
         * @param next the next ndoe
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /**
     * This is a nested class to create an iterator for the list
     */
    private class SinglyLinkedListIterator<T> implements Iterator<E> {
        /**
         * fields
         */
        private Node<E> next;
        private Node<E> previous;
        private boolean calledNext;

        /**
         * Constructor
         * 
         */
        public SinglyLinkedListIterator() {
            this.next = head;
            this.previous = null;
            calledNext = false;
        }

        /**
         * This method is to check if the list has a next object
         * 
         * @return true if next is not null
         */
        @Override
        public boolean hasNext() {
            return next != null;
        }

        /**
         * This method is to get the next object and move the iterator
         * 
         * @return the next node's data
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            previous = next;
            next = next.getNext();
            calledNext = true;
            return previous.getData();
        }

        /**
         * this method is to remove the current node the iterator is pointing to
         */
        public void remove() {
            if (!calledNext) {
                throw new IllegalStateException();
            }
            previous.setNext(next.getNext());
            size--;
            calledNext = false;
        }
    }

}