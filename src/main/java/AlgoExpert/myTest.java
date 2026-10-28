package AlgoExpert;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class myTest {
    /*
    * 1. we have a string of characters, ie, abcdezabcf
    * 2. we need to count the frequency of each char and store the count as value
    * 3. print out the DS, ordered asc by value
    * */

    public static void main(String[] args){
        String str = "aaabbzzzkkkkkkkkk";
        freqCounter(str);
    }

    public static void freqCounter(String str){
        //TODO: defensive coding

        PriorityQueue<Node> pq_max = new PriorityQueue<>((a,b)-> {
            return Integer.compare(b.value, a.value);
        });

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            String key = String.valueOf(str.charAt(i));
            Integer value;
            if(map.containsKey(key)){
                value = map.get(key);
                value = value+1;
                //TODO: probably not needed:
                map.put(key, value);
            }else{
                map.put(key, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq_max.add(new Node(entry.getValue(), entry.getKey()));
        }

        int counter = map.size();
        while(counter>0){
            Node node = pq_max.poll();
            System.out.println(node.property +": " +node.value);
            counter--;
        }
    }

    public static class Node{
        Integer value;
        String property;
        Node(Integer value, String property){
            this.value = value;
            this.property = property;
        }
    }
}
