public class TreeAgain {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(20);
        root.insert(25);
        root.insert(15);
        root.insert(100);
        root.insert(-100);
        root.insert(300);
        root.insert(-300);
        root.insert(750);
        root.printInOrder();
        System.out.println("====================");
        System.out.println(root.contains(10));
        System.out.println(root.contains(25));
        System.out.println(root.contains(35));
        System.out.println("====================");
        Node child = root.getChild(25);
        child.printInOrder();
        child.insert(900);
        child.insert(-900);
        child.insert(5);
        child.insert(-5);
        System.out.println("====================");
        child.printInOrder();
        System.out.println("====================");
        root.printInOrder();
    }
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }

        void insert(int value) {
            if (value < data) {
                if (hasLeft())
                    getLeft().insert(value);
                else
                    left = new Node(value);
            } else {
                if (hasRight())
                    getRight().insert(value);
                else
                    right = new Node(value);
            }
        }

        boolean contains(int value) {
            if (value == data) return true;
            if (value < data) {
                if (hasLeft()) return getLeft().contains(value);
                return false;
            }
            if (hasRight()) return getRight().contains(value);
            return false;
        }

        Node getChild(int value){
            if (data == value) return this;
            if (value<data){
                if (hasLeft()) return getLeft().getChild(value);
                return null;
            }
            if (hasRight()) return getRight().getChild(value);
            return null;
        }

        void printInOrder() {
            if (hasLeft()) getLeft().printInOrder();
            System.out.println(data);
            if (hasRight()) getRight().printInOrder();
        }

        private boolean hasLeft() {
            return left != null;
        }

        private boolean hasRight() {
            return right != null;
        }

        private boolean isFull() {
            return hasLeft() && hasRight();
        }

        private Node getLeft() {
            return left;
        }

        private Node getRight() {
            return right;
        }
    }
}
