package AlgoExpert;

import java.util.ArrayList;
import java.util.List;
//https://www.algoexpert.io/questions/Branch%20Sums

public class BranchSumsIterative {

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
        List<Level> list = new ArrayList<>();
        int depth =0;
        list.add(new Level(root, depth));
        Level level = null;
        int depth_sum = 0;
        BinaryTree node = null;
        while(list.size()>0){
            level = list.remove(list.size()-1);
            node = level.root;
            depth = level.depth;
            if(node==null) continue;
            depth_sum += level.depth;
            list.add(new Level(node.left, depth +1));
            list.add(new Level(node.right, depth +1));
        }

        return depth_sum;
    }

    static class Level{
        BinaryTree root;
        int depth;

        Level(BinaryTree r, int d){
            root = r;
            depth = d;
        }
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
