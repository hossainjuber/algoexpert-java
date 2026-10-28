package AlgoExpert;

import java.util.ArrayList;
import java.util.List;
//https://www.algoexpert.io/questions/Branch%20Sums

public class BranchSumsRecursive {

   public static void main(String[] args) {
       /*{
  "tree": {
    "nodes": [
      {"id": "1", "left": "2", "right": "3", "value": 1},
      {"id": "2", "left": "4", "right": "5", "value": 2},
      {"id": "3", "left": "6", "right": "7", "value": 3},
      {"id": "4", "left": "8", "right": "9", "value": 4},
      {"id": "5", "left": null, "right": null, "value": 5},
      {"id": "6", "left": null, "right": null, "value": 6},
      {"id": "7", "left": null, "right": null, "value": 7},
      {"id": "8", "left": null, "right": null, "value": 8},
      {"id": "9", "left": null, "right": null, "value": 9}
    ],
    "root": "1"
  }
}*/
       int result = nodeDepths(null);
   }

      public static int nodeDepths(BinaryTree root) {
    // Write your code here.
		int sum = nodeDepthsRecursively(root, 0);

    return sum;
  }

	public static int nodeDepthsRecursively(BinaryTree root, int depth) {
    // Write your code here.
		if(root==null) return 0;

		return depth + nodeDepthsRecursively(root.left, depth+1)
			+ nodeDepthsRecursively(root.right, depth+1);
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
