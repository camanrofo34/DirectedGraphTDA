package graph;

/**
 * Class that represents an edge in a graph
 */
public class Edge {

    /**
     * The destiny of the edge
     */
    private int destiny;
    /**
     * The weight of the edge
     */
    private int weight;
    /**
     * Constructor of the class
     * @param destiny destiny of the edge
     * @param weight weight of the edge
     */
    public Edge(int destiny, int weight) {
        this.destiny = destiny;
        this.weight = weight;
    }

    /**
     * Method to get the weight of the edge
     * @return
     */
    public int getDestiny() {
        return destiny;
    }
}

