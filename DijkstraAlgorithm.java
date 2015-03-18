import java.util.*;

public class DijkstraAlgorithm {
   public static void main (String[] args) {
      Graph G = new Graph();
      Node a = new Node('a');
      Node b = new Node('b');
      Node c = new Node('c');
      Node d = new Node('d');
      Node e = new Node('e');
      Node f = new Node('f');
      Node g = new Node('g');
      G.nodes[0] = a;
      G.nodes[1] = b;
      G.nodes[2] = c;
      G.nodes[3] = d;
      G.nodes[4] = e;
      G.nodes[5] = f;
      G.nodes[6] = g;
      dijkstra(G, a);
      for (int i = 0; i < 7; i++) {
         System.out.println("from a to: " + G.nodes[i].character);
         System.out.println("\t" + "Shortest path with least cost: " + G.nodes[i].cost);
      }
      
   }
   
   public static void dijkstra(Graph G, Node strt) {
      strt.cost = 0;
      while (Unkown(G)) {
         Node low = lowestCost(G);
         low.known = true;
         int ind = index(low.character, G);
         for (int i = 0; i < 7; i++) {
            if (G.graph[ind][i] != 0) {
               Node temp = G.nodes[i];
               if (temp.known == false) {
                  //System.out.println(low.character + " -> " + temp.character);
                  //System.out.println((low.cost + weight(low, temp, G)));
                  if((low.cost + weight(low, temp, G)) < temp.cost) {
                     temp.cost = low.cost + weight(low, temp, G);
                     temp.path = low;
                  }
               }
            }
         }
      }
   }
   
   
   private static boolean Unkown(Graph G) {
      boolean flag = false;
      for (Node node : G.nodes) {
         if (node.known == false) {
            flag = true;
         }
      }
      return flag;
   }
   
   private static Node lowestCost(Graph G) {
      Node minNode = new Node('Z');
      minNode.cost = Integer.MAX_VALUE;
      for (Node node : G.nodes) {
         if (!node.known) {
            if (node.cost < minNode.cost) {
               minNode = node;
            }   
         }
      }
      return minNode;
   }
   
   public static int index(char character, Graph G) {
      for (int i = 0; i < 7; i++) {
         if (G.nodes[i].character == character) {
            return i;
         }
      }
      return Integer.MIN_VALUE;
   }
   
   public static int weight(Node b, Node a, Graph G) {
      return G.graph[index(b.character, G)][index(a.character, G)];
   }
}