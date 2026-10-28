package AlgoExpert;

import java.util.*;

public class RightSiblingTree {

   public static void main(String[] args){
       BinaryTree fourteen = new BinaryTree(14);

       BinaryTree eight = new BinaryTree(8);
       BinaryTree nine = new BinaryTree(9);
       BinaryTree ten = new BinaryTree(10);
       BinaryTree eleven = new BinaryTree(11);
       BinaryTree twelve = new BinaryTree(12);
       BinaryTree thirteen = new BinaryTree(13);

       BinaryTree four = new BinaryTree(4);
       BinaryTree five = new BinaryTree(5);
       BinaryTree six = new BinaryTree(6);
       BinaryTree seven = new BinaryTree(6);

       BinaryTree two = new BinaryTree(2);
       BinaryTree three = new BinaryTree(3);

       BinaryTree one = new BinaryTree(1);

       //binding the tree from root to leaf:
       one.left = two;
       one .right = three;
       two.left = four;
       two.right = five;
       three.left = six;
       three.right = seven;
       four.left = eight;
       four.right = nine;
       five.right = ten;
       five.left = null;
       six.left = eleven;
       six.right = null;
       seven.left = twelve;
       seven.right = thirteen;
       eleven.left = fourteen;
       eleven.right = null;

       rightSiblingTree(one);

   }

   public static BinaryTree rightSiblingTree(BinaryTree root) {
    // Write your code here.
		mutate(root, null, false);
		return root;
   }

	public static void mutate(BinaryTree node, BinaryTree parent, boolean isLeftChild){
		if(node==null) {
            return;
        }

		BinaryTree left = node.left;
		BinaryTree right = node.right;
		mutate(left, node, true);
		if(parent==null){
			node.right = null;
		} else if(isLeftChild){
			node.right = parent.right;
		}else{
			if(parent.right==null){
				node.right = null;
			}else{
				node.right = parent.right.left;
			}
		}
		mutate(right, node, false);
	}

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }


}
