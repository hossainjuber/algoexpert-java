package AlgoExpert;

public class WaterArea {

   public static void main(String[] args){
       int[] heights = new int[]{0,8,0,0,5,0,0,10,0,0,1,1,0,3};
       waterArea(heights);
   }

    public static int waterArea(int[] heights) {
       if(heights.length==0) return 0;
        // Write your code here.
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        int left_max = heights[0];
        for(int i=1; i<heights.length; i++) {
            left_max = Math.max(left_max, heights[i-1]);
            leftMax[i] = left_max;
        }
        int right_max = heights[heights.length-1];
        for(int j=heights.length-2; j>=0; j--){
            right_max = Math.max(right_max, heights[j+1]);
            rightMax[j] = right_max;
        }

        int minPillerHeight = 0;
        int water = 0;
        int totalWater = 0;
        for(int k=0; k<leftMax.length; k++){
            minPillerHeight = Math.min(leftMax[k], rightMax[k]);
            water = Math.abs(minPillerHeight - heights[k]);
            if(heights[k] < minPillerHeight){
                water = minPillerHeight - heights[k];
            }else{
                water = 0;
            }
            totalWater += water;
        }

        return totalWater;
    }


}
