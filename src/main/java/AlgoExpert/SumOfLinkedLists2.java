package AlgoExpert;

public class SumOfLinkedLists2 {

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
	int divisor = 10;
	int dividend = 0;
	int quotient = 0;
	int remainder = 0;
   	LinkedList l1 = linkedListOne;
	LinkedList l2 = linkedListTwo;
	LinkedList headNode = new LinkedList(0);
	LinkedList currentNode = headNode;

	while(l1!=null || l2!=null){
		if(l1!=null && l2 !=null){
			dividend = l1.value + l2.value;
		}else if(l1!=null && l2==null){
			dividend = l1.value;
		}else if(l1==null && l2!=null){
			dividend = l2.value;
		}

		dividend = dividend + quotient;
		quotient = dividend / divisor;
		remainder = dividend % divisor;
		LinkedList newNode = new LinkedList(remainder);
		currentNode.next = newNode;
		currentNode = newNode;

		l1 = l1!=null ? l1.next :  null;
		l2 = l2!=null ? l2.next :  null;
	}//while

	  if(quotient>0){
	    	LinkedList newNode = new LinkedList(remainder);
			currentNode.next = newNode;
		}
	  return headNode.next;
  }


}
