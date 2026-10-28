package AlgoExpert;

import java.util.Arrays;
import java.util.function.BiFunction;

public class ContinuousMedianHandler {

    public static void main(String[] str){
        insert(5);
        insert(10);
        double median = getMedian();
        insert(100);
        median = getMedian();


    }//main

    static int[] heap = new int[]{};
    static double median = 0;
    static Heap max_heap = new Heap(Heap::MAX_HEAP_FUNC, heap);
    static Heap min_heap = new Heap(Heap::MIN_HEAP_FUNC, heap);

    public static void insert(int number) {
      if(min_heap.size==0 || min_heap.peek()>number){
          min_heap.add(number);
      }else{
          max_heap.add(number);
      }
      rebalanceHeaps();
      updateMedian();
    }

    public static void rebalanceHeaps(){
        if(min_heap.size - max_heap.size == 2){
            max_heap.add(min_heap.poll());
        }else if(max_heap.size - min_heap.size == 2){
            min_heap.add(max_heap.poll());
        }
    }

    public static void updateMedian(){
        if(min_heap.size == max_heap.size){
            median = ( (double) min_heap.peek() + (double) max_heap.peek() ) / 2;
        }else if(min_heap.size > max_heap.size){
            median = min_heap.peek();
        }else{
            median = max_heap.peek();
        }
    }

    public static double getMedian() {
      return median;
    }

    public static class Heap {
        int size;
        int capacity=10;
        int[] heap = new int[capacity];
        BiFunction<Integer, Integer, Boolean> comparisonFunc;

        Heap(BiFunction<Integer, Integer, Boolean> func, int[] array){
            comparisonFunc = func;
            for(int i=0; i<array.length; i++){
                add(array[i]);
            }
        }

        public static Boolean MAX_HEAP_FUNC(Integer a, Integer b){ return a > b; }
        public static Boolean MIN_HEAP_FUNC(Integer a, Integer b){ return a < b; }

        int getLeftChildIndex(int parentIndex){ return (parentIndex*2)+1; }
        int getRightChildIndex(int parentIndex){ return (parentIndex*2)+2; }
        int getParentIndex(int childIndex){ return (childIndex-1)/2; }

        public boolean hasLeftChild(int parentIndex){ return getLeftChildIndex(parentIndex) <= size; }
        public boolean hasRightChild(int parentIndex){ return getRightChildIndex(parentIndex) <= size; }
        public boolean hasParent(int childIndex){ return getParentIndex(childIndex) >= 0; }

        int getLeftChild(int parentIndex){ return heap[getLeftChildIndex(parentIndex)]; }
        int getRightChild(int parentIndex){ return heap[getRightChildIndex(parentIndex)]; }
        int getParent(int childIndex){ return heap[getLeftChildIndex(childIndex)]; }

        public void add(int element){
            ensureExtraCapacity();
            heap[size++] = element;
            heapifyUp();
        }

        public int poll(){
            if(size==0) throw new IllegalStateException();
            int result = heap[0];
            size--;
            heap[0] = heap[size-1];
            heapifyDown();
            return result;
        }

        public int peek(){
            if(size==0) throw new IllegalStateException();
            return heap[0];
        }

        public void ensureExtraCapacity(){
            if(size==capacity){
                capacity = capacity * 2;
                heap = Arrays.copyOf(heap, capacity);
            }
        }

        public void swap(int idx1, int idx2){
            int idx1_value = heap[idx1];
            heap[idx1] = heap[idx2];
            heap[idx2] = idx1_value;
        }

        public void heapifyUp(){
            int index = size-1;
            while(hasParent(index) && comparisonFunc.apply(getParent(index), heap[index])){
                if(getParent(index) > heap[index]){
                    swap(getParentIndex(index), index);
                    index = getParentIndex(index);
                }else{
                    return;
                }
            }
        }

        public void heapifyDown(){
            int index = 0;
            while(hasLeftChild(index)){
                int smallerChildIndex = getLeftChild(index);
                //if(getLeftChild(index) < getRightChild(index)){
                if(comparisonFunc.apply(getLeftChild(index), getRightChild(index))){
                    smallerChildIndex = getRightChild(index);
                }
                //if(getParent(index) > heap[smallerChildIndex]){
                if(comparisonFunc.apply(getParent(index), heap[smallerChildIndex])){
                    swap(index, smallerChildIndex);
                }else{
                    break;
                }
                index = smallerChildIndex;
            }
        }//heapifyDown

    }
}


