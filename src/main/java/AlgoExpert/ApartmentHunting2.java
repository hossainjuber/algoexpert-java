package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class ApartmentHunting2 {

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
       System.out.println(apartmentHunting(block, requirements));
   }

    public static int apartmentHunting(
            List<Map<String, Boolean>> blocks, String[] reqs
    ) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> pq_map = new HashMap<>();
        Set<String> reqSet = new HashSet<>();
        for(int i=0; i<reqs.length; i++){
            reqSet.add(reqs[i]);
        }
        int min=0;
        // iterate over the blocks
        String req = "";
        int maxDistance = Integer.MIN_VALUE;
        int[] distances = new int[blocks.size()];
        Arrays.fill(distances, 0);
        for(int i=0; i<blocks.size(); i++){
            Map<String, Boolean> block = blocks.get(i);
            for(Map.Entry<String, Boolean> entry : block.entrySet()){
                String key = entry.getKey();
                Boolean value = entry.getValue();
                if(value){
                    distances[i] = Math.max(distances[i], 0);
                }else{
                    //search left:
                    int idx = i-1;
                    int count = 0;
                    while(idx>=0){
                        Map<String, Boolean> map = blocks.get(idx);
                        if(map.containsKey(key) && map.get(key)){
                            distances[i] = count;
                            break;
                        }
                        count++;
                        idx = idx-1;
                    }//while
                    count = 0;
                    idx = i+1;
                    while(idx<blocks.size()){
                        Map<String, Boolean> map = blocks.get(idx);
                        if(map.containsKey(key) && map.get(key)){
                            distances[i] = Math.max(distances[i], count);
                            break;
                        }
                        count++;
                        idx = idx+1;
                    }//while
                }
            }

            //min = Math.min(distances[i], min);
            pq.add(distances[i]);
            pq_map.put(distances[i], i);
        }//outer most for loop
        //print(distances);
        return pq_map.get(pq.poll());
    }

   public static int apartmentHunting2(List<Map<String, Boolean>> blocks, String[] reqs) {
        List<Map<String, Integer>> blocks2 = new ArrayList<>();
        Map<String, Boolean> block_map = new HashMap<>();
        Map<String, Integer> block2_map = new HashMap<>();
        for(int i=0; i < blocks.size(); i++){
            block_map = blocks.get(i);
            block2_map = new HashMap<>();
            for(Map.Entry<String, Boolean> block_entry : block_map.entrySet()){
                if(block_entry.getValue()){
                    block2_map.put(block_entry.getKey(), 0);
                }else{
                    block2_map.put(block_entry.getKey(), Integer.MAX_VALUE);
                }

                if(i>0){
                    Map<String, Integer> prev_blocks_map =  blocks2.get(i-1);
                    if(prev_blocks_map.get(block_entry.getKey()) >  block2_map.get(block_entry.getKey())){
                        prev_blocks_map.put(block_entry.getKey(), block2_map.get(block_entry.getKey())+1);
                    }
                    if(prev_blocks_map.get(block_entry.getKey()) <  block2_map.get(block_entry.getKey())){
                        block2_map.put(block_entry.getKey(), prev_blocks_map.get(block_entry.getKey())+1);
                    }
                }
            }
            blocks2.add(block2_map);
        }
        Map<String, Integer> current_block2_map = new HashMap<>();
        Map<String, Integer> forward_block2_map = new HashMap<>();
        int current = 0;
        int forward = 0;
        for(int i=blocks2.size()-2; i>=0; i--){
            current_block2_map = blocks2.get(i);
            forward_block2_map = blocks2.get(i+1);
            for(Map.Entry<String, Integer> current_block2_map_entry : current_block2_map.entrySet()){
                current = current_block2_map.get(current_block2_map_entry.getKey());
                forward = forward_block2_map.get(current_block2_map_entry.getKey());
                if(current<forward && (forward-current)>1) {
                    current_block2_map.put(current_block2_map_entry.getKey(), current_block2_map_entry.getValue() + 1);
                }

                if(current>forward && (current-forward)>1) {
                    current_block2_map.put(current_block2_map_entry.getKey(), forward_block2_map.get(current_block2_map_entry.getKey())+ 1);
                }
            }
        }
        int min_distance = Integer.MAX_VALUE;
        int min_idx = -1;
        for(int i=0; i < blocks2.size(); i++) {

            for (Map.Entry<String, Integer> block_entry : block2_map.entrySet()) {
                if(min_distance > block_entry.getValue()){
                    min_distance = block_entry.getValue();
                    min_idx = i;
                }
            }
        }
        return min_idx;
  }

}

