/**
 * Name:
 * Student Number:
 */

/**
 * You may add your own classes and function but you may not modify any of
 * the given attribute names or given method signatures.
 */
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private Integer maxLevel;
    private Integer maxRow;
    private Integer maxCol;
    private List<Vertex> verticesList;
    
    public Graph() {
        maxLevel = 0;
        maxRow = 0;
        maxCol = 0;
        this.verticesList = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
		this.verticesList.add(vertex);
	}

    /**
     * Create a new graph to represent the given maze.
     * 
     * See the specification provided on https://cs.up.ac.za/courses/COS212
     */
    public void createGraphFrom3DMaze(Character[][][] maze) {
        this.verticesList = new ArrayList<>();
        //create vertexes for each non x in maze
        for(int i= 0 ; i < maze.length; i++){
            maxLevel++;
            for(int j=0 ; j < maze[i].length ; j++){
                maxRow++;
                for(int z=0 ; z < maze[i][j].length ; z++){
                    maxCol++;
                    if(maze[i][j][z] != 'x')
                    {
                        Vertex newVert = new Vertex(i, j, z);
                        verticesList.add(newVert);
                    }
                }
            }
        }
        //connect vertices 
        Vertex Traverse = null;
        Integer level = 0;
        Integer row = 0;
        Integer col = 0;
        for(int i = 0; i < verticesList.size(); i++)
        {    
            Traverse = verticesList.get(i);
            level = Traverse.coords.level;
            row = Traverse.coords.row;
            col = Traverse.coords.col;
            if(getVertex(level, row, col-1) != null)
            {
                Traverse.addNeighbor(getVertex(level, row, col-1));
            }

            if(getVertex(level, row, col+1) != null)
            {
                Traverse.addNeighbor(getVertex(level, row, col+1));
            }

            if(getVertex(level, row-1, col) != null)
            {
                Traverse.addNeighbor(getVertex(level, row-1, col));
            }

            if(getVertex(level, row+1, col) != null)
            {
                Traverse.addNeighbor(getVertex(level, row+1, col));
            }

            if((maze[level][row][col] == 'b' ||
                maze[level][row][col] == 'u') && getVertex(level+1, row, col) != null)
            {
                Traverse.addNeighbor(getVertex(level+1, row, col));
            }

            if(( maze[level][row][col] == 'b'
                || maze[level][row][col] == 'd' ) && getVertex(level-1, row, col) != null)
            {
                Traverse.addNeighbor(getVertex(level-1, row, col));
            }
        }
    }

    /**
     * Return the vertex with the given coordinates (level, row, col)
     * If the vertex does not exist, return null.
     * If the coordinates are out of bounds, return null.
     */
    public Vertex getVertex(Integer level, Integer row, Integer col) {
        //check bounds
        if(level > maxLevel || level < 0) return null;
        if(row > maxRow || row < 0) return null;
        if(col > maxCol || col < 0) return null;

       for(int i = 0; i < verticesList.size(); i++){
           if(verticesList.get(i).coords.equals(level, row, col)){
               return verticesList.get(i);
           }
       }

       return null;  //not found
    }

    /**
     * Return all the vertices in the graph.
     * The vertices in the returned array can be in any order.
     */
    public Vertex[] getAllVertices() {
        // TODO: Your code here...
        Vertex[] out = new Vertex[verticesList.size()];
        for(int i = 0; i < verticesList.size(); i++){
            out[i] = verticesList.get(i);
        }
        return out;
    }

    /**
     * Return the vertices adjacent to the given vertex.
     * The vertices in the array can be in any order.
     * Return an empty array if there are no adjacent vertices.
     * If the vertex does not exist, return null.
     */
    public Vertex[] getAdjacentVertices(Vertex vertex) {
        Vertex getMyNeighbors = getVertex(vertex.coords.level, vertex.coords.row, vertex.coords.col);
        if(getMyNeighbors == null){
            return null;
        }

        return getMyNeighbors.getAllNeighbors(); 
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
       if(getLongestPath(start, end) == null) return null;
       
       if(getLongestPath(start, end).length == 0) return null;

       return getLongestPath(start, end).length-1;
    }

    /**
     * Return an array of vertices that make up the longest path in order from start to end.
     * The starting vertex should be the first element, and the ending vertex should be the last element.
     * If there is no path, return an empty array.
     * If no vertex exists at the given coordinates, return null.
     * You may assume there will be only one longest path.
     */
    public Vertex[] getLongestPath(Coordinates start, Coordinates end) {
        Vertex StartVert = getVertex(start.level, start.row, start.col);
        Vertex EndVert = getVertex(end.level, end.row, end.col);

        if(StartVert == null || EndVert == null) return null; //one of the coordinates don't exist

        if(StartVert == EndVert){
            Vertex[] out = new Vertex[0];
            return out;
        } 
       
        List<Vertex> toBeChecked = new ArrayList<>();
        StartVert.currDist = 0;
        toBeChecked.add(StartVert);

        Vertex v, u = null;
        Vertex [] adjacent = null;

        while(toBeChecked.size() > 0){
            v = toBeChecked.get(0);
            toBeChecked.remove(0);
            adjacent = v.getAllNeighbors();
            for(int i = 0; i < adjacent.length; i++){
                u = adjacent[i];

                if(u.checked){         
                    if(u != v.predecessor)
                    if(u.currDist <= v.currDist + 1){
                        Vertex [] subAdj = u.getAllNeighbors();
                        for(int k = 0; k < subAdj.length; k++)
                            if(subAdj[k] != u)
                                if(subAdj[k].currDist < v.currDist+2){
                                    u.currDist = v.currDist +1;
                                    u.predecessor = v;
                                    u.checked = true;
                                }   
                    }
                }

                if(u != v.predecessor && u.checked == false)
                if(u.currDist < v.currDist + 1){
                    u.currDist = v.currDist +1;
                    u.predecessor = v;
                    u.checked = true;
                    if(!toBeChecked.contains(u) && u != EndVert)
                        toBeChecked.add(u);
                }
            }
        }
        List<Vertex> outList = new ArrayList<>();    
        Vertex Traverse = EndVert;

        while(Traverse != null){
            outList.add(Traverse);
            Traverse = Traverse.predecessor;
        }

        if(outList.size() <= 1){
            Vertex[] out = new Vertex[0];
            return out;
        }

        Vertex[] out = new Vertex[outList.size()];
        for(int i = 0; i < out.length; i++){
            out[i] = outList.get(outList.size()-i-1);
        }

        return out;
    }

}
