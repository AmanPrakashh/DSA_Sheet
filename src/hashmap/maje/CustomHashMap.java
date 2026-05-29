package hashmap.maje;

public class CustomHashMap<K, V> {
    // Default capacity of the hash table
    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;

    // Constructor
    public CustomHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    // Inner class representing a key-value pair
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Hash function to find bucket index
    private int getIndex(K key) {
        return key.hashCode() % INITIAL_CAPACITY;
    }

    // Put method: insert or update key-value
    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            Entry<K, V> prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    // Update existing key
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            // Add new entry at the end of chain
            prev.next = newEntry;
        }
    }

    // Get method: retrieve value by key
    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    // Remove method: delete key-value pair
    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
