package graph.adjacencyList;

import graph.Edge;
import graph.Vertex;
import supportStructures.Array;
import supportStructures.ArrayList;
import supportStructures.Interfaces.*;
import supportStructures.Queue;
import supportStructures.Stack;


/**
 * Class that represents a graph with adjacency list
 * @param <E> Type of the data of the vertices
 */
public class Graph<E> {
    /**
     * The number of vertexes
     */
    private int vertex;

    /**
     * The adjacency list
     */
    private ArrayInterface<List<Edge>> adjacencyList;

    /**
     * The array of vertexes
     */
    private ArrayInterface<Vertex<E>> vertexArray;

    /**
     * Constructor of the class
     * @param vertex number of vertexes
     */
    public Graph(int vertex) {
        this.adjacencyList = new ArrayList<>(vertex);
        this.vertexArray = new Array<>(vertex);
        for (int i = 0; i < vertex; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        this.vertex = 0;
    }

    /**
     * Method to add a vertex to the graph
     * @param data data of the vertex
     */
    public void addVertex(E data) {
        if (vertex < adjacencyList.size()) {
            vertexArray.add(new Vertex<>(data));
            vertex++;
        }
    }

    /**
     * Method to add an edge to the graph
     * @param origin origin of the edge
     * @param destiny destiny of the edge
     * @param weight weight of the edge
     */
    public void addEdge(E origin, E destiny, Integer weight) {
        int originIndex = numVertexes(origin);
        int destinyIndex = numVertexes(destiny);
        if (originIndex != -1 && destinyIndex != -1) {
            adjacencyList.get(originIndex).add(new Edge(destinyIndex, weight));
        }
    }
    /**
     * Method to delete an edge from the graph
     * @param origin origin of the edge
     * @param destiny destiny of the edge
     */
    public void deleteEdge(E origin, E destiny) {
        int originIndex = numVertexes(origin);
        int destinyIndex = numVertexes(destiny);
        if (originIndex != -1 && destinyIndex != -1) {
            List<Edge> list = adjacencyList.get(originIndex);
            Iterator<Edge> iterator = list.iterator();
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                if (edge.getDestiny() == destinyIndex) {
                    list.remove(edge);
                    return;
                }
            }
        }
    }
    /**
     * Method to get the number of a vertex
     * @param element data of the vertex
     * @return
     */
    private int numVertexes(E element) {
        Vertex<E> vertex = new Vertex<>(element);
        boolean found = false;
        int i = 0;
        while (i < vertexArray.size() && !found) {
            found = vertexArray.get(i).equals(vertex);
            if (!found) {
                i++;
            }
        }
        return found ? i : -1;
    }

    /**
     * Method to get the Breadth First Search traversal order
     * @param origin
     * @return breadth first search traversal order
     * @throws Exception
     */
    public Array<Integer> breadthFirstSearch(E origin) throws Exception {
        int v;
        QueueInterface<Integer> queue = new Queue<>();
        Array<Integer> visited = new Array<>(vertex);
        Array<Integer> traversalOrder = new Array<>(vertex);
        v = numVertexes(origin);
        for (int i = 0; i < vertex; i++) {
            visited.add(-1);
        }
        if (v < 0) {
            throw new Exception("Origin vertex does not exist");
        }
        visited.set(v, 0);
        queue.insert(v);
        while (!queue.isEmpty()) {
            v = queue.extract();
            traversalOrder.add(v);
            List<Edge> neighbors = adjacencyList.get(v);
            Iterator<Edge> iterator = neighbors.iterator();
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                int neighborIndex = edge.getDestiny();
                if (visited.get(neighborIndex) == -1) {
                    visited.set(neighborIndex, 0);
                    queue.insert(neighborIndex);
                }
            }
        }
        return traversalOrder;
    }
    /**
     * Method to get the Depth First Search traversal order
     * @param origin
     * @return depth first search traversal order
     */
    public Array<Integer> depthFirstSearch(E origin) throws Exception {
        int v;
        StackInterface<Integer> stack = new Stack<>();
        Array<Integer> visited = new Array<>(vertex);  // For keeping track of visited vertices (optional)
        Array<Integer> traversalOrder = new Array<>(vertex); // To store traversal order
        v = numVertexes(origin);
        for (int i = 0; i < vertex; i++) {
            visited.add(-1);  // Can be used to avoid redundant processing later
        }
        if (v < 0) {
            throw new Exception("Origin vertex does not exist");
        }
        // Mark origin as visited (optional)
        // visited.set(v, 0);
        stack.push(v);
        while (!stack.isEmpty()) {
            v = stack.pop();
            traversalOrder.add(v); // Add vertex to traversal order
            List<Edge> neighbors = adjacencyList.get(v);
            Iterator<Edge> iterator = neighbors.iterator();
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                int neighborIndex = edge.getDestiny();
                if (visited.get(neighborIndex) == -1) { // Check if not visited (optional)
                    visited.set(neighborIndex, 0); // Mark neighbor as visited (optional)
                    stack.push(neighborIndex);
                }
            }
        }
        return traversalOrder;
    }

}
