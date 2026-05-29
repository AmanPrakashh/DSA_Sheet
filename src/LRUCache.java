import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);

        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3, 3);
        lruCache.put(4,4);
        System.out.println(get(4));
        lruCache.put(4,10);
        System.out.println(get(4));
        lruCache.put(5,15);
        System.out.println(get(5));


        System.out.println( get(1));
    }
  static   class Node {
        int key;
        Node prev;
        Node next;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    static Map<Integer, Node> map;

    static Node head;
    Node tail;

    //cons
    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next=tail;
        tail.prev= head;
    }

    static int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }

   static  void removeNode(Node node){
        Node prev= node.prev;
        Node next = node.next;
        prev.next= next;
        next.prev = prev;
    }
    static void addNode(Node node){
        node.next= head.next;
        node.prev = head;
        head.next.prev = node;
        head.next= node;
    }

    void put(int key, int val){

    // condition when element is already present
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val= val;
            removeNode(node);
            addNode(node);
        }

        else{
            Node node = new Node(key, val);
            map.put(key, node);
            addNode(node);
            if(map.size()>capacity){
                Node removedTail= removeTail();
                map.remove(removedTail.key);
            }
        }
    }

    private Node removeTail() {
        Node prevTail= tail.prev;
        removeNode(prevTail);
        return tail;
    }
    }


