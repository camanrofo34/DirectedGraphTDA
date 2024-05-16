package graph.testCase;

import graph.adjacencyMatrix.Graph;
import supportStructures.Interfaces.Iterator;

public class testCase {
    /*
    15.2. Un grafo valorado está formado por los vértices 4, 7, 14, 19, 21, 25. Las aristas
    siempre van de un vértice de mayor valor numérico a otro de menor valor, y el peso es
    el módulo del vértice origen y el vértice destino.
    a) Escribir un programa que represente el grafo con matriz de adyacencia.
    b) Añadir al programa el código necesario para realizar un recorrido en anchura desde
    un vértice dado.

    Extraído de: Joyannes, Luis (2008). Estructuras de Datos en Java. España: MCGRAW-HILL
     */

    public static void main(String[] args) {
        // a) Escribir un programa que represente el grafo con matriz de adyacencia.
        // Crear un grafo con 6 vértices
        int numVertex = 6;
        Graph<Integer> graph = new Graph<>(numVertex);

        // Añadir los vértices al grafo
        graph.addVertex(4);
        graph.addVertex(7);
        graph.addVertex(14);
        graph.addVertex(19);
        graph.addVertex(21);
        graph.addVertex(25);

        // Añadir las aristas al grafo
        graph.addEdge(25, 21, 4);
        graph.addEdge(21, 19, 2);
        graph.addEdge(19, 14, 5);
        graph.addEdge(14, 7, 7);
        graph.addEdge(7, 4, 3);
        graph.addEdge(25, 19, 6);
        graph.addEdge(21, 14, 7);
        graph.addEdge(19, 7, 12);
        graph.addEdge(14, 4, 10);
        graph.addEdge(25, 14, 11);
        graph.addEdge(21, 7, 14);
        graph.addEdge(19, 4, 15);
        graph.addEdge(25, 7, 18);
        graph.addEdge(21, 4, 17);
        graph.addEdge(25, 4, 21);

        // b) Añadir al programa el código necesario para realizar un recorrido en anchura desde
        // un vértice dado.
        try {
            Iterator<Integer> iterator = graph.breadthFirstSearch(25).iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
