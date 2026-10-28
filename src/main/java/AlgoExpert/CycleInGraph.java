package AlgoExpert;

import java.util.Arrays;

public class CycleInGraph {

   public static void main(String[] args){
   	   //int[][] vertexes = {{1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {}};
	   //int[][] vertexes = {{1, 2}, {2, 1}, {1}};
	   //int[][] vertexes = {{1, 2}, {2}, {}};
	   int[][] vertexes = {{1}, {2, 3, 4, 5, 6, 7}, {}, {2, 7}, {5}, {}, {4}, {}};
	   cycleInGraph(vertexes);
   }

  public static boolean cycleInGraph(int[][] edges) {
		for(int i=0; i<edges.length; i++){
			if(edges[i].length==0) {
				continue;
			}
			for(int j=i; j<edges.length; j++){

				for(int k=0; k<edges[j].length; k++) {
					if (i == edges[j][k]) {
						return true;
					}
				}
			}
		}//for
		return false;
	}
}






