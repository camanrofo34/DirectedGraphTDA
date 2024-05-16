package graph;


/**
 * Class that represents a vertex in a graph
 */
public class Vertex<E> {
    /**
     * The data of the vertex
     */
    private E data;
    /**
     * The number of the vertex
     */
    private int numVertex;

    /**
     * Constructor of the class
     * @param data data of the vertex
     */
    public Vertex(E data) {
        this.data = data;
        this.numVertex = -1;
    }
    /**
     * Method to get the number of the vertex
     * @return
     */
    public boolean equals(Vertex<E> v) {
        return data.equals(v.getData());
    }
    /**
     * Method to get the number of the vertex
     * @return
     */
    public E getData() {
        return data;
    }
    /**
     * Method to get the number of the vertex
     * @return
     */
    public void assignVertex(int n){
        numVertex = n;
    }
    /**
     * Method to get the number of the vertex
     * @return
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
