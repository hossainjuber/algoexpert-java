package AlgoExpert;

import java.util.Arrays;

public class SameBSTS {

    public static void main(String[] args){
       //int[] a1 = new int[] {10, 15, 8, 12, 94, 81, 5, 2, -1, 100, 45, 12, 9, -1, 8, 2, -34};
       //int[] a2 = new int[] {10, 8, 5, 15, 2, 12, 94, 81, -1, -1, -34, 8, 2, 9, 12, 45, 100};
       int[] a1 = new int[] {10, 15, 8, 12, 94, 81, 5, 2, 10};
       int[] a2 = new int[] {10, 8, 5, 15, 2, 10, 12, 94, 81};
       Arrays.sort(a1);
       Arrays.sort(a2);
       System.out.println("The End");
    }
}
