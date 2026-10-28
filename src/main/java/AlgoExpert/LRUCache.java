package AlgoExpert;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] str) {


    }

    int maxSize;
    Map<String, Node> map;
    Node head;
    Node tail;

    LRUCache(int size){
        maxSize = size>1?size:maxSize;
        map = new HashMap<>(maxSize);
        head.next = tail;
        tail.prev = head;
    }

    class Node{
        String key;
        int value;
        Node prev;
        Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }//Node

    public void insertKeyValue(String key, int value){
        Node node = map.get(key);
        if(node!=null){
            node.value = value;
            remove(node);
            add(node);
        }else{
            Node newNode = new Node(key, value);
            if(map.size()==maxSize){
                map.remove(tail.prev.key);
            }
            map.put(key, newNode);
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    public Node getValueFromKey(String key){
        Node node = map.get(key);
        if(node!=null){
            remove(node);
            add(node);
            return node;
        }
        return null;
    }

    public String getMostRecentKey(){
        return head.next.key;
    }

    public void add(Node node){
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}

