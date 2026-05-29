package hashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMap<K,V> {
    class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        Entry(K key, V value){
            this.key=key;
            this.value= value;
            this.next=null;
        }
    }
    int capacity =16;

    Entry<K,V> [] table1;

    public CustomHashMap() {
        table1= new Entry[capacity];
    }


}
