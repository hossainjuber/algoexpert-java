package AlgoExpert;

public class WaterfallStreams {

   public static void main(String[] args){
       /*double[][] array = {
               {0, 1, 0, 0, 1, 0, 0},
               {0, 0, 0, 0, 1, 0, 0},
               {0, 0, 1, 0, 1, 0, 0},
               {0, 0, 1, 0, 0, 0, 0},
               {0, 0, 1, 0, 0, 0, 0},
               {0, 0, 0, 0, 1, 0, 0},
               {0, 0, 0, 0, 0, 1, 0}
       };*/
       double[][] array = {
               {0, 0, 0, 0, 0, 0, 0},
               {1, 0, 0, 0, 0, 0, 0},
               {0, 0, 1, 1, 1, 0, 0},
               {0, 0, 0, 0, 0, 0, 0},
               {1, 1, 1, 0, 0, 1, 0},
               {0, 0, 0, 0, 0, 0, 1},
               {0, 0, 0, 0, 0, 0, 0}
       };
       print(array);
       waterfallStreams(array, 3);
   }

  public static double[] waterfallStreams(double[][] array, int source) {
       //initialize the array with source water location:
      array[0][source] = -1.0;
      int checkLeft = 0;
      int checkRight = 0;
      double water = -1;
      double[] row_above = null;
      double[] row_current = null;
      row_above = copyRow(array, 0);
      row_current = copyRow(array, 1);
      for(int i=1; i<array.length; i++) {
            row_above = row_current;
            row_current = copyRow(array, i);
           for (int j = 0; j < array[0].length; j++) {
                if(row_above[j]!=water){
                    continue;
                }else{
                    if(row_current[j]==1.0){
                        checkLeft = j;
                        checkRight = j;
                        water = water/2;
                        while(checkLeft>=0){
                            if(row_current[checkLeft]==0.0){
                                row_current[checkLeft] = water;
                                break;
                            }else{
                                checkLeft--;
                            }
                        }
                        while(checkRight<row_current.length){
                            if(row_current[checkRight]==0.0){
                                row_current[checkLeft] = water;
                                break;
                            }else {
                                checkRight++;
                            }
                        }
                    }else{
                        row_current[j] = water;
                    }
                }
           }//for
       }//for


    return new double[] {};
  }

  public static double[] copyRow(double[][] array, int row){
       double[] copy = new double[array.length];
       double temp = 0.00;
       for(int i=row; i<row+1; i++) {
           for (int j = 0; j < array[0].length; j++) {
                temp = array[i][j];
                copy[j] = temp;
           }

       }
       return copy;
  }

  public static void print(double[][] array){
       StringBuffer sb = new StringBuffer();
       for(int i=0; i<array.length; i++){
           sb = new StringBuffer();
           for(int j=0; j<array[0].length; j++){
               sb.append(" ");
               sb.append(String.valueOf(array[i][j]));
               sb.append(" ");
           }

           System.out.println(sb.toString());
       }
  }
}
