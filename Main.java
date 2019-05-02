/** 
 * https://stackoverflow.com/questions/21880419/how-to-find-the-longest-simple-path-in-a-graph
 * Name:
 * Student Number:
 */

public class Main {

    public static void main(String[] args) {
        // TODO: Write tests here...
        Graph myGraph = new Graph();

        Character[][][] myMaze = new Character[4][13][8];

        for(int level = 0; level < 4; level++){
            for(int row = 0; row < 13; row++){
                for(int col = 0; col < 8; col++){
                    myMaze[level][row][col] = 'x';
                }
            }
        }

        //level 0
        myMaze[0][6][0] = '.';
        myMaze[0][7][0] = '.';
        myMaze[0][8][0] = '.';
        myMaze[0][9][0] = 'u';
        myMaze[0][10][0] = '.';

        myMaze[0][2][1] = '.';
        myMaze[0][5][1] = '.';
        myMaze[0][6][1] = '.';
        myMaze[0][9][1] = '.';

        myMaze[0][2][2] = '.';
        myMaze[0][3][2] = '.';
        myMaze[0][9][2] = 'u';

        myMaze[0][9][3] = '.';
        myMaze[0][9][4] = '.';
        myMaze[0][5][5] = '.';
        myMaze[0][9][5] = '.';

        myMaze[0][4][6] = '.';
        myMaze[0][5][6] = '.';
        myMaze[0][6][6] = '.';
        
    

        myMaze[1][6][0] = '.';
        myMaze[1][7][0] = '.';
        myMaze[1][8][0] = '.';
        myMaze[1][9][0] = 'b';
        myMaze[1][10][0] = '.';

        myMaze[1][2][1] = '.';
        myMaze[1][5][1] = '.';
        myMaze[1][6][1] = '.';
        myMaze[1][9][1] = '.';

        myMaze[1][2][2] = '.';
        myMaze[1][3][2] = '.';
        myMaze[1][9][2] = 'd';

        myMaze[1][9][3] = '.';

        myMaze[1][5][5] = '.';
        myMaze[1][6][5] = '.';

        myMaze[1][4][6] = '.';
        myMaze[1][5][6] = '.';

        myMaze[1][10][7] = 'u';
        myMaze[1][11][7] = '.';
        myMaze[1][12][7] = '.';

        myMaze[2][6][0] = '.';
        myMaze[2][7][0] = '.';
        myMaze[2][8][0] = '.';
        myMaze[2][9][0] = 'b';
        myMaze[2][10][0] = '.';

        myMaze[2][1][1] = '.';
        myMaze[2][2][1] = '.';
        myMaze[2][5][1] = '.';
        myMaze[2][6][1] = '.';
        myMaze[2][9][1] = 'u';
  

        myMaze[2][2][2] = '.';
        myMaze[2][9][2] = 'u';


        myMaze[2][9][3] = '.';
        myMaze[2][9][4] = '.';
        myMaze[2][9][5] = '.';

        myMaze[2][5][5] = '.';
        myMaze[2][5][6] = '.';
        myMaze[2][4][6] = '.';
        myMaze[2][6][6] = '.';

        myMaze[2][10][7] = 'd';

        
       // myMaze[2][5][6] = '.';

/*
        myMaze[2][1][1] = '.';
        myMaze[2][1][2] = '.';
        myMaze[2][1][3] = '.';
        myMaze[2][2][3] = 'd'; */

        myGraph.createGraphFrom3DMaze(myMaze);

        Vertex[] createdVertexes = myGraph.getAllVertices();
        Vertex[] neighbors;
        for(int i = 0; i < createdVertexes.length; i++){
            createdVertexes[i].print(false);
            neighbors = myGraph.getAdjacentVertices(createdVertexes[i]);
            for(int j = 0; j < neighbors.length; j++){
                System.out.print("\t");
                neighbors[j].print(false);
            }
        }

     //   System.out.println("HEREO");

     /*  Vertex test = new Vertex(0,2,1);
        Vertex[] neighborsTest = myGraph.getAdjacentVertices(test);

        for(int i = 0; i < neighborsTest.length; i++){
            neighborsTest[i].print(false);
        } */




    }
}