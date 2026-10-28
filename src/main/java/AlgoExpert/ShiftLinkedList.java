package AlgoExpert;

public class ShiftLinkedList {

    public static void main(String[] str){
		LinkedList l1 = new LinkedList(5, null);
		LinkedList l2 = new LinkedList(4, l1);
		LinkedList l3 = new LinkedList(3, l2);
		LinkedList l4 = new LinkedList(2, l3);
		LinkedList l5 = new LinkedList(1, l4);
		LinkedList l6 = new LinkedList(0, l5);
		shiftLinkedList(l6, -3);
        System.out.println("THE END");
    }

	  public static LinkedList shiftLinkedList(LinkedList head, int k) {
		LinkedList fast = head;
		LinkedList slow = head;
		LinkedList node = head;
		int listLength=1;
		node = head;
		while(node.next!=null){
			node=node.next;
			listLength++;
		}
		int shifted_position = k;
		shifted_position = Math.abs(shifted_position) % listLength;
		int k_jump = 0;
		if(shifted_position==0) return head;
		if(k>0)
		{
			while(k_jump<shifted_position){
				fast = fast.next;
				k_jump++;
			}
			while(fast.next!=null){
				fast=fast.next;
				slow=slow.next;
			}
			fast.next = head;
			LinkedList newHead = slow.next;
			slow.next = null;
			return newHead;
		} else{
			fast = head;
			slow = head;
			k_jump =1;
			fast=fast.next;
			while(k_jump<shifted_position){
				fast = fast.next;
				slow = slow.next;
				k_jump++;
			}//while
			LinkedList circular_node = head;
			while(circular_node.next!=null){
				circular_node = circular_node.next;
			}
			circular_node.next = head;
			slow.next = null;
			return fast;
		}
	}

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value, LinkedList l) {
      this.value = value;
      next = l;
    }

  }


  }