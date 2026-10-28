package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


class ReconstructBST_PreOrder {
    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(17);
        list.add(19);
        list.add(18);
        BST bst = reconstructBst(list);
        System.out.println("The End");
    }

  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
    // base case:
		if(preOrderTraversalValues.size()==0) return null;

		int rootNode = preOrderTraversalValues.get(0);
		int rightNodeIdx = preOrderTraversalValues.size();

		for(int i=1; i<preOrderTraversalValues.size(); i++){
			if(rootNode<=preOrderTraversalValues.get(i)){
				rightNodeIdx = i;
				break;
			}
		}
		BST leftBst = reconstructBst(preOrderTraversalValues.subList(1, rightNodeIdx));
		BST rightBst = reconstructBst(preOrderTraversalValues.subList(rightNodeIdx, preOrderTraversalValues.size()));

		BST bst = new BST(rootNode);
		bst.left = leftBst;
		bst.right = rightBst;

		return bst;

  }
}




