package DoublyLinkedList;

public class DoublyLinkedList<T> {
    private Element<T> head;
    private Element<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Element<T> {
        private T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void push(T value) {
        Element<T> newElement = new Element<>(value, tail, null);
        if (tail != null) {
            tail.next = newElement;
        }
        tail = newElement;
        if (head == null) {
            head = newElement;
        }
        size++;
    }

    public T pop() {
        if (tail == null) {
            throw new IllegalStateException("Cannot pop from an empty list");
        }
        T poppedValue = tail.value;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return poppedValue;
    }

    public void unshift(T value) {
        Element<T> newElement = new Element<>(value, null, head);
        if (head != null) {
            head.prev = newElement;
        }
        head = newElement;
        if (tail == null) {
            tail = newElement;
        }
        size++;
    }

    public T shift() {
        if (head == null) {
            throw new IllegalStateException("Cannot shift from an empty list");
        }
        T shiftedValue = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return shiftedValue;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
