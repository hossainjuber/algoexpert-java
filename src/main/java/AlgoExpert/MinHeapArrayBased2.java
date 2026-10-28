package AlgoExpert;

import java.util.Arrays;

public class MinHeapArrayBased2 {
    public static void main(String[] str) {
        //int[] array = new int[]{48, 12,24,7,8,-5,24,391,24,56,2,6,8,41};
        int[] array = new int[]{-10, -7, -7, -6, -6, -5, -5, -4, -4, -4, -2, -1, 1, 3, 5, 5, 6, 8, 8, 10};

    }



    int size;
    int capacity=10;
    int[] minHeap = new int[capacity];
    MinHeapArrayBased2(int[] array){
        for(int i=0; i<array.length; i++){
            add(array[i]);
        }
    }

    int getLeftChildIndex(int parentIndex){ return (parentIndex*2)+1; }
    int getRightChildIndex(int parentIndex){ return (parentIndex*2)+2; }
    int getParentIndex(int childIndex){ return (childIndex-1)/2; }

    public boolean hasLeftChild(int parentIndex){ return getLeftChildIndex(parentIndex) <= size; }
    public boolean hasRightChild(int parentIndex){ return getRightChildIndex(parentIndex) <= size; }
    public boolean hasParent(int childIndex){ return getParentIndex(childIndex) >= 0; }

    int getLeftChild(int parentIndex){ return minHeap[getLeftChildIndex(parentIndex)]; }
    int getRightChild(int parentIndex){ return minHeap[getRightChildIndex(parentIndex)]; }
    int getParent(int childIndex){ return minHeap[getLeftChildIndex(childIndex)]; }

    public void add(int element){
        ensureExtraCapacity();
        minHeap[size++] = element;
        heapifyUp();
    }

    public int poll(){
        if(size==0) throw new IllegalStateException();
        int result = minHeap[0];
        size--;
        minHeap[0] = minHeap[size-1];
        heapifyDown();
        return result;
    }

    public int peek(){
        if(size==0) throw new IllegalStateException();
        return minHeap[0];
    }

    public void ensureExtraCapacity(){
        if(size==capacity){
            capacity = capacity * 2;
            minHeap = Arrays.copyOf(minHeap, capacity);
        }
    }

    public void swap(int idx1, int idx2){
        int idx1_value = minHeap[idx1];
        minHeap[idx1] = minHeap[idx2];
        minHeap[idx2] = idx1_value;
    }

    public void heapifyUp(){
        int index = size-1;
        while(hasParent(minHeap[index]) && getParent(index) > minHeap[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChild(index);
            if(getLeftChild(index) < getRightChild(index)){
                smallerChildIndex = getRightChild(index);
            }
            if(getParent(index) > minHeap[smallerChildIndex]){
                swap(index, smallerChildIndex);
            }else{
                break;
            }
            index = smallerChildIndex;
        }


    }
}
