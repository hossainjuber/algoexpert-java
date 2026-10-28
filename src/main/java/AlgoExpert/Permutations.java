package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class Permutations {

    public static void main(String[] str){
        //String s1 = "testthis is a testtest to see if testestest it works";
        String s1 = "testtest is a testtest to see if testestest it works";
        String s2 = "test";
        //_test_this is a _testtest_ to see if _testestest_ it works_
        //underscorifySubstring(s1, s2);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> listOfLists = getPermutations(list);
    }

  public static List<List<Integer>> getPermutations(List<Integer> array) {
    // Write your code here.
		List<List<Integer>> permutations = new ArrayList<>();
		generatePermutations(array, new ArrayList<Integer>(), permutations);
    return permutations;
  }

	public static void generatePermutations(
		List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations){
		if(array.size()==0 && currentPermutation.size() > 0){
			permutations.add(currentPermutation);
		}else{
			for(int i=0; i<array.size(); i++){
				List<Integer> newArray = new ArrayList<>(array);
				newArray.remove(i);
				List<Integer> newPermutation = new ArrayList<>(currentPermutation);
				newPermutation.add(array.get(i));
				//System.out.println("*********************");
				//print("newArray: " , newArray);
				//print("newPermutation: " , newPermutation);
				generatePermutations(newArray, newPermutation, permutations);
			}//for
		}

	}//generatePermutations

	public static void print(String str, List<Integer> list){
    	StringBuffer sb = new StringBuffer();
    	for(Integer num: list) {
			sb.append(num);
			sb.append(",");
		}

    	System.out.println(str +":"+ sb.toString());

	}


}
