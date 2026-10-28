package AlgoExpert;

public class AStarAlgorithm {

   public static void main(String[] args){

   }

  public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
    // Write your code here.
      Node[][] nodes_graph = initializeNodes(graph);
      Node start_node = new Node(startRow, startCol, graph[startRow][startCol]);
      Node end_node = new Node(endRow, endCol, graph[endRow][endCol]);

      start_node.distanceFromStart = 0;
      start_node.estimatedDistanceToEnd = calculateManhattanDistance(start_node, end_node);
      MinHeapArrayBased minHeap = new MinHeapArrayBased();
    return new int[][] {};
  }

  public int calculateManhattanDistance(Node start_node, Node end_node){
       return Math.abs(start_node.row - end_node.row) + Math.abs(start_node.col - end_node.col);
  }

  public Node[][] initializeNodes(int[][] graph){
       Node[][] nodes_graph = new Node[graph[0].length][graph.length];
       for(int i=0; i<graph.length; i++){
           for(int j=0; j<graph[0].length; j++){
                nodes_graph[i][j] = new Node(i, j, graph[i][j]);
           }
       }
       return nodes_graph;
  }

  public static class Node{
       int row = 0;
       int col = 0;
       int value = 0;
       int distanceFromStart = Integer.MAX_VALUE;
       int estimatedDistanceToEnd = Integer.MAX_VALUE;
       Node cameFrom = null;
       public Node(int row, int col, int value){
           this.row = row;
           this.col = col;
           this.value = value;
       }
  }
}
