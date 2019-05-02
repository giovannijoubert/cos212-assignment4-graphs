import java.util.ArrayList;
import java.util.List;

/**
 * Name:
 * Student Number:
 */

public class Vertex {
   
    public Coordinates coords;

    private List<Vertex> neighbors;
    
    public Vertex(Integer level, Integer row, Integer col) {
        coords = new Coordinates(level, row, col);
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Vertex vertex) {
		this.neighbors.add(vertex);
    }
    
    public boolean isNeighbor(Vertex vertex){
        for(int i = 0; i < neighbors.size(); i++)
            if(neighbors.get(i) == vertex) return true;

        return false;
    }

    public void print(){
        System.out.print(coords.level + "," + coords.row + "," + coords.col);
        for(int i = 0; i < neighbors.size(); i ++){
            System.out.print(" - " + neighbors.get(i).coords.level + "," + neighbors.get(i).coords.row + "," + neighbors.get(i).coords.col);
        }
        System.out.println("");
    //    System.out.println(neighbors.size());

        
    }

}
