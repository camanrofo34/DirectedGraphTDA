package graph.adjacencyList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supportStructures.Interfaces.Iterator;


class GraphTest {

    Graph<Integer> graph = new Graph<>(5);

    @BeforeEach
    void setUp() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 5, 1);
    }

    @Test
    void addVertex() {
        graph.addVertex(5);
    }

    @Test
    void addEdge() {
        graph.addEdge(4, 5, 7);
    }

    @Test
    void deleteEdge() {
        graph.deleteEdge(1, 2);
    }

    @Test
    void breadthFirstSearch() throws Exception {
        Iterator<Integer> iterator = graph.breadthFirstSearch(1).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void depthFirstSearch() throws Exception {
        Iterator<Integer> iterator = graph.depthFirstSearch(1).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}