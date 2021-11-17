package CollectionFramework;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
            return;
        }

        Node prevNode = getPrevNode(index);
        Node node = new Node(value);
        node.next = prevNode.next;
        prevNode.next = node;
        size++;
    }

    public int deleteFirst() {
        int val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (size == 1) {
            return deleteFirst();
        }
        int val = tail.data;
        Node prevNode = getPrevNode(size - 1);
        prevNode.next = null;
        tail = prevNode;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = getPrevNode(index);
        int val = prev.next.data;

        prev.next = prev.next.next;

        return val;
    }

    private Node getPrevNode(int index) {
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insert(2, 30);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        // System.out.println(list.deleteLast());
        // System.out.println(list.deleteLast());
        // System.out.println(list.deleteLast());
    }
}
