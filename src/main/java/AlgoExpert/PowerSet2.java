package AlgoExpert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Powerset
public class PowerSet2 {
    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> ll =  powerset(list);
        for(ArrayList<Integer> l : ll){
            System.out.println(l);
        }
        System.out.println("The End");
    }

    public static ArrayList<ArrayList<Integer>> powerset(List<Integer> array) {
        ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
        ArrayList<ArrayList<Integer>> copy_ll = new ArrayList<>();
        ArrayList<Integer> copy_l = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        ll.add(l);

        if(array.size()==0){
            return ll;
		}

		for(Integer num : array){
			/* 1. create copy of all the elements in ll
			 * 2. add the current num in each element that was copied
			 * 3. add the copied set in step 1 and 2 in the master list
			 */
            copy_ll = new ArrayList<>(ll);
            for(List<Integer> list : copy_ll){
                //copy list
                //add original list
                //add num to copy list
                //add both original and copy list to temp_list
                l = new ArrayList<>(list);
                l.add(num);
                ll.add(l);
            }//for

		}//for
		return ll;
  }

}
