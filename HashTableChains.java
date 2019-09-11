public class HashTableChains<K, V> implements HashTable<K, V> {

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        private Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Node<K, V>[] data;
    private int maxSize, size;


    @SuppressWarnings("unchecked")
    public HashTableChains(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Node[maxSize];
        this.size = 0;
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        if (isFull() || contains(key)) {
            return false;
        }

        if (data[index] == null){
            data[index] = new Node<>(key, value);
        }
        else {
            Node<K, V> current = data[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(key, value);
        }
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        Node<K, V> current = data[index];
        while(current != null){
            if (current.getKey().equals(key))
                return current.getValue();
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        if (data[index] == null || !contains(key))
            return null;

        Node<K, V> current = data[index], previous;

        if(current.getKey().equals(key)){
            data[index] = current.next;
            size--;
            return current.getValue();
        }

        while(current.next != null){
            previous = current;
            current = current.next;
            if (current.getKey().equals(key)){
                previous.next = current.next;
                break;
            }
        }
        size--;
        return current.getValue();
    }

    @Override
    public void display() {
        System.out.println("-----------");
        Node<K, V> current;
        int i = 0;
        for (Node<K, V> d : data) {
            current = d;
            System.out.print(i++ + " ");
            if (current != null) {
                do {
                    System.out.print("{key: " + current.getKey() +
                            " <-> value: " + current.getValue() + "}");
                    if (current.next != null)
                        System.out.print(", ");
                    else
                        System.out.println();
                    current = current.next;
                }while (current != null);
            } else {
                System.out.println("empty");
            }
        }
        System.out.println("-----------");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }
}
