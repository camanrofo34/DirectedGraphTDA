package graph.adjacencyMatrix;

import graph.Vertex;
import supportStructures.Array;
import supportStructures.ArrayList;
import supportStructures.Interfaces.ArrayInterface;
import supportStructures.Interfaces.List;
import supportStructures.Interfaces.QueueInterface;
import supportStructures.Queue;
import supportStructures.Stack;

/**
 * Class that represents a graph with adjacency matrix
 * @param <E> Type of the data of the vertices
 */
public class Graph<E> {
    /**
     * The adjacency matrix
     */
    private ArrayInterface<ArrayInterface<Integer>> adjacencyMatrix;
    /**
     * The number of vertexes
     */
    private int numVertex;
    /**
     * The array of vertexes
     */
    private ArrayInterface<Vertex<E>> vertexArray;

    /**
     * Constructor of the class
     * @param numVertex number of vertexes
     */
    public Graph(int numVertex) {
        adjacencyMatrix = new Array<>(numVertex);
        vertexArray = new Array<>(numVertex);
        for (int i = 0; i < numVertex; i++) {
            adjacencyMatrix.add(new Array<>(numVertex));
            for (int j = 0; j < numVertex; j++) {
                adjacencyMatrix.get(i).add(0);
            }
        }
        this.numVertex = 0;
    }

    /**
     * Method to add a vertex to the graph
     * @param element data of the vertex
     */
    public void addVertex(E element){
        boolean exists = numVertexes(element) >= 0;
        if (!exists && numVertex < adjacencyMatrix.size()) {
            Vertex<E> vertex = new Vertex<>(element);
            vertex.assignVertex(numVertex++);
            vertexArray.add(vertex);
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
     * Method to add an edge to the graph
     * @param origin origin of the edge
     * @param destiny destiny of the edge
     * @param weight weight of the edge
     */
    public void addEdge(E origin, E destiny, Integer weight) {
        int originIndex = numVertexes(origin);
        int destinyIndex = numVertexes(destiny);
        if (originIndex != -1 && destinyIndex != -1) {
            adjacencyMatrix.get(originIndex).set(destinyIndex, weight);
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
            adjacencyMatrix.get(originIndex).set(destinyIndex, 0);
        }
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
        Array<Integer> visited = new Array<>(numVertex);
        Array<Integer> traversalOrder = new Array<>(numVertex);
        v = numVertexes(origin);
        for (int i = 0; i < numVertex; i++) {
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
            for (int u = 0; u < numVertex; u++) {
                if (adjacencyMatrix.get(v).get(u) != 0 && visited.get(u) == -1) {
                    visited.set(u, 0);
                    queue.insert(u);
                }
            }
        }
        return traversalOrder;
    }


    /**
     * Method to get the Depth First Search traversal order
     * @param origin
     * @return Array with the traversal order
     */
    public Array<Integer> depthFirstSearch(E origin) throws Exception {
        int v;
        Stack<Integer> stack = new Stack<>();
        Array<Integer> visited = new Array<>(numVertex);
        Array<Integer> traversalOrder = new Array<>(numVertex);

        v = numVertexes(origin);
        for (int i = 0; i < numVertex; i++) {
            visited.add(-1);
        }
        if (v < 0) {
            throw new Exception("Origin vertex does not exist");
        }
        visited.set(v, 0);
        stack.push(v);
        while (!stack.isEmpty()) {
            v = stack.pop();
            traversalOrder.add(v);
            for (int u = 0; u < numVertex; u++) {
                if (adjacencyMatrix.get(v).get(u) != 0 && visited.get(u) == -1) {
                    visited.set(u, visited.get(v) + 1);
                    stack.push(u);
                }
            }
        }
        return traversalOrder;
    }


}
