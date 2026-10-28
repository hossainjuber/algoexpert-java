package AlgoExpert;

import java.util.*;

public class BestSeat {

   public static void main(String[] args){
       // "seats": [1, 0, 1, 0, 0, 0, 1]
	   //int[] seats = new int[]{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1};
	   //int[] seats = new int[]{1, 1, 1};
       //int[] seats = new int[]{1, 0, 1, 0, 0, 0 , 0, 0, 1};
       //int[] seats = new int[]{1,1,1};
       //int[] seats = new int[]{1,0,0,1,0,0,1};
       int[] seats = new int[]{1,0,1,0,0,0,1};
	   bestSeat(seats);
   }

public static int bestSeat(int[] seats) {
    if(seats==null ) return 0;
    if(seats.length==1) return -1;
    int left = 0;
    int right = 1;
    int currMax = 0;
    int max = Integer.MIN_VALUE;
    while(left<right && right<seats.length){
        if(seats[right]==0){
            right++;
        }else if(seats[right]==1){
            currMax = ((right-left)/2);
            if(currMax>max){
                max = currMax;
            }
            left=right;
            right = right+1;
        }
    }//while
    return max;
}

    public static int bestSeat2(int[] seats) {
        // Write your code here.

        if(seats==null || (seats.length==1 && seats[0]==1)) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        int center = 0;
        int span = 0;
        for(int i=1; i<seats.length; i++){
            int seat = seats[i];
            if(seat==0){
                getCenter(i, seats, map, pq);
                //int span = getSpan(i);

            }//if
        }//for
        if(map.size()==0) return -1;
        return map.get(pq.peek());
    }

    public static void getCenter(int idx, int[] seats, Map<Integer, Integer> map, PriorityQueue<Integer> pq){
        int currIdx = idx;
        currIdx++;
        while(currIdx<seats.length && seats[currIdx]==0){
            currIdx++;
        }
        int span = currIdx-idx;
        int center = 0;
        if(span==0 ||span==1||span==2) {
            center = idx;
        }else if(span>2){
            center = idx+(span/2);
            if(span%2==0) center--;
        }
        if(!map.containsKey(span)) {
            map.put(span, center);
            pq.add(span);
        }
    }

   //************************************
	public static int bestSeat3(int[] seats) {
		// Write your code here.
		int first=0;
		int last=1;
		int result=0;
		int best1=0;
		int best2=0;
		if(seats.length<3) return -1;
		while(last<seats.length){
			last = getLastIndex(seats, last);
			best1 = last-first;
			if(best1>best2){
				best2 = best1;
				result = (last+first)/2;
			}
			first=last;
			last++;
		}//while
		return result==0?-1:result;
	}
	private static int getLastIndex(int[] array, int idx){
		int index = idx;
		while(index<array.length){
			if(array[index]==1){
				return index;
			}

			index++;
		}
		return -1;
	}
}
