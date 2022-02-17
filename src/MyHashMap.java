public class MyHashMap<k,v> implements MyMapInterface
{
    //start size value
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    //load coefficient
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    //create Node
    Node[] table = new Node[DEFAULT_INITIAL_CAPACITY];

    private int size = 0;

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
        return size;
    }

    @Override
    public boolean isEmty() {
        return size ==0;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    //get HashCode and place where store
    public int hash(Object key)
    {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    //get past positions
    public int indexFor(int hashValue, int length)
    {
        return hashValue % length;
    }



    @Override
    public Object put(Object key, Object value)
    {
        //calculate hash
        int hashValue = hash(key);
        //place where been
        int i = indexFor(hashValue,table.length);
        // if i have data and same key - > overwrite!
        for (Node node = table[i]; node != null; node = node.next)
        {
            if (node.key.equals(key) && hashValue == node.hash) return node.value;
        }
        return null;
    }


}