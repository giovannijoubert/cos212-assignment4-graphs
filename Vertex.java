import java.util.ArrayList;
import java.util.List;

/**
 * Name:
 * Student Number:
 */

public class Vertex {
   
    public Coordinates coords;
    public Vertex predecessor; 
    public Integer currDist;
    public boolean checked;

    private List<Vertex> neighbors;
    
    public Vertex(Integer level, Integer row, Integer col) {
        coords = new Coordinates(level, row, col);
        this.neighbors = new ArrayList<>();
        predecessor = null;
        currDist = Integer.MIN_VALUE;
        checked = false;
    }

    public void addNeighbor(Vertex vertex) {
		this.neighbors.add(vertex);
    }

    public Vertex[] getAllNeighbors(){
        Vertex[] out = new Vertex[neighbors.size()];
        for(int i = 0; i < neighbors.size(); i++){
            out[i] = neighbors.get(i);
        }
        return out;
    }
    
    public boolean isNeighbor(Vertex vertex){
        for(int i = 0; i < neighbors.size(); i++)
            if(neighbors.get(i) == vertex) return true;

        return false;
    }

    public void print(boolean Neigh){
      //  System.out.println("Vertex");
        System.out.print(coords.level + "," + coords.row + "," + coords.col);
        if(Neigh)
        for(int i = 0; i < neighbors.size(); i ++){
            System.out.print(" - " + neighbors.get(i).coords.level + "," + neighbors.get(i).coords.row + "," + neighbors.get(i).coords.col);
        }
        System.out.println("");
    //    System.out.println(neighbors.size());

        
    }

}
