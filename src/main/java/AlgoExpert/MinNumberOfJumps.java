package AlgoExpert;

public class MinNumberOfJumps {

    public static void main(String[] args){
       int[] array = {3,4,2,1,2,3,7,1,1,1,3};
       //int[] array = {3,1};
       //int[] array = {1,1};
        //int[] array = {1,1,1};
       minNumberOfJumps(array);
   }

   public static int minNumberOfJumps(int[] array) {
        int jump_count = 0;
        if(array.length==1) return jump_count;
        for(int i=0; i<array.length;){
            i = getLargetstJump(i, array);
            jump_count++;
            if(i==array.length-1) break;
        }//for
       return jump_count;
  }

  public static int getLargetstJump(int idx, int[] array){
        int current_jump = array[idx];
        current_jump = current_jump > (array.length-1-idx-1) ? array.length-1 : current_jump;
        if(current_jump==array.length-1){
            return array.length-1;
        }
        System.out.println(idx);
        int mx1 = 0;
        int mx2 = Integer.MIN_VALUE;
        int idx_i=0;
        for(int i=idx+1; i<=current_jump+idx; i++){
            System.out.print(array[i]);
            mx1 = i+array[i];
            if(mx1>mx2){
                mx2 = mx1;
                idx_i = i;
            }
        }//for
        return idx_i;
  }


}
