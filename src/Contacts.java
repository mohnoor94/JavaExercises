import java.util.HashMap;
import java.util.Objects;

/**
 * Problem Statement: https://www.hackerrank.com/challenges/contacts/problem
 *
 * NOT COMPLETED
 */
public class Contacts {
    public static void main(String[] args) {
//        Node root = new Node('*');
//        root.addWord("hack");
//        root.addWord("hackerrank");
//        System.out.println(root.countPaths("hac"));
//        System.out.println(root.countPaths("hak"));
//
//        String[][] queries = new String[][]{
//                {"add", "hack"},
//                {"add", "hackerrank"},
//                {"find", "hac"},
//                {"find", "hak"}
//        };

//        String[][] queries = new String[][]{
//                {"add", "cat"},
//                {"add", "car"},
//                {"add", "caty"},
//                {"add", "card"},
//                {"add", "cards"},
//                {"find", "ca"},
//                {"find", "co"}
//        };

        String[][] queries = new String[][]{
                {"add", "s"},
                {"add", "ss"},
                {"add", "sss"},
                {"add", "ssss"},
                {"add", "sssss"},
                {"find", "s"},
                {"find", "ss"},
                {"find", "sss"},
                {"find", "ssss"},
                {"find", "sssss"},
                {"find", "ssssss"}
        };

        int[] contacts = contacts(queries);
        for (int contact : contacts) {
            System.out.println(contact);
        }
    }

    private static int[] contacts(String[][] queries) {
        Node root = new Node();
        int contactsAdded = addContacts(queries, root);
        return countPaths(queries, root, contactsAdded);
    }

    private static int[] countPaths(String[][] queries, Node root, int contactsAdded) {
        int[] counts = new int[queries.length - contactsAdded];
        int index = 0;
        for (String[] query : queries) {
            if (query[0].equals("find")) {
                counts[index++] = root.countPaths(query[1]);
            }
        }
        return counts;
    }

    private static int addContacts(String[][] queries, Node root) {
        int addCount = 0;
        for (String[] query : queries) {
            if (query[0].equals("add")) {
                root.addWord(query[1]);
                addCount++;
            }
        }
        return addCount;
    }
}

class Node {
    private HashMap<Character, Node> children = new HashMap<>();
    private boolean isCompletedWord;
    private static HashMap<Node, Integer> visits = new HashMap<>();

    Node() {
    }

    void addWord(String word) {
        addWord(word, 0);
    }

    private void addWord(String word, int index) {
        if (word.length() == index) {
            isCompletedWord = true;
            return;
        }
        char ch = word.charAt(index);
        Node child;
        if (hasChild(ch)) {
            child = getChildNodeOf(ch);
        } else {
            child = addChild(ch);
        }
        child.addWord(word, index + 1);
    }

    int countPaths(String word) {
        if (word.length() == 0)
            return 0;

        return countPaths(word, 0);
    }

//    private int countPaths(String word, int index) {
//        char ch = word.charAt(index);
//        boolean found = word.length() == 1;
//        Node child;
//        if (hasChild(ch)) {
//            child = getChildNodeOf(ch);
//            if (found) {
//                return child.countChildren();
//            } else {
//                return child.countPaths(word.substring(1), count);
//            }
//        } else {
//            return count;
//        }
//    }

    private int countPaths(String word, int count) {
        char ch = word.charAt(0);
        boolean found = word.length() == 1;
        Node child;
        if (hasChild(ch)) {
            child = getChildNodeOf(ch);
            if (found) {
                return child.countChildren();
            } else {
                return child.countPaths(word.substring(1), count);
            }
        } else {
            return count;
        }
    }

    private int countChildren() {
        int count = 0;
        if (isCompletedWord) count++;
        for (Node child : children.values()) {
            if (visits.containsKey(child))
            count += child.countChildren();
        }
        return count;
    }

    private Node addChild(char ch) {
        children.put(ch, new Node());
        return children.get(ch);
    }

    private Node getChildNodeOf(char ch) {
        return children.get(ch);
    }

    private boolean hasChild(char ch) {
        return children.containsKey(ch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return isCompletedWord == node.isCompletedWord &&
                Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, isCompletedWord);
    }
}