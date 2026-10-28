package AlgoExpert;

import java.util.HashSet;
import java.util.Set;

public class NumbersInPi {
    public static void main(String[] str){
        //String string = "1921680";
        String number = "3141592";
        String[] array = {"3141","5","31","2","4159","9","42"};
        int num = numbersInPi(number, array);
        System.out.println("The End");
    }
    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> set = getSet(numbers);
        String num="";
        int counter = 0;
        for(int i=0; i<numbers.length; i++){
            num = numbers[i];
            String[] array = pi.split(num);

            if(array.length>1){
                counter++;
                for(int j=0; j<array.length; j++){
                    if(set.contains(array[j])){
                        counter++;
                    }
                }//for
            }
        }//for
        return counter;
    }

    public static Set<String> getSet(String[] array){
        Set<String> set = new HashSet<>();
        for(int i=0; i<array.length; i++){
            set.add(array[i]);
        }
        return set;
    }

}
