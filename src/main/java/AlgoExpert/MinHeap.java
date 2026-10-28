package AlgoExpert;

import java.util.ArrayList;
import java.util.List;


public class MinHeap {

	public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        List<Integer> list = new ArrayList<>();
        list.add(48);
        list.add(12);
        list.add(24);
        list.add(7);
        list.add(8);
        list.add(-5);
        list.add(24);
        list.add(391);
        list.add(24);
        list.add(56);
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(41);
        MinHeap minHeap = new MinHeap(list);
    }


    List<Integer> heap = new ArrayList<Integer>();

	public int getLeftChildIndex(int parentIndex){return (parentIndex*2)+1;}
	public int getRightChildIndex(int parentIndex){return (parentIndex*2)+2;}
	public int getParentIndex(int childIndex){return (childIndex-1)/2;}
	public int getLeftChild(int parentIndex){return heap.get(getLeftChildIndex(parentIndex));}
	public int getRightChild(int parentIndex){return heap.get(getRightChildIndex(parentIndex));}
	public int getParent(int childIndex){return heap.get(getParentIndex(childIndex));}
	public boolean hasLeftChild(int parentIndex){return getLeftChildIndex(parentIndex) < heap.size();}
	public boolean hasRightChild(int parentIndex){return getRightChildIndex(parentIndex) < heap.size();}
	public boolean hasParent(int childIndex){return getParentIndex(childIndex) >= 0;}

    public MinHeap(List<Integer> array) {
      heap = array;
      heap = buildHeap(array);
    }

	public List<Integer> buildHeap(List<Integer> array) {
		int firstParent = (array.size()-2)/2;
		for(int i=firstParent; i>=0; i--){
		  siftDown(i, array.size()-1, array);
		}
		return array;
    }


    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
		int index = currentIdx;
		while(hasLeftChild(index)){
			int lesserChildIndex = getLeftChildIndex(index);
			int lesserChild=heap.get(lesserChildIndex);
			if(hasRightChild(index)){
				if(getRightChild(index)<lesserChild){
					lesserChildIndex = getRightChildIndex(index);
					lesserChild = heap.get(lesserChildIndex);
				}
			}
			int parent = heap.get(index);
			if(parent > lesserChildIndex){
				swap(index, lesserChildIndex, heap);
			}else{
				return;
			}
			index = lesserChildIndex;
    	}//while
		System.out.println("The End");
	}

    public void siftUp(int currentIdx, List<Integer> heap) {
      // Write your code here.
		int parent_idx = getParentIndex(currentIdx);
		while(hasParent(currentIdx) && heap.get(parent_idx)> heap.get(currentIdx)) {
			int leftChildIndex = getLeftChildIndex(parent_idx);
			int rightChildIndex = getRightChildIndex(parent_idx);
			int smallerChild = Math.min(heap.get(leftChildIndex), heap.get(rightChildIndex));
			swap(parent_idx, smallerChild, heap);
			currentIdx = getParentIndex(currentIdx);
		}
    }

    public int peek() {
      return heap.get(0);
    }

    public int remove() {
			swap(0, heap.size()-1, heap);
			int removedValue = heap.get(heap.size()-1);
			heap.remove(heap.size()-1);
			siftDown(0, heap.size()-1, heap);
    	return removedValue;
		}

    public void insert(int value) {
			heap.add(value);
			siftUp(heap.size()-1, heap);
    }

	public void swap(int idx1, int idx2, List<Integer> heap){
		Integer temp = heap.get(idx1);
		heap.set(idx1, heap.get(idx2));
		heap.set(idx2, temp);
	}
}
