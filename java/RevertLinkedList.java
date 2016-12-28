import java.lang.annotation.ElementType;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

class MyLinkedList<E> {
    Node head;
    Node tail;

    public void add(E e) {
        if (head == null) {
            Node n = new Node();
            n.element = e;
            head = n;
            tail = n;
        } else {
            Node n = new Node();

            // 加到最后一个
            n.element = e;
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
    }

    public void revert() {
        Node n;
        Node prev;
        Node next;
        for (next = head.next; next != null; next = next.next) {
            n = next.prev;
            prev = n.prev;
            n.next = prev;
            n.prev = next;

            if (next == tail) {
                next.next = n;
                next.prev = null;
                break;
            }
        }

        Node tmpHead = head;
        head = tail;
        tail = tmpHead;
    }


    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    public void inspect() {
        for (Iterator<E> i = iterator();i.hasNext();) {
            E e = i.next();
            System.out.print(e + "  ");
        }
        System.out.println();
        System.out.println("----");
    }

    class Node<E> {
        Node<E> next;
        Node<E> prev;
        E element;

        @Override
        public String toString() {
            return element.toString();
        }
    }

    class MyListIterator implements Iterator<E> {
        Node<E> current;

        MyListIterator() {
            current = head;
        }

        public void remove() {

        }

        public void forEachRemaining(Consumer<? super E> action) {

        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }
    }
}


public class RevertLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> l = new MyLinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.inspect();
        l.revert();
        l.inspect();


    }

}
