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
        System.out.println(root.isBinarySearchTree());
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
        System.out.println("====================");
        System.out.println(root.isBinarySearchTree());
        System.out.println(child.isBinarySearchTree());

        System.out.println("********************");

        Node test = new Node(1);
        test.insert(4);
        test.insert(5);
        test.insert(3);
        test.insert(2);
        System.out.println(test.isBinarySearchTree());
        test.printInOrder();
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
                    left.insert(value);
                else
                    left = new Node(value);
            } else {
                if (hasRight())
                    right.insert(value);
                else
                    right = new Node(value);
            }
        }

        boolean contains(int value) {
            if (value == data) return true;
            if (value < data) {
                if (hasLeft()) return left.contains(value);
                return false;
            }
            if (hasRight()) return right.contains(value);
            return false;
        }

        boolean isBinarySearchTree() {
            return isBinarySearchTree(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isBinarySearchTree(int minValue, int maxValue) {
            if (data < minValue || data > maxValue) return false;

            if (isFull())
                return left.isBinarySearchTree(minValue, data)
                        && right.isBinarySearchTree(data, maxValue);
            else if (hasLeft())
                return left.isBinarySearchTree(minValue, data);
            else if (hasRight())
                return right.isBinarySearchTree(data, maxValue);
            return true;
        }

        Node getChild(int value) {
            if (data == value) return this;
            if (value < data) {
                if (hasLeft()) return left.getChild(value);
                return null;
            }
            if (hasRight()) return right.getChild(value);
            return null;
        }

        void printInOrder() {
            if (hasLeft()) left.printInOrder();
            System.out.println(data);
            if (hasRight()) right.printInOrder();
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
    }
}
