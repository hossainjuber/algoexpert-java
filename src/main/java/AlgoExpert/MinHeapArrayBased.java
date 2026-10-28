package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapArrayBased {
    public static void main(String[] str){
        //int[] array = new int[]{48, 12,24,7,8,-5,24,391,24,56,2,6,8,41};
        int[] array = new int[]{-10, -7, -7, -6, -6, -5, -5, -4, -4, -4, -2, -1, 1, 3, 5, 5, 6, 8, 8, 10};

        MinHeapArrayBased minHeap = new MinHeapArrayBased(array);
		int[] sorted = new int[array.length];
		int index = 0;
		for(int i=array.length-1; i>=0; i--){
			sorted[index] = minHeap.poll();
			index++;
		}
        /*minHeap.add(76);
        int peekValue = minHeap.peek();
        int removedValue = minHeap.poll();
        peekValue = minHeap.peek();
        removedValue = minHeap.poll();
        peekValue = minHeap.peek();
        minHeap.add(76);*/
        System.out.println("The End");
    }

    MinHeapArrayBased(){}
    MinHeapArrayBased(int[] array){
        items = buildHeap(array);
    }

    public int[] buildHeap(int[] array){
        for(int i=array.length-1; i>=0; i--){
            add(array[i]);
        }
        return items;
    }

    private int capacity = 10;
    private int size = 0;
    int[] items = new int[capacity];

    private int getLeftChildIndex(int parent_index){ return (2 * parent_index) + 1;}
    private int getRightChildIndex(int parent_index){ return (2 * parent_index) + 2;}
    private int getParentIndex(int child_index){ return (child_index -1) / 2;}

    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index){ return getRightChildIndex(index) < size;}
    private boolean hasParent(int index){ return getParentIndex(index) >= 0;}

    private int getLeftChild(int index) {return items[getLeftChildIndex(index)];}
    private int getRightChild(int index) {return items[getRightChildIndex(index)];}
    private int getParent(int index) {return items[getParentIndex(index)];}

    private void swap(int index_one, int index_two){
        int temp = items[index_two];
        items[index_two] = items[index_one];
        items[index_one] = temp;
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity = capacity * 2;
        }
    }

    private int peek(){
        if(size==0){ throw new IllegalStateException();}
        return items[0];
    }

    public int poll(){
        if(size==0){ throw new IllegalStateException();}
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && getParent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }

    }

    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] < items[smallerChildIndex]){
                break;
            }else{
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }




}
