package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoggleBoard {

    public static void main(String[] args){
        char[][] bb = {
            {'t', 'h', 'i', 's', 'i', 's', 'a'},
            {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
            {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
            {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
            {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
            {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
            {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
            {'N', 'O', 'T', 'R', 'E', '-', 'P'},
            {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
        };
        String[] words ={"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};

       List<String> result = boggleBoard(bb, words);
    }
    
    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        Map<Character, List<List<Integer>>> map = getMapOfBB(board);
        return new ArrayList<String>();
    }

    public void wordExists(int x, int y, String word, char[][] bb){
        //right

        //up

        //down
    }

    public static Map<Character, List<List<Integer>>> getMapOfBB(char[][] bb){
        Map<Character, List<List<Integer>>> map = new HashMap<>();
        Character key = ' ';
        List<List<Integer>> ll = null;
        for(int i=0; i<bb.length; i++){
            for(int j=0; j<bb[i].length; j++){
                key = bb[i][j];
                if(map.containsKey(key)){
                    ll = map.get(key);
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ll.add(list);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ll = new ArrayList<>();
                    ll.add(list);
                    map.put(key, ll);
                }
            }
        }
        return map;
    }


}
