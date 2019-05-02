/**
 * Name:
 * Student Number:
 */

public class Coordinates {

    public Integer level;
    public Integer row;
    public Integer col;

    public Coordinates(Integer level, Integer row, Integer col) {
        // TODO: Your code here...
        this.level = level;
        this.row = row;
        this.col = col;
    }

    public boolean equals(Integer level, Integer row, Integer col){
        if(this.level != level) return false;
        if(this.row != row) return false;
        if(this.col != col) return false;

        return true;
    }

}