package AlgoExpert;

public class ThreeNumberSort {

    public static void main(String[] args){
        /*int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};
        int[] result = threeNumberSort(array, order);*/
        int x = 1 % 5;
        System.out.println(x);
       System.out.println("THE END");
   }

  public static int[] threeNumberSort(int[] array, int[] order) {
    int idx1=0;
    for(int i=0; i<order.length; i++){
			for(int j=0; j<array.length; j++){
				if(order[i]==array[j]){
						array = swap(array, j, idx1);
						idx1++;
						break;
				}
			}
		}
		return array;
  }

	public static int[] swap(int[] array, int idx1, int idx2){
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
		return array;
	}
}
