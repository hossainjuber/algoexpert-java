package AlgoExpert;

import java.util.*;

//https://www.algoexpert.io/questions/Multi%20String%20Search
public class MultiStringSearch2 {

    public static void main(String[] str){
        String bigString = "this is a biggger string";
        String[] samllStrings = {"this", "yo", "is", "a", "big", "string"};
        multiStringSearch(bigString, samllStrings);
    }

      public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        List<Boolean> result = new ArrayList<>(smallStrings.length);
		for(int m=0; m<smallStrings.length; m++){
			result.add(m,false);
		}

		Map<String, Integer> smallStrings_map = new HashMap<>();
		for(int j=0; j<smallStrings.length; j++){
			smallStrings_map.put(smallStrings[j], j);
		}

		String[] array = bigString.split(" ");
		for(int k=0; k<array.length; k++){
			if(smallStrings_map.containsKey(array[k])){
				result.set(smallStrings_map.get(array[k]), true);
			}
		}
		return result;
  }
}
