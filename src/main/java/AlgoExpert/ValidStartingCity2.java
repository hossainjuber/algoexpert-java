package AlgoExpert;

public class ValidStartingCity2 {

   public static void main(String[] args){
       /*int[] distances = {5, 25, 15, 10, 15};
       int[] fuel = {1,2,1,0,3};
       int mpg = 10;*/

       /*int[] distances = {30, 25, 5, 100, 40};
       int[] fuel = {3, 2, 1, 0, 4};
       int mpg = 20;*/

       /*int[] distances = {10, 20, 10, 15, 5, 15, 25};
       int[] fuel = {0, 2, 1, 0, 0, 1, 1};
       int mpg = 20;*/

       /*int[] distances = {5, 2, 3};
       int[] fuel = {1,0,1};
       int mpg = 5;*/

       /*int[] distances = {1, 3, 10, 6, 7, 7, 2, 4};
       int[] fuel = {1, 1, 1, 1, 1, 1, 1, 1};
       int mpg = 5;*/

       /*int[] distances = {4, 6};
       int[] fuel = {1, 9};
       int mpg = 1;*/

       /*int[] distances = {30, 40, 10, 10, 17, 13, 50, 30, 10, 40};
       int[] fuel = {1, 2, 0, 1, 1, 0, 3, 1, 0, 1};
       int mpg = 25;*/

       /*int[] distances = {30, 40, 10, 10, 17, 13, 50, 30, 10, 40};
       int[] fuel = {10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
       int mpg = 25;*/

       /*int[] distances = {10, 10, 10, 10};
       int[] fuel = {1, 2, 3, 4};
       int mpg = 4;*/

       int[] distances = {30, 40, 10, 10, 17, 13, 50, 30, 10, 40};
       int[] fuel = {1, 2, 0, 1, 1, 0, 3, 1, 0, 1};
       int mpg = 25;

       int starting_city = validStartingCity(distances, fuel, mpg);
   }

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int i=0;
        int nextCity = i+1;
        for(int k =0; k <distances.length; k++) {
            while (nextCity != k) {
                nextCity = (nextCity) % distances.length;
                if (nextCity == k) break;
                nextCity++;

                System.out.println(nextCity);
            }//while

        }
                    return -1;
    }

  //public static double calculateFuelLeft(double startingFuel, int distance_to_next_city, int mpg){

  //}


}
