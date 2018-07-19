public class LinkedListImpl {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.print();
        list.perpend(5);
        list.perpend(0);
        list.print();
        list.delete(0);
        list.delete(10);
        list.delete(30);
        list.print();

        System.out.println("================");

        System.out.println(list.hasCycle());

        System.out.println("================");

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        MyLinkedList listWithCycle = new MyLinkedList(node1);
        System.out.println(listWithCycle.hasCycle());
        listWithCycle.print();
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    static class MyLinkedList {
        Node head;

        MyLinkedList(Node head) {
            this.head = head;
        }

        MyLinkedList() {
        }

        void append(int data) {
            if (head == null) {
                head = new Node(data);
                return;
            }
            Node current = head;
            while (current.hasNext()) {
                current = current.next;
            }
            current.next = new Node(data);
        }

        void perpend(int data) {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }

        void delete(int data) {
            if (head == null) return;
            if (head.data == data) {
                head = head.next;
                return;
            }
            Node current = head;
            while (current.hasNext()) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }

        boolean hasCycle() {
            if (head == null) return false;
            Node fast = head.next;
            Node slow = this.head;
            while (slow.hasNext() && fast.hasNext() && fast.next.hasNext()) {
                if (slow.data == fast.data) return true;
                fast = fast.next.next;
                slow = slow.next;
            }
            return false;
        }

        @SuppressWarnings("Duplicates")
        void print() {
            StringBuilder list;
            if (hasCycle()) list = new StringBuilder("-- Cannot print a list with cycles --");
            else if (head == null) list = new StringBuilder("-- Empty List --");
            else {
                list = new StringBuilder("[" + head.data);
                Node current = this.head;
                while (current.hasNext()) {
                    list.append(", ").append(current.next.data);
                    current = current.next;
                }
                list.append("]");
            }
            System.out.println(list.toString());
        }
    }
}