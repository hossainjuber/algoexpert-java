package AlgoExpert;

import java.security.KeyStore;
import java.util.*;

public class ApartmentHunting4 {

   /*public static void main(String[] args){
       List<Map<String, Boolean>> block = new ArrayList<>();
       Map<String, Boolean> m1 = new HashMap<>();
       m1.put("gym", false);
       m1.put("school", true);
       m1.put("store", false);

       Map<String, Boolean> m2 = new HashMap<>();
       m2.put("gym", true);
       m2.put("school", false);
       m2.put("store", false);

       Map<String, Boolean> m3 = new HashMap<>();
       m3.put("gym", true);
       m3.put("school", true);
       m3.put("store", false);

       Map<String, Boolean> m4 = new HashMap<>();
       m4.put("gym", false);
       m4.put("school", true);
       m4.put("store", false);

       Map<String, Boolean> m5 = new HashMap<>();
       m5.put("gym", false);
       m5.put("school", true);
       m5.put("store", true);

       block.add(m1);
       block.add(m2);
       block.add(m3);
       block.add(m4);
       block.add(m5);

       String[] requirements = {"gym", "school", "store"};
       apartmentHunting(block, requirements);
   }*/

       public static void main(String[] args){
       /*List<Map<String, Boolean>> block = new ArrayList<>();
       Map<String, Boolean> m1 = new HashMap<>();
       m1.put("gym", true);
       m1.put("pool", false);
       m1.put("school", true);
       m1.put("store", false);

       Map<String, Boolean> m2 = new HashMap<>();
       m2.put("gym", false);
       m2.put("pool", false);
       m2.put("school", false);
       m2.put("store", false);

       Map<String, Boolean> m3 = new HashMap<>();
       m3.put("gym", false);
       m3.put("pool", false);
       m3.put("school", true);
       m3.put("store", false);

       Map<String, Boolean> m4 = new HashMap<>();
       m4.put("gym", false);
       m4.put("pool", false);
       m4.put("school", false);
       m4.put("store", false);

       Map<String, Boolean> m5 = new HashMap<>();
       m5.put("gym", false);
       m5.put("pool", false);
       m5.put("school", false);
       m5.put("store", true);

       Map<String, Boolean> m6 = new HashMap<>();
       m6.put("gym", true);
       m6.put("pool", false);
       m6.put("school", false);
       m6.put("store", false);

       Map<String, Boolean> m7 = new HashMap<>();
       m7.put("gym", false);
       m7.put("pool", false);
       m7.put("school", false);
       m7.put("store", false);

       Map<String, Boolean> m8 = new HashMap<>();
       m8.put("gym", false);
       m8.put("pool", false);
       m8.put("school", false);
       m8.put("store", false);

       Map<String, Boolean> m9 = new HashMap<>();
       m9.put("gym", false);
       m9.put("pool", false);
       m9.put("school", false);
       m9.put("store", false);

       Map<String, Boolean> m10 = new HashMap<>();
       m10.put("gym", false);
       m10.put("pool", false);
       m10.put("school", true);
       m10.put("store", false);

       Map<String, Boolean> m11 = new HashMap<>();
       m11.put("gym", false);
       m11.put("pool", true);
       m11.put("school", false);
       m11.put("store", false);

       block.add(m1);
       block.add(m2);
       block.add(m3);
       block.add(m4);
       block.add(m5);
       block.add(m6);
       block.add(m7);
       block.add(m8);
       block.add(m9);
       block.add(m10);
       block.add(m11);

       String[] requirements = {"gym", "pool", "school", "store"};*/
           List<Map<String, Boolean>> block = new ArrayList<>();
           Map<String, Boolean> m1 = new HashMap<>();
           m1.put("gym", false);
           m1.put("school", true);
           m1.put("store", false);

           Map<String, Boolean> m2 = new HashMap<>();
           m2.put("gym", true);
           m2.put("school", false);
           m2.put("store", false);

           Map<String, Boolean> m3 = new HashMap<>();
           m3.put("gym", true);
           m3.put("school", true);
           m3.put("store", false);

           Map<String, Boolean> m4 = new HashMap<>();
           m4.put("gym", false);
           m4.put("school", true);
           m4.put("store", false);

           Map<String, Boolean> m5 = new HashMap<>();
           m5.put("gym", false);
           m5.put("school", true);
           m5.put("store", true);

           block.add(m1);
           block.add(m2);
           block.add(m3);
           block.add(m4);
           block.add(m5);

           String[] requirements = {"gym", "school", "store"};
           apartmentHunting(block, requirements);
       apartmentHunting(block, requirements);
   }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[] blocks_score = new int[blocks.size()];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> result_map = new HashMap<>();
        for(int i=0; i<blocks.size(); i++){
            Map<String, Boolean> block = blocks.get(i);
            for(int j=0; j<reqs.length; j++){
                String req = reqs[j];
                if(block.containsKey(req) && !block.get(req)){
                    int minDistance = getNearestBlockWithReq(blocks, req, i);
                    blocks_score[i] = Math.max(blocks_score[i],minDistance);
                }
            }//for
            pq.add(blocks_score[i]);
            result_map.put(blocks_score[i], i);
        }//for

