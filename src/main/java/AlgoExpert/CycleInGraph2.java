package AlgoExpert;

import java.util.Arrays;
import java.util.HashSet;

public class CycleInGraph2 {

   public static void main(String[] args){
   	   //int[][] vertexes = {{1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {}};
	   //int[][] vertexes = {{1, 2}, {2, 1}, {1}};
	   //int[][] vertexes = {{1, 2}, {2}, {}};
	   //int[][] vertexes = {{1}, {2, 3, 4, 5, 6, 7}, {}, {2, 7}, {5}, {}, {4}, {}};
	   int[][] vertexes = {{1,2}, {2}, {}};
	   cycleInGraph(vertexes);
   }

  public static boolean cycleInGraph(int[][] edges) {
		int numberOfNodes = edges.length;
		boolean[] visited = new boolean[numberOfNodes];
		boolean[] currentlyInStack = new boolean[numberOfNodes];
		Arrays.fill(visited, false);
		Arrays.fill(currentlyInStack, false);

		for(int node=0; node < numberOfNodes; node++){
			if(visited[node]){
				continue;
			}
			boolean containsCycle = isNodeInCycle(node, edges, visited, currentlyInStack);
			if(containsCycle) return true;
		}
		return false;
	}

	public static boolean isNodeInCycle(int node, int[][] edges, boolean[] visited, boolean[] currentlyInStack){
		visited[node] = true;
		currentlyInStack[node] = true;

		boolean containsCycle = false;
		int[] neighbors = edges[node];
		for(int neighbor : neighbors){
			if(!visited[neighbor]){
				containsCycle = isNodeInCycle(neighbor, edges, visited, currentlyInStack);
			}
			if(containsCycle){
				return true;
			}else if(currentlyInStack[neighbor]){
				return true;
			}
		}//for
		currentlyInStack[node] = false;
		return false;

	}
}






