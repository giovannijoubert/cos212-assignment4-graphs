/** 
 * https://stackoverflow.com/questions/21880419/how-to-find-the-longest-simple-path-in-a-graph
 * Name:
 * Student Number:
 */

public class Main {

    public static void main(String[] args) {
        // TODO: Write tests here...
        Graph myGraph = new Graph();

        Character[][][] myMaze = new Character[3][5][5];

        for(int level = 0; level < 3; level++){
            for(int row = 0; row < 5; row++){
                for(int col = 0; col < 5; col++){
                    myMaze[level][row][col] = 'x';
                }
            }
        }

        myMaze[0][1][1] = '.';
        myMaze[0][1][2] = '.';
        myMaze[0][3][3] = '.';
        myMaze[0][2][1] = 'u';
        myMaze[0][2][3] = 'u';

        myMaze[1][1][1] = '.';
        myMaze[1][1][2] = '.';
        myMaze[1][1][3] = '.';
        myMaze[1][3][1] = '.';
        myMaze[1][3][2] = '.';
        myMaze[1][3][3] = '.';
        myMaze[1][2][1] = 'd';
        myMaze[1][2][3] = 'b';


        myMaze[2][1][1] = '.';
        myMaze[2][1][2] = '.';
        myMaze[2][1][3] = '.';
        myMaze[2][2][3] = 'd';

        myGraph.createGraphFrom3DMaze(myMaze);

        Vertex[] createdVertexes = myGraph.getAllVertices();

        for(int i = 0; i < createdVertexes.length; i++){
            createdVertexes[i].print();
        }

        System.out.println("uhhhwhat");


    }
}