package AlgoExpert;

import java.util.*;

public class hasSingleCycle {

   public static void main(String[] args){
       int[] array = {2,3,1,-4,-4,2};
        hasSingleCycle(array);
   }

    public static boolean hasSingleCycle(int[] array) {
            int visited = 0;
            int currentIdx = 0;
            while(visited<array.length){
                if(visited>0 && currentIdx==0){
                    return false;
                }
                visited++;
                currentIdx = getNextIndex(currentIdx, array);
            }
            return currentIdx==0;
    }

    public static int getNextIndex(int currentIdx, int[] array){
       int currentIdxValue = array[currentIdx];
       int nextIdxValue = (currentIdxValue + currentIdx) % array.length;
       return nextIdxValue>=0 ? nextIdxValue : nextIdxValue+array.length;
    }


}
