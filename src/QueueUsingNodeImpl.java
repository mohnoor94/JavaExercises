public class QueueUsingNodeImpl {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.add(10);
        System.out.println(q.peek());
        q.add(20);
        q.add(30);
        q.add(5);
        q.add(0);
        System.out.println(q.peek());
        q.print();

        System.out.println(q.remove());
        q.print();
        System.out.println(q.remove());
        q.print();
        System.out.println(q.remove());
        q.print();
        System.out.println(q.remove());
        q.print();
        System.out.println(q.remove());
        q.print();
//        q.remove();
//        q.print();
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

    static class MyQueue {

        Node head;
        Node tail;

        boolean isEmpty() {
            return head == null;
        }

        int peek() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            return head.data;
        }

        void add(int data) {
            Node node = new Node(data);
            if (tail != null) tail.next = node;
            tail = node;
            if (head == null) head = node;
        }

        int remove() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            int data = head.data;
            head = head.next;
            if (head == null) tail = null;
            return data;
        }

        @SuppressWarnings("Duplicates")
        void print() {
            StringBuilder list;
            if (head == null) list = new StringBuilder("-- Empty Queue --");
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
