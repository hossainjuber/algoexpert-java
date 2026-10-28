package AlgoExpert;

import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.util.*;

//https://www.algoexpert.io/questions/Powerset
public class PhoneNumberMnemonics {
    public static void main(String[] str){
        Set<Integer> set = new HashSet<>();
        //String s1 = "testthis is a testtest to see if testestest it works";
        String phone_num = "";
        ArrayList<String> lits_of_all_numbers = phoneNumberMnemonics(phone_num);
        System.out.println("The End");
    }


    public static Map<String, String[]> getMneuMicsMap(){
        Set<Integer> set = new HashSet<>();
        Map<String, String[]> map = new HashMap<>();
        map.put("0", new String[]{"0"});
        map.put("1", new String[]{"1"});
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v", });
        map.put("9", new String[]{"w", "x", "y", "z"});
        return map;
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        Map<String, String[]> map = getMneuMicsMap();
        String[] currentMneumic = new String[phoneNumber.length()];
        Arrays.fill(currentMneumic, "0");
        ArrayList<String> result = new ArrayList<>();
        phoneNumberMneumonicHelper(map, 0, phoneNumber, currentMneumic, result);
        return result;
    }

    public static void phoneNumberMneumonicHelper(Map<String, String[]> map, int idx, String pn, String[] cn, ArrayList<String> m_list){
        if(idx==cn.length){
            String mneunomic = String.join("", cn);
            m_list.add(mneunomic);
        }else{
            String digit = String.valueOf(pn.charAt(idx));
            String[] letters = map.get(digit);
            for(String letter: letters){
                cn[idx] = letter;
                phoneNumberMneumonicHelper(map, idx+1, pn, cn, m_list);
            }
        }
    }
}
