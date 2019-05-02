/**
 * Name:
 * Student Number:
 */

/**
 * You may add your own classes and function but you may not modify any of
 * the given attribute names or given method signatures.
 */
public class Graph {

    public Graph() {
        
    }

    /**
     * Create a new graph to represent the given maze.
     * 
     * See the specification provided on https://cs.up.ac.za/courses/COS212
     */
    public void createGraphFrom3DMaze(Character[][][] maze) {
        // TODO: Your code here...
    }

    /**
     * Return the vertex with the given coordinates (level, row, col)
     * If the vertex does not exist, return null.
     * If the coordinates are out of bounds, return null.
     */
    public Vertex getVertex(Integer level, Integer row, Integer col) {
        // TODO: Your code here...
       return null; // Stub line, you can safely remove when required
    }

    /**
     * Return all the vertices in the graph.
     * The vertices in the returned array can be in any order.
     */
    public Vertex[] getAllVertices() {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

    /**
     * Return the vertices adjacent to the given vertex.
     * The vertices in the array can be in any order.
     * Return an empty array if there are no adjacent vertices.
     * If the vertex does not exist, return null.
     */
    public Vertex[] getAdjacentVertices(Vertex vertex) {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

    /** 
     * =============================
     * ===        TASK 2         ===
     * =============================
     */

    /**
     * Return the length of the longest path.
     * The start and end vertices should be part of the path.
     * The length can be calculated by summing the weights of edges in the path.
     * For Task 2, each edge has an implicit weight of 1, so the path length is
     * the number of edges in the path.
     * If no path exists, return null
     * You may assume there will only be one longest path.
     */
    public Integer getLongestPathLength(Coordinates start, Coordinates end) {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

    /**
     * Return an array of vertices that make up the longest path in order from start to end.
     * The starting vertex should be the first element, and the ending vertex should be the last element.
     * If there is no path, return an empty array.
     * If no vertex exists at the given coordinates, return null.
     * You may assume there will be only one longest path.
     */
    public Vertex[] getLongestPath(Coordinates start, Coordinates end) {
        // TODO: Your code here...
        return null; // Stub line, you can safely remove when required
    }

}
