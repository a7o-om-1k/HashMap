public class MyHashMap<k,v> implements MyMapInterface
{
    //start size value
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    //load coefficient
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    //create Node
    Node[] table = new Node[DEFAULT_INITIAL_CAPACITY];

    static class Node implements MyMapInterface.Entry
    {
        int hash;   //hash
        Object key;
        Object value;

        //next Node
        Node next;
        Node(int hash, Object key, Object value,Node next)
        {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmty() {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }
}