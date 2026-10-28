package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapListBased {
    public static void main(String[] str){
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
        MinHeapListBased minHeap = new MinHeapListBased(list);
        minHeap.add(76);
        int peekValue = minHeap.peek();
        int removedValue = minHeap.remove();
        peekValue = minHeap.peek();
        removedValue = minHeap.remove();
        peekValue = minHeap.peek();
        minHeap.add(76);
    }

    MinHeapListBased(List<Integer> list){
        heap = buildHeap(list);
    }

    List<Integer> heap = new ArrayList<>();

    private int getParentIndex(int childIndex){return (childIndex-1)/2;}
    private int getLeftChildIndex(int parentIndex){return (parentIndex*2)+1;}
    private int getRightChildIndex(int parentIndex){return (parentIndex*2)+2;}
    private boolean hasLeftChild(int parentIndex){return getLeftChildIndex(parentIndex) < heap.size();}
    private boolean hasRightChild(int parentIndex){return getRightChildIndex(parentIndex) < heap.size();}
    private boolean hasParent(int childIndex){return getParentIndex(childIndex) >=0;}

    private int getLeftChild(int parentIndex){return heap.get(getLeftChildIndex(parentIndex));}
    private int getRightChild(int parentIndex){return heap.get(getRightChildIndex(parentIndex));}
    private int getParent(int childIndex){return heap.get(getParentIndex(childIndex));}


    public void swap(int idx1, int idx2){
        int temp = heap.get(idx1);
        heap.set(idx1, heap.get(idx2));
        heap.set(idx2, temp);
    }

    public void siftDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index)<getLeftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            if(heap.get(index)< heap.get(smallerChildIndex)){
                break;
            }else{
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void siftUp(){
        int childIndex = heap.size()-1;
        int parent = getParent(childIndex);
        int child = heap.get(childIndex);
        while(hasParent(childIndex) && getParent(childIndex)>heap.get(childIndex)){
            swap(childIndex, getParentIndex(childIndex));
            childIndex = getParentIndex(childIndex);
        }
    }

    public void add(int item){
        heap.add(item);
        siftUp();
    }

    public int remove(){
        swap(0, heap.size()-1);
        int valueToBeRemoved = heap.get(heap.size()-1);
        heap.remove(heap.size()-1);
        siftDown();
        return valueToBeRemoved;
    }

    public List<Integer> buildHeap(List<Integer> array) {
		for(int i=array.size()-1; i>=0; i--){
		    add(array.get(i));
        }
		return heap;
    }

    public int peek() {
        return heap.get(0);
    }


	/*public List<Integer> buildHeap(List<Integer> array) {
		int firstParent = (array.size()-2)/2;
		for(int i=firstParent; i>=0; i--){
		  siftDown(i, array.size()-1, array);
		}
		return array;
    }*/
}
