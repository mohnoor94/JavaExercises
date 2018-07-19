public class StackUsingNodeImpl {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.print();
        stack.push(10);
        stack.print();
        stack.push(20);
        stack.push(30);
        stack.print();

        System.out.println("\nPop " + stack.pop());
        stack.print();
        System.out.println("\nPop " + stack.pop());
        stack.print();
        System.out.println("\nPop " + stack.pop());
        stack.print();
//        System.out.println("\n" + stack.pop());
//        stack.print();
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

    static class MyStack {

        Node top;

        boolean isEmpty() {
            return top == null;
        }

        int peek() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            return top.data;
        }

        void push(int data) {
            Node node = new Node(data);
            node.next = top;
            top = node;
        }

        int pop() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            int data = top.data;
            top = top.next;
            return data;
        }

        @SuppressWarnings("Duplicates")
        void print() {
            StringBuilder list;
            if (top == null) list = new StringBuilder("-- Empty Stack --");
            else {
                list = new StringBuilder("[" + top.data);
                Node current = this.top;
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
