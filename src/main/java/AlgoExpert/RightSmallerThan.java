package AlgoExpert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
//https://www.algoexpert.io/questions/Calendar%20Matching

/*
 1. Write a function that takes in a calendar and returns all free time intervals.  The
 method should also take in the boudns and augment it in the beginnign and end.
 2. From calendarMatching calll that function and generate two list for the two calendars
 3. Iterate over the two list using pointers and generate a new list that compares each intervals
 from both list and takes in the later starting time and earlier end time from both in order
 to generate an interval.
*/

public class RightSmallerThan {

   public static void main(String[] args) {

       List<Integer> list = new ArrayList<>();
       list.add(8);
       list.add(5);
       list.add(11);
       list.add(-1);
       list.add(3);
       list.add(4);
       list.add(2);
       List<Object> array = new ArrayList<>();
       System.out.println(array.getClass());
       //rightSmallerThan(list);

   }

  /*public static List<Integer> rightSmallerThan(List<Integer> array) {
    // Write your code here.
    BST bst = new BST();
    for(int i=array.size()-1; i>=0; i--){
        bst.insert(array.get(i));
    }


    return new ArrayList<Integer>();
  }

  public static class BST{
    Node root;
    public class Node{
        Node left;
        Node right;
        int key;
        int num_of_smaller_keys;
        int rs_num;

        public Node(Node left, Node right, int key, int num_of_smaller_keys){
            this.left = left;
            this.right = right;
            this.key = key;
            this.num_of_smaller_keys = num_of_smaller_keys;
        }
    }

    public void insert(int key){
        List<Integer> list = new ArrayList<>();
        root = insertKey(key, root, 0, list);
    }

    public Node insertKey(int key, Node root, int rs_num, int num List<Integer> list){
        if(root==null){
            root = new Node(null, null, key, 0);
        }else{
            if(key<root.key){
                root.num_of_smaller_keys++;
                root.left = insertKey(key, root.left, 0, list);
            }else if(key>=root.key){
                if(key>root.key){

                    root.right = insertKey(key, root.right, root.num_of_smaller_keys+rs_num++, list);
                }
            }
        }//insertKey
        list.add(rs_num);
        return root;
    }
  }*/

}
