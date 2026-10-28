package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting3 {

   public static void main(String[] args){
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

   }

   public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

       List<Map<String, Integer>> target_blocks = new ArrayList<>();
       Map<String, Integer> target_map = null;
       Map<String, Boolean> source_block_map = null;
       for(int i=0; i<blocks.size(); i++){
           source_block_map = blocks.get(i);
           target_map = new HashMap<>();
           for(int j=0; j<reqs.length-1; j++){
               //if current req == current block map
               if(source_block_map.get(reqs[j])){
                   target_map.put(reqs[j], 0);
               }else{
                   //lets rely on previous block
                   if(i>0 && blocks.get(i-1).get(reqs[j])!=null && blocks.get(i-1).get(reqs[j])==true){
                        target_map.put(reqs[j], target_blocks.get(i-1).get(reqs[j])+1);
                   }
               }
           }
           target_blocks.add(target_map);
       }
       int smallest_distance_index1 = -1;
       int smallest_distance_index2 = -1;
       for(int i=target_blocks.size()-2; i>=0; i--){
           target_map = target_blocks.get(i);
           for(int j=0; j<reqs.length; j++){
               //if current req == current block map
               //smallest_distance_index1 = target_blocks.get()
               if(target_map.get(reqs[j])==null) {
                   target_map.put(reqs[j], target_blocks.get(i+1).get(reqs[j])+1);
               }else if(target_map.get(reqs[j])==0){
                   continue;
               }else {
                   if(target_map.get(reqs[j]) > target_blocks.get(i+1).get(reqs[j])){
                       target_map.put(reqs[j], target_blocks.get(i+1).get(reqs[j])+1);
                   }
               }
           }//for
       }//for
       return 0;
  }
}
