package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

//https://www.algoexpert.io/questions/Underscorify%20Substring
public class MoveElementsToEnd {

    public static void main(String[] str){
    	List<Integer> list = new ArrayList<>();
    	list.add(2);
    	list.add(1);
    	list.add(2);
    	list.add(2);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(2);
    	moveElementToEnd(list, 2);
    }

  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int left = 0;
		int right = array.size()-1;
		while(left<right && left<array.size() && right>0){
			if(array.get(left)!=toMove && array.get(right)==toMove){
				left++;
				right--;
			}else if(array.get(left)==toMove && array.get(right)!=toMove){
				swap(array, left, right);
				left++;
				right--;
			}else if(array.get(left)==toMove && array.get(right)==toMove){
				right--;
			}else if(array.get(left)!=toMove && array.get(right)!=toMove){
				left++;
			}
		}//while
		return array;
  }

  	public static void swap(List<Integer> list, int idx1, int idx2){
		int temp  = list.get(idx1);
		list.set(idx1, list.get(idx2));
		list.set(idx2, temp);
	}

}
