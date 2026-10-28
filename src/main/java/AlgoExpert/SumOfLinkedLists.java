package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SumOfLinkedLists {

   public static void main(String[] args){
		LinkedList ll1_1 = new LinkedList(1);
		ll1_1.next = null;
		LinkedList ll1_7 = new LinkedList(7);
		ll1_7.next = ll1_1;
		LinkedList ll1_4 = new LinkedList(4);
		ll1_4.next = ll1_7;
		LinkedList ll1_2 = new LinkedList(2);
		ll1_2.next = ll1_4;

		LinkedList ll2_5 = new LinkedList(5);
		ll2_5.next = null;
		LinkedList ll2_4 = new LinkedList(4);
		ll2_4.next = ll2_5;
		LinkedList ll2_9 = new LinkedList(9);
		ll2_9.next = ll2_4;


	   /*LinkedList ll1_2 = new LinkedList(2);
	   ll1_2.next = null;
	   LinkedList ll2_9 = new LinkedList(9);
	   ll2_9.next = null;*/

	   sumOfLinkedLists(ll1_2, ll2_9);
   }

  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    LinkedList sl = null;
		int divisor = 10;
		int dividend = 0;
		int remainder = 0;
		int quotient = 0;

		LinkedList newLinkedListHeadPointer = new LinkedList(0);
		LinkedList currentNode = newLinkedListHeadPointer;
		while(linkedListOne!=null || linkedListTwo!=null){
			if(linkedListOne!=null && linkedListTwo!=null){
				dividend = linkedListOne.value + linkedListTwo.value;
			}else if(linkedListOne==null && linkedListTwo!=null){
				dividend = linkedListTwo.value;
			}else if(linkedListOne!=null && linkedListTwo==null){
				dividend = linkedListOne.value;
			}
			dividend += quotient;
			quotient = dividend / divisor;
			remainder = dividend % divisor;
			LinkedList newNode = new LinkedList(remainder);
      		currentNode.next = newNode;
			currentNode = newNode;

			linkedListOne = (linkedListOne!=null) ? linkedListOne.next : null;
			linkedListTwo = (linkedListTwo!=null) ? linkedListTwo.next : null;
		}//while
	    if(quotient>0){
	    	LinkedList newNode = new LinkedList(remainder);
			currentNode.next = newNode;
		}

		return newLinkedListHeadPointer.next;
  }


}