        return result_map.get( pq.peek());
   }

   public static int getNearestBlockWithReq(List<Map<String, Boolean>> blocks, String req, int currIdx){
           int minDistance = Integer.MAX_VALUE;
           for(int i=0; i<blocks.size(); i++){
               Map<String, Boolean> block = blocks.get(i);
               if(block.containsKey(req) && block.get(req)){
                   minDistance = Math.min(minDistance, Math.abs(currIdx-i));
               }
           }
           return minDistance;
   }



       public static int apartmentHunting2(List<Map<String, Boolean>> blocks, String[] reqs) {

       List<Map<String, Integer>> list_of_distances = new ArrayList<>();
       Map<String, Integer> num_map = null;
       Map<String, Boolean> bool_map = null;
       Map<String, Integer> preious_num_map = null;
       String key = "";
       String reqs_key = "";
       for(int i=0; i<blocks.size(); i++){
           bool_map = blocks.get(i);
           num_map = new HashMap<>();
           for(int j=0; j<reqs.length; j++){
               reqs_key = reqs[j];
               if(bool_map.containsKey(reqs_key)){
                   //filling out current number block from corresponding value in bool block
                   if(bool_map.get(reqs_key)){
                       num_map.put(reqs_key, 0);
                   }else{
                       num_map.put(reqs_key, -1);
                   }
                   //filling out previous block based on current blocks values
                   if(i>0){
                       preious_num_map = list_of_distances.get(i-1);
                       if(preious_num_map.get(reqs_key)==-1 && num_map.get(reqs_key)>=0){
                          preious_num_map.put(reqs_key, num_map.get(reqs_key)+1);
                       }
                       if(preious_num_map.get(reqs_key)>=0 && num_map.get(reqs_key)==-1){
                          num_map.put(reqs_key, preious_num_map.get(reqs_key)+1);
                       }
                   }
               }
           }//for
           list_of_distances.add(num_map);
       }
       //iterating backward to relay back any req value found in the last block to all previous blocks
       Map<String, Integer> forward_num_map = null;
       Map<String, Integer> current_num_map = null;
       int max1 = 0;
       int max2 = Integer.MIN_VALUE;
       int max3 = 0;
       int max1_idx = 0;
       int max2_idx = 0;
       Map<Integer, Integer> map_of_max_distance = new HashMap<>();
       int b=list_of_distances.size()-1;
       for(int k=list_of_distances.size()-2; k>=0; k--){
            for(int j=0; j<reqs.length; j++) {
                reqs_key = reqs[j];
                forward_num_map = list_of_distances.get(k + 1);
                current_num_map = list_of_distances.get(k);
                if (forward_num_map.get(reqs_key)>=0 && current_num_map.get(reqs_key) == -1) {
                    current_num_map.put(reqs_key, forward_num_map.get(reqs_key)+1);
                }

                max1 = forward_num_map.get(reqs_key);
                if(max1>max2){
                    max2 = max1;
                }
            }//for
            map_of_max_distance.put(k+1, max2>max1? max2: max1);
            max1 = 0;
            max2 = Integer.MIN_VALUE;
       }//for
       max1 = 0;
       max2 = Integer.MIN_VALUE;
       Map<String, Integer> first_block = list_of_distances.get(0);
       for(int j=0; j<reqs.length; j++) {
           max1 = first_block.get(reqs[j]);
           if(max1>max2){
                max2 = max1;
           }
       }
      map_of_max_distance.put(0, max2>max1? max2: max1);
       max1 = 0;
       max2 = Integer.MAX_VALUE;
       int idx1 =0;
       int idx2 = 0;
       for(Map.Entry<Integer, Integer> m : map_of_max_distance.entrySet()){
           max1 = m.getValue();
           idx1 = m.getKey();
           if(max1<max2){
                max2 = max1;
                idx2 = m.getKey();
           }
       }

    return max1<max2 ? idx1: idx2;
  }//apartmentHunting


}
