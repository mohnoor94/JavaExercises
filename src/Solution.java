//import java.io.*;
//import java.util.*;
//import java.util.Collection;
//
//public class Solution {
//
//    private static int[] contacts(String[][] queries) {
//        Node root = new Node();
//        int contactsAdded = addContacts(queries, root);
//        return countPaths(queries, root, contactsAdded);
//    }
//
//    private static int[] countPaths(String[][] queries, Node root, int contactsAdded) {
//        int[] counts = new int[queries.length - contactsAdded];
//        int index = 0;
//        for (String[] query : queries) {
//            if (query[0].equals("find")) {
//                counts[index++] = root.countPaths(query[1]);
//            }
//        }
//        return counts;
//    }
//
//    private static int addContacts(String[][] queries, Node root) {
//        int addCount = 0;
//        for (String[] query : queries) {
//            if (query[0].equals("add")) {
//                root.addWord(query[1]);
//                addCount++;
//            }
//        }
//        return addCount;
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int queriesRows = Integer.parseInt(scanner.nextLine().trim());
//
//        String[][] queries = new String[queriesRows][2];
//
//        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
//            String[] queriesRowItems = scanner.nextLine().split(" ");
//
//            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
//                String queriesItem = queriesRowItems[queriesColumnItr];
//                queries[queriesRowItr][queriesColumnItr] = queriesItem;
//            }
//        }
//
//        int[] result = contacts(queries);
//
//        for (int resultItr = 0; resultItr < result.length; resultItr++) {
//            bufferedWriter.write(String.valueOf(result[resultItr]));
//
//            if (resultItr != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//    }
//}
//
//@SuppressWarnings("Duplicates")
//class Node {
//    private HashMap<Character, Node> children = new HashMap<>();
//    private boolean isCompletedWord;
//
//    Node() {
//    }
//
//    void addWord(String word) {
//        char ch = word.charAt(0);
//        Node child;
//        if (hasChild(ch)) {
//            child = getChildNodeOf(ch);
//        } else {
//            child = addChild(ch);
//        }
//        if (word.length() == 1)
//            child.isCompletedWord = true;
//        else
//            child.addWord(word.substring(1));
//    }
//
//    int countPaths(String word) {
//        if (word.length() <= 1)
//            return 0;
//
//        return countPaths(word, 0);
//    }
//
//    private int countPaths(String word, int count) {
//        char ch = word.charAt(0);
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
//
//    private int countChildren() {
//        int count = 0;
//        Collection<Node> values = children.values();
//        if (isCompletedWord) count++;
//        for (Node child : values) {
//            count += child.countChildren();
//        }
//        return count;
//    }
//
//    private Node addChild(char ch) {
//        children.put(ch, new Node());
//        return children.get(ch);
//    }
//
//    private Node getChildNodeOf(char ch) {
//        return children.get(ch);
//    }
//
//    private boolean hasChild(char ch) {
//        return children.containsKey(ch);
//    }
//}