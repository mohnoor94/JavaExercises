import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    private static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();

        public Node(int id) {
            this.id = id;
        }


    }

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    private void addEdge(int source, int destination) {
        getNode(source).adjacent.add(getNode(destination));
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) return false;

        visited.add(source.id);

        if (source.id == destination.id) return true;

        for (Node child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) return true;
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source), getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node.id == destination.id) return true;
            if (!visited.contains(node.id)) {
                visited.add(node.id);
                nextToVisit.addAll(node.adjacent);
            }
        }
        return false;
    }
}