package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://www.algoexpert.io/questions/Validate%20Subsequence
public class ValidateSequence {

    public static void main(String[] str){
        List<Integer> array = Arrays.asList(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = Arrays.asList(100);
        boolean result = isValidSubsequence(array, sequence);
        System.out.println("The End");
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int p1 = 0;
        int p2 = 0;
        if(sequence.size() > array.size()) return false;

        if(sequence.size()==1){
            if(getIndex(array, sequence.get(0), 0)==-1) {
                return false;
            }
            return true;
        }

        for(int i=0; i<sequence.size()-1; i=i+2){
            p1 = getIndex(array, sequence.get(i), p1);
            if(p1==-1) return false;
            p2 = getIndex(array, sequence.get(i+1), p1+1);
            if(p2==-1) return false;
            if(p1>p2){
                return false;
            }
            p1=p2+1;
        }
        return true;
    }

    public static int getIndex(List<Integer> array, int toFind, int starting_index){
        for(int i=starting_index; i<array.size(); i++){
            if(array.get(i)==toFind) return i;
        }
        return -1;
    }
}


