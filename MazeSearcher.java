
// MazeSearcher.java
// Andrew Davison, ad@fivedots.coe.psu.ac.th, Jan 2021
/* 
   Usage:
      java MazeSearcher maze1.txt    (maze2.txt)
*/

import java.io.*;
import java.util.*;

public class MazeSearcher {
  // private static final int[][] STEPS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0
  // } }; // (dx, dy)
  // DOWN RIGHT UP LEFT

  public MazeSearcher(Maze maze) {
    ArrayList<Coord> path = new ArrayList<>();
    Coord entry = maze.getStart();
    if (explore(maze, entry.getX(), entry.getY(), path)) {
      maze.printPath(path);
    } else
      System.out.println("No path found");
  } // end of MazeSearcher()

  private boolean explore(Maze maze, int x, int y, ArrayList<Coord> path) {
    // Students: put your code here
    //6135512003

    if (!maze.isValidLoc(x, y)  // check (x,y) not inside the maze 
     || maze.isWall(x, y)       // check (x,y) is wall 
     || maze.wasVisited(x, y))  // check (x,y) was visited
    {
      return false;
    }

    if (maze.isExit(x, y)) { //check (x,y) in the exit 
      return true; 
    }
    if (maze.isValidLoc(x, y)) { //check (x,y) inside the maze
      maze.setVisited(x, y); //set (x,y) visited

      if (explore(maze, x, y + 1, path)  //Down
       || explore(maze, x + 1, y, path)  //Right
       || explore(maze, x, y - 1, path)  //UP
       || explore(maze, x - 1, y, path)) //Left
      {
        path.add(new Coord(x, y)); //add new state
        return true;
      } 
      else
        return false;
    }
    return false;
  } // end of explore()

  // Students: you can add other functions if you wish

  // --------------------------------------------

  public static void main(String[] args) throws Exception {
    if (args.length != 1)
      System.out.println("Usage: java MazeSearcher <maze textfile>");
    else {
      Maze maze = new Maze(new File(args[0]));
      MazeSearcher dfs = new MazeSearcher(maze);
    }
  }

} // end of MazeSearcher class
