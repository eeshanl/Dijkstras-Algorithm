public class Node {
   int cost;
   Node path;
   boolean known;
   char character;
   
   public Node(char c) {
      cost = Integer.MAX_VALUE;
      known = false;
      character = c;
   }
}