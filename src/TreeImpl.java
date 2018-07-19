public class TreeImpl {

    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.insert(5);
        tree.insert(15);
        tree.printInOrder();

        System.out.println("=====================");
        System.out.println(tree.remove(20));
        tree.printInOrder();

        System.out.println("=====================");
        System.out.println(tree.remove(10));
        tree.printInOrder();

        System.out.println("=====================");
        System.out.println(tree.remove(5));
        System.out.println(tree.remove(10));
        // System.out.println(tree.remove(15));
        tree.printInOrder();

        System.out.println("=====================");
        tree.insert(20);
        tree.insert(0);
        tree.printInOrder();

        System.out.println("=====================");
        tree.insert(2);
        tree.insert(200);
        tree.printInOrder();

        System.out.println("=====================");
        tree.insert(100);
        tree.insert(-500);
        tree.printInOrder();

        System.out.println("=====================");
        System.out.println(tree.remove(100));
        tree.printInOrder();
    }

    static class Tree {
        
        int data;
        Tree parent, left, right;

        Tree(int data) {
            this.data = data;
        }

        void insert(int value) {
            if (value <= data) {
                if (hasLeft())
                    left.insert(value);
                else {
                    left = new Tree(value);
                    left.parent = this;
                }
            } else {
                if (hasRight())
                    right.insert(value);
                else {
                    right = new Tree(value);
                    right.parent = this;
                }
            }
        }

        boolean contains(int value) {
            if (data == value)
                return true;

            if (value < data) {
                if (hasLeft())
                    return left.contains(value);
                return false;
            }

            if (hasRight())
                right.contains(value);

            return false;
        }

        boolean remove(int value) {
            return remove(this, value);
        }

        private boolean remove(Tree root, int value) {
            if (root.data == value) {
                root.removeNode(value);
                return true;
            } else if (value < root.data && root.hasLeft())
                return remove(root.left, value);
            else if (value > root.data && root.hasRight())
                return remove(root.right, value);

            return false;
        }

        void printInOrder() {
            if (hasLeft())
                left.printInOrder();

            System.out.println(data);

            if (hasRight())
                right.printInOrder();
        }

        private void removeNode(int value) {
            if (isFull()) {
                this.data = left.data;
                int rightData = right.data;
                this.left = null;
                this.right = null;
                this.insert(rightData);
            } else if (hasLeft()) {
                this.data = left.data;
                this.left = left.left;
                this.right = left.right;
            } else if (hasRight()) {
                this.data = right.data;
                this.left = right.left;
                this.right = right.right;
            } else {
                Tree parent = this.getParent();
                if (parent != null) {
                    if (parent.hasLeft() && parent.left.data == value)
                        parent.left = null;
                    else if (parent.hasRight() && parent.right.data == value)
                        parent.right = null;
                } else {
                    throw new RuntimeException("I'm the last node. Don't destroy me please :'(");
                }
            }
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

        Tree getParent() {
            return parent;
        }
    }
}