package AlgoExpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ShortestUniquePrefixes {

    public static void main(String[] str){
        String[] words = new String[]{
                "hello",
                "world",
                "he",
                "foo",
                "worldly",
                "food",
                "algoexpert",
        };
        shortestUniquePrefixes(words);
    }

    public static String[] shortestUniquePrefixes(String[] strings) {
        Trie trie = new Trie();
        String[] uniquePrefixes = new String[strings.length];
        for(String str: strings) trie.insert(str);
        for(int i=0; i<strings.length; i++) {
            trie.checkShortestUniquePrefix(strings[i], uniquePrefixes, i);
        }
        return uniquePrefixes;
    }

    static class Trie{
        HashMap<Character, Trie> children = new HashMap<>();
        Boolean isEndOfWord = false;
        int freq = 0;

        public void insert(String word){
            Trie currNode = this;
            for(char ch:word.toCharArray()){
                if(!currNode.children.containsKey(ch)) currNode.children.put(ch, new Trie());
                currNode = currNode.children.get(ch);
                currNode.freq++;
            }
            currNode.isEndOfWord = true;
        }

        public void checkShortestUniquePrefix(String str, String[] uniquePrefixes, int idx){
            Trie currNode = this;
            StringBuilder uniquePrefix = new StringBuilder();
            for(char ch:str.toCharArray()){
                if(!currNode.children.containsKey(ch)) break;
                currNode = currNode.children.get(ch);
                uniquePrefix.append(ch);
                if(currNode.freq == 1) break;
            }
            uniquePrefixes[idx] = uniquePrefix.toString();
        }
    }

}
