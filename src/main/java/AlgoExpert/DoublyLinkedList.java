package AlgoExpert;

public class DoublyLinkedList {
	public static class Node {
		public int value;
		public Node prev;
		public Node next;

		public Node(int value) {
		  this.value = value;
		}
	}

    public static void main(String[] str){
        Node node1 = new Node(5);
        setHead(node1);

        Node node2 = new Node(4);
        setHead(node2);

        Node node3 = new Node(3);
        setHead(node3);

        Node node4 = new Node(2);
        setHead(node4);

        Node node5 = new Node(1);
        setHead(node5);

        Node node6 = new Node(-1);
        setHead(node6);

        Node node7 = new Node(6);
        setTail(node7);

        Node node8 = new Node(3);
        insertBefore(node7, node8);

        Node node9 = new Node(10);
        insertAfter(node7, node9);

        Node node10 = new Node(0);
        insertAfter(node1, node10);

        Node node11 = new Node(15);
        insertAtPosition(2, node11);

        Node node12 = new Node(15);
        removeNodesWithValue(15);

        Node node13 = new Node(-1);
        remove(node13);

        Node node14 = new Node(15);
        boolean value = containsNodeWithValue(15);
        System.out.println("THE END");
    }

    public static Node head;
    public static Node tail;

    public static void setHead(Node node) {
      //if there is no element
			if(head==null){
				head=node;
				tail=node;
				return;
			}
			insertBefore(head, node);
    }

    public static void setTail(Node node) {
      //if there is no element
			if(tail==null){
				setHead(node);
				return;
			}else{
				insertAfter(tail, node);
			}
    }

    public static void insertBefore(Node node, Node nodeToInsert) {
      //check to see if node exists
			if(nodeToInsert==head && nodeToInsert==tail) return;
			remove(nodeToInsert);
			nodeToInsert.next = node;
			nodeToInsert.prev = node.prev;
			if(node.prev==null){
				head = nodeToInsert;
			}else{
				node.prev.next = nodeToInsert;
			}
			node.prev = nodeToInsert;

    }

    public static void insertAfter(Node node, Node nodeToInsert) {
      if(nodeToInsert==head && nodeToInsert==tail) return;
      remove(nodeToInsert);
      nodeToInsert.prev = node;
      nodeToInsert.next = node.next;
      if(node.next==null){
      	tail = nodeToInsert;
	  }else{
      	node.next.prev = nodeToInsert;
	  }
      node.next = nodeToInsert;
    }

    public static void insertAtPosition(int position, Node nodeToInsert) {
      // Write your code here.
			if(position<0) return;
			int index=1;
			Node current = head;
			if(position==index){
				setHead(nodeToInsert);
				return;
			}else{
				while(index<position){
					current = current.next;
					index++;
				}//while
				if(current!=null){
					insertBefore(current, nodeToInsert);
				}else{
					setTail(nodeToInsert);
				}
			}
    }

    public static void removeNodesWithValue(int value) {
      //if list is empty
			if(head==null) return;
			Node current = head;
			while(current!=null){
				if(current.value==value){
					remove(current);
				}
				current = current.next;
			}//while

			return;
    }

    public static void remove(Node node) {
		if(node==head) head = head.next;
		if(node==tail) tail = tail.next;
		removeNodeBindings(node);
    }

    public static void removeNodeBindings(Node node){
    	if(node.prev!=null) node.prev.next = node.next;
    	if(node.next!=null) node.next.prev = node.prev;
    	node.prev = null;
    	node.next = null;
	}

    public static boolean containsNodeWithValue(int value) {
     	Node node = head;
     	while(node!=null && node.value != value) node=node.next;
     	return node!=null;
    }
  }