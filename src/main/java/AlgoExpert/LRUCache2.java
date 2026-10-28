package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache2 {
    public static void main(String[] str) {
        /*LRUCache2 lru = new LRUCache2(3);
        lru.insertKeyValuePair("b", 2);
        lru.insertKeyValuePair("a", 1);
        lru.insertKeyValuePair("c", 3);
        String key = lru.getMostRecentKey();
        LRUResult result = lru.getValueFromKey("a");
        key = lru.getMostRecentKey();
        lru.insertKeyValuePair("d", 4);
        result = lru.getValueFromKey("b");
        lru.insertKeyValuePair("a", 5);
        result = lru.getValueFromKey("a");*/

    }//main

    int maxSize;
    Map<String, Node> map;
    Node head;
    Node tail;
    LRUCache2(int size){
        maxSize = size>1 ? size : maxSize;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(maxSize);
    }
    class Node {
        String key;
        int value;
        Node prev;
        Node next;
        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public Integer getValueFromKey(String key){
        Node node = map.get(key);
        if(node!=null){
            removeNode(node);
            addNode(node);
            return node.value;
        }
        return null;
    }

    public void insertKeyValue(String key, int value){
        Node node = map.get(key);
        if(node!=null){
            node.value = value;
            removeNode(node);
            addNode(node);
        }else{
            //if map has map has reached its maxSize
            if(map.size()>=maxSize){
                map.remove(tail.prev.key);
            }
            Node newNode = new Node(key, value);
            addNode(newNode);

        }
    }

    public void addNode(Node node){
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


  }

