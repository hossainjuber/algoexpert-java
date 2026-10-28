package AlgoExpert;

import java.util.ArrayList;
import java.util.List;


class MaximizeExpressions {
    public static void main(String[] args){
        int[] array = new int[]{3,6,1,-3,2,7};
        int result  = maximizeExpressions(array);
    }

    public static int maximizeExpressions(int[] array) {
        int[] a = new int[array.length];
        a[0] = array[0];
        for(int i=1; i<a.length; i++){
            a[i] = Math.max(a[i-1], array[i]);
        }

        int[] a_minus_b = new int[array.length];
        a_minus_b[0] = Integer.MIN_VALUE;
        a_minus_b[1] = a[0] - array[1];
        for(int i=2; i<a_minus_b.length; i++){
            a_minus_b[i] = Math.max(a[i-1], a[i-1] - array[i]);
        }

        int[] ab_plus_c = new int[array.length];
        ab_plus_c[0] = Integer.MIN_VALUE;
        ab_plus_c[1] = Integer.MIN_VALUE;
        for(int i=2; i<ab_plus_c.length; i++){
            ab_plus_c[i] = Math.max(a_minus_b[i-1], a_minus_b[i-1] + array[i]);
        }

        int[] abc_minus_d = new int[array.length];
        abc_minus_d[0] = Integer.MIN_VALUE;
        abc_minus_d[1] = Integer.MIN_VALUE;
        abc_minus_d[2] = Integer.MIN_VALUE;
        for(int i=3; i<abc_minus_d.length; i++){
            abc_minus_d[i] = Math.max(ab_plus_c[i-1], ab_plus_c[i-1] - array[i]);
        }

        return abc_minus_d[abc_minus_d.length-1];
    }
}




