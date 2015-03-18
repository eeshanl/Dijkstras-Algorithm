import java.util.*;


public class Graph {
   // 2d array to represent graph
   int[][] graph = new int[][] {
      {0, 5, 3, 0, 0, 0, 0},
      {0, 0, 2, 0, 3, 0, 1},
      {0, 0, 0, 7, 7, 0, 0},
      {2, 0, 0, 0, 0, 6, 0},
      {0, 0, 0, 2, 0, 1, 0},
      {0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 0, 0}
   };
   
   Node[] nodes;
   
   public Graph() {
      nodes = new Node[7];
   }
}
