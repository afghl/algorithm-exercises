import java.util.Iterator;
import java.util.function.Consumer;

class MyLinkedList2<E> {
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
            tail.next = n;
            tail = n;
        }
    }

    public void revert() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
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

public class RevertLinkedList2 {
    public static void main(String[] args) {
        MyLinkedList2<Integer> l = new MyLinkedList2<Integer>();
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
