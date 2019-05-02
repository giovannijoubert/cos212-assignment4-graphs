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
        // TODO: Your code here...
        maxLevel = maze.length-1;

        if(maze[0] == null) return; //prevent nullpointerexceptions
        maxRow = maze[0].length-1;
        
        if(maze[0][0] == null) return; //prevent nullpointerexceptions
        maxCol = maze[0][0].length-1;

        char currentChar;
        Vertex addMe = null;
        Vertex addMeNewNeighbor = null;
        
        for(int level = 0; level <= maxLevel; level++){
            for(int row = 0; row <= maxRow; row++){
                for(int col = 0; col <= maxCol; col++){
                    currentChar = maze[level][row][col]; //used to check special directions for neighbors
                    if(maze[level][row][col] == 'x') continue; //wall do nothing
                    if(getVertex(level, row, col) != null){//already created vertex, check if all neighbors are created
                        if(currentChar == '.') continue; //normal block connection is handled on creation
                            addMe = getVertex(level, row, col);
                            if(currentChar == 'u'){ //up
                                if(level+1 <= maxLevel)
                                    if(getVertex(level+1, row, col) != null){ //neighbor already exists simply connect
                                        if(!addMe.isNeighbor(getVertex(level+1, row, col))){ //check if already connected
                                            addMe.addNeighbor(getVertex(level+1, row, col));
                                            getVertex(level+1, row, col).addNeighbor(addMe);
                                        }
                                    } else {
                                        addMeNewNeighbor = new Vertex(level+1, row, col);
                                        addMe.addNeighbor(addMeNewNeighbor);
                                        addMeNewNeighbor.addNeighbor(addMe);
                                        addVertex(addMeNewNeighbor);
                                    }
                            }
        
                            if(currentChar == 'd'){ //down
                                if(level-1 >= 0)
                                    if(getVertex(level-1, row, col) != null){ //neighbor already exists simply connect
                                        if(!addMe.isNeighbor(getVertex(level-1, row, col))){ //check if already connected
                                            addMe.addNeighbor(getVertex(level-1, row, col));
                                            getVertex(level-1, row, col).addNeighbor(addMe);
                                        }
                                    } else {
                                        addMeNewNeighbor = new Vertex(level-1, row, col);
                                        addMe.addNeighbor(addMeNewNeighbor);
                                        addMeNewNeighbor.addNeighbor(addMe);
                                        addVertex(addMeNewNeighbor);
                                    }
                            }
        
                            if(currentChar == 'b'){ //both
                                if(level-1 >= 0) //down
                                    if(getVertex(level-1, row, col) != null){ //neighbor already exists simply connect
                                        if(!addMe.isNeighbor(getVertex(level-1, row, col))){ //check if already connected
                                            addMe.addNeighbor(getVertex(level-1, row, col));
                                            getVertex(level-1, row, col).addNeighbor(addMe);
                                        }
                                    } else {
                                        addMeNewNeighbor = new Vertex(level-1, row, col);
                                        addMe.addNeighbor(addMeNewNeighbor);
                                        addMeNewNeighbor.addNeighbor(addMe);
                                        addVertex(addMeNewNeighbor);
                                    }
        
                                    if(level+1 <= maxLevel) //up
                                    if(getVertex(level+1, row, col) != null){ //neighbor already exists simply connect
                                        if(!addMe.isNeighbor(getVertex(level+1, row, col))){ //check if already connected
                                            addMe.addNeighbor(getVertex(level+1, row, col));
                                            getVertex(level+1, row, col).addNeighbor(addMe);
                                        }
                                    } else {
                                        addMeNewNeighbor = new Vertex(level+1, row, col);
                                        addMe.addNeighbor(addMeNewNeighbor);
                                        addMeNewNeighbor.addNeighbor(addMe);
                                        addVertex(addMeNewNeighbor);
                                    }
                            }

                        
                        continue; 
                    } 


                    //CREATE NEW VERTEX, NOT IN ANY NEIGHBOR LISTS YET
                    addMe = new Vertex(level, row, col); // create vertex
                    addVertex(addMe);

                    //check all directions for possible neighbors (normal block)

                    // RIGHT
                    if(col+1 <= maxCol)
                        if(maze[level][row][col+1] != 'x'){ 
                            if(getVertex(level, row, col+1) != null){ //neighbor already exists simply connect
                                addMe.addNeighbor(getVertex(level, row, col+1));
                                getVertex(level, row, col+1).addNeighbor(addMe);
                            } else {
                                addMeNewNeighbor = new Vertex(level, row, col+1);
                                addMe.addNeighbor(addMeNewNeighbor);
                                addMeNewNeighbor.addNeighbor(addMe);
                                addVertex(addMeNewNeighbor);
                            }
                        } 

                    // LEFT
                    if(col-1 >= 0)
                    if(maze[level][row][col-1] != 'x'){ 
                        if(getVertex(level, row, col-1) != null){ //neighbor already exists simply connect
                            addMe.addNeighbor(getVertex(level, row, col-1));
                            getVertex(level, row, col-1).addNeighbor(addMe);
                        } else {
                            addMeNewNeighbor = new Vertex(level, row, col-1);
                            addMe.addNeighbor(addMeNewNeighbor);
                            addMeNewNeighbor.addNeighbor(addMe);
                            addVertex(addMeNewNeighbor);
                        }
                    } 

                     // UP
                     if(row-1 >= 0)
                     if(maze[level][row-1][col] != 'x'){ 
                         if(getVertex(level, row-1, col) != null){ //neighbor already exists simply connect
                             addMe.addNeighbor(getVertex(level, row-1, col));
                             getVertex(level, row-1, col).addNeighbor(addMe);
                         } else {
                             addMeNewNeighbor = new Vertex(level, row-1, col);
                             addMe.addNeighbor(addMeNewNeighbor);
                             addMeNewNeighbor.addNeighbor(addMe);
                             addVertex(addMeNewNeighbor);
                         }
                     } 

                     // DOWN
                     if(row+1 <= maxRow)
                     if(maze[level][row+1][col] != 'x'){ 
                         if(getVertex(level, row+1, col) != null){ //neighbor already exists simply connect
                             addMe.addNeighbor(getVertex(level, row+1, col));
                             getVertex(level, row+1, col).addNeighbor(addMe);
                         } else {
                             addMeNewNeighbor = new Vertex(level, row+1, col);
                             addMe.addNeighbor(addMeNewNeighbor);
                             addMeNewNeighbor.addNeighbor(addMe);
                             addVertex(addMeNewNeighbor);
                         }
                     }

                     //now connect any SPECIAL neighbors
                     if(currentChar == 'u'){ //up
                        if(level+1 <= maxLevel)
                            if(getVertex(level+1, row, col) != null){ //neighbor already exists simply connect
                                addMe.addNeighbor(getVertex(level+1, row, col));
                                getVertex(level+1, row, col).addNeighbor(addMe);
                            } else {
                                addMeNewNeighbor = new Vertex(level+1, row, col);
                                addMe.addNeighbor(addMeNewNeighbor);
                                addMeNewNeighbor.addNeighbor(addMe);
                                addVertex(addMeNewNeighbor);
                            }
                     }

                     if(currentChar == 'd'){ //down
                        if(level-1 >= 0)
                            if(getVertex(level-1, row, col) != null){ //neighbor already exists simply connect
                                addMe.addNeighbor(getVertex(level-1, row, col));
                                getVertex(level-1, row, col).addNeighbor(addMe);
                            } else {
                                addMeNewNeighbor = new Vertex(level-1, row, col);
                                addMe.addNeighbor(addMeNewNeighbor);
                                addMeNewNeighbor.addNeighbor(addMe);
                                addVertex(addMeNewNeighbor);
                            }
                     }

                     if(currentChar == 'b'){ //both
                        if(level-1 >= 0) //down
                            if(getVertex(level-1, row, col) != null){ //neighbor already exists simply connect
                                addMe.addNeighbor(getVertex(level-1, row, col));
                                getVertex(level-1, row, col).addNeighbor(addMe);
                            } else {
                                addMeNewNeighbor = new Vertex(level-1, row, col);
                                addMe.addNeighbor(addMeNewNeighbor);
                                addMeNewNeighbor.addNeighbor(addMe);
                                addVertex(addMeNewNeighbor);
                            }

                            if(level+1 <= maxLevel) //up
                            if(getVertex(level+1, row, col) != null){ //neighbor already exists simply connect
                                addMe.addNeighbor(getVertex(level+1, row, col));
                                getVertex(level+1, row, col).addNeighbor(addMe);
                            } else {
                                addMeNewNeighbor = new Vertex(level+1, row, col);
                                addMe.addNeighbor(addMeNewNeighbor);
                                addMeNewNeighbor.addNeighbor(addMe);
                                addVertex(addMeNewNeighbor);
                            }
                     }
                }
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
