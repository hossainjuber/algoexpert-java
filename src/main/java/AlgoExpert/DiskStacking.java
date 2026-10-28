package AlgoExpert;

import java.util.ArrayList;
import java.util.List;

public class DiskStacking {
    public static void main(String[] args){
        ArrayList<Integer[]> list = new ArrayList<>();
        /*list.add(new Integer[]{2,1,2});
        list.add(new Integer[]{3,2,3});
        list.add(new Integer[]{2,2,8});
        list.add(new Integer[]{2,3,4});
        list.add(new Integer[]{1,3,1});
        list.add(new Integer[]{4,4,5});*/
        list.add(new Integer[]{2,2,1});
        list.add(new Integer[]{2,1,2});
        list.add(new Integer[]{3,2,3});
        list.add(new Integer[]{2,3,4});
        list.add(new Integer[]{4,4,5});
        list.add(new Integer[]{2,2,8});

        List<Integer[]> result = diskStacking(list);
    }


    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Write your code here.
        List<Integer[]> subDiskArray = null;
        Integer[] diskStack = null;
        List<List<Integer[]>> diskList = new ArrayList<>();
		disks.sort((disk1, disk2)-> disk1[2].compareTo(disk2[2]));
		Integer[] heights = new Integer[disks.size()];
		Integer[] currentDisk;
		Integer[] otherDisk;
		for(int a=0; a<disks.size(); a++){
		    heights[a] = disks.get(a)[2];
        }

		int new_height = 0;
		int[] sequences = new int[disks.size()];
		for(int i=1; i<disks.size(); i++){
		    currentDisk = disks.get(i);
		    for(int j=0; j<i; j++){
		        otherDisk = disks.get(j);
		        if(otherDisk[0]<currentDisk[0] && otherDisk[1]<currentDisk[1] && otherDisk[2]<currentDisk[2] ){
		            //new_height = Math.max(currentDisk[2], currentDisk[2]+otherDisk[2]);
		            //heights[i]=new_height;
		            //sequences[i] =j;
		            if(heights[i]<currentDisk[2] + heights[j]){
		                heights[i] = currentDisk[2] + heights[j];
		                sequences[i] =j;
                    }
                }
            }//for
            //subDiskArray.add(currentDisk);
        }//for

        return new ArrayList<Integer[]>();
  }

  /*public static List<Integer[]> updateSubDiskArray(List<List<Integer[]>> diskList, ){

  }*/
}
