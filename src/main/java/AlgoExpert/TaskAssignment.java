package AlgoExpert;

import java.util.*;

public class TaskAssignment {

   public static void main(String[] args){
       ArrayList<Integer> tasks = new ArrayList<>();
       tasks.add(1);
        tasks.add(3);
         tasks.add(5);
          tasks.add(3);
           tasks.add(1);
            tasks.add(4);
       int workers = 3;
       ArrayList<ArrayList<Integer>> task_indexes  = taskAssignment(workers, tasks);
       System.out.println("The End");
   }

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pair_list = new ArrayList<>();
        ArrayList<Integer> list = null;
        int i = 0;
        Map<Integer, ArrayList<Integer>> task_map = getStringToMap(tasks);
        int head;
        int tail;
        while(i<k){
            Collections.sort(tasks);
            head = tasks.get(0);
            tasks.remove(0);
            tail = tasks.get(tasks.size()-1);
            tasks.remove(tasks.size()-1);

            list = new ArrayList<>();
            list.add(head);
            list.add(tail);
            pair_list.add(list);

            i++;
        }//while
        result = getPairOfTasksFromMap(task_map, pair_list);
        return result;
    }

    public static ArrayList<ArrayList<Integer>> getPairOfTasksFromMap(Map<Integer, ArrayList<Integer>> map, ArrayList<ArrayList<Integer>> ll){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> idx_list = new ArrayList<>();
        ArrayList<Integer> idx_list1 = null;
        ArrayList<Integer> idx_list2 = null;
        ArrayList<Integer> temp_list1 = null;
        ArrayList<Integer> temp_list2 = null;
        for(ArrayList<Integer> list : ll){
            if(list.size()==2){
                int k1 = list.get(0);
                int k2 = list.get(1);
                if(map.containsKey(k1) && map.containsKey(k2)){
                    temp_list1 = map.get(k1);
                    temp_list2 = map.get(k2);
                    if(temp_list1!=null && temp_list1.size()>0 && temp_list2!=null && temp_list2.size()>0){
                        int a = 0;
                        idx_list = new ArrayList<>();
                        idx_list1 = new ArrayList<>();
                        idx_list2 = new ArrayList<>();
                        //while(temp_list1.get(a)!=-1){
                        while(a<temp_list1.size()){
                            if(temp_list1.get(a)==-1) {
                                a++;
                                continue;
                            }
                            idx_list.add(temp_list1.get(a));
                            idx_list1 = map.get(k1);
                            idx_list1.remove(a);
                            idx_list1.add(a, -1);
                            map.put(k1, idx_list1);
                            break;
                        }//while
                        a = 0;
                        //while(temp_list2.get(a)!=-1){
                        while(a<temp_list2.size()){
                            if(temp_list2.get(a)==-1) {
                                a++;
                                continue;
                            }
                            idx_list.add(temp_list2.get(a));
                            idx_list2 = map.get(k2);
                            idx_list2.remove(a);
                            idx_list2.add(a, -1);
                            map.put(k2, idx_list2);
                            a++;
                            break;
                        }//while
                        result.add(idx_list);
                    }
                }else{
                    continue;
                }

            }else{
                continue;
            }
        }//
        return result;
    }


    public static Map<Integer, ArrayList<Integer>> getStringToMap(ArrayList<Integer> tasks){
        Map<Integer, ArrayList<Integer>> cache = new HashMap<>();
        Integer key = null;
        ArrayList<Integer> value_list = null;
        for(int i=0; i<tasks.size(); i++){
            key = tasks.get(i);
            if(cache.containsKey(key)){
                value_list = cache.get(key);
                value_list.add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                cache.put(key, list);
            }
        }//for
        return cache;
    }
}
