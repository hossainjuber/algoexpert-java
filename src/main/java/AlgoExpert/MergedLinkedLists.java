package AlgoExpert;

import java.util.LinkedList;

public class MergedLinkedLists {
  public static void main(String[] str){
  	LinkedList l1_8 = new LinkedList(8, null);
  	LinkedList l1_7 = new LinkedList(7, l1_8);
  	LinkedList l1_6 = new LinkedList(6, l1_7);
	LinkedList l1_2 = new LinkedList(2, l1_6);

	LinkedList l2_10 = new LinkedList(10, null);
	LinkedList l2_9 = new LinkedList(9, l2_10);
	LinkedList l2_5 = new LinkedList(5, l2_9);
	LinkedList l2_4 = new LinkedList(4, l2_5);
	LinkedList l2_3 = new LinkedList(3, l2_4);
	LinkedList l2_1 = new LinkedList(1, l2_3);

	mergeLinkedLists(l1_2, l2_1);
  }
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value, LinkedList node) {
      this.value = value;
      this.next = node;
    }
  }

  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    //headOne will be used as the merged linkedlist
		LinkedList one = headOne;
		LinkedList two = headTwo;
		LinkedList prev = null;
		LinkedList head = null;

		while(one!=null && two!=null){
			if(one.value<two.value){
				prev = one;
				one = one.next;

			}else{
				if(prev!=null) prev.next = two;
				prev = two;
				two = two.next;
				prev.next = one;
			}
		}//while

	  if(one==null) prev.next = two;

	  if(headOne.value<headTwo.value){
			head = headOne;
		}else{
			head = headTwo;
		}
      return head;
  }//mergeLinkedLists
}


