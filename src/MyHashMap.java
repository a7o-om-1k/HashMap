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
        return size == 0;
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

    //copy array
    public void Transfer (Node [] src, Node [] newTable)
    {
        int newCapacity = newTable.length;
        for (int j = 0; j <src.length; j ++) {
            Node e = src [j];
            if (e != null) {
                src [j] = null; //
                do {
                    Node next = e.next;
                    int i = indexFor (e.hash, newCapacity);
                    e.next = newTable [i];
                    newTable [i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }


    //add element to Entry, where hash - value hash
    public void addEntry(Object key, Object value, int hashValue, int i)
    {
        // if length arrray is more then previosly agreed, expanding capacity
        if (++size >= table.length * DEFAULT_LOAD_FACTOR)
        {
            Node[] newTable = new Node[table.length << 1];
            //copy array
            Transfer(table, newTable);
            table = newTable;
        }
        //get data to i
        Node eNode = table[i];
        //add Node, and indicate Node near to prevoius
        table[i] = new Node(hashValue, key, value, eNode);
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
            Object k;
            if (node.hash == hashValue && ((k = node.key)==key||key.equals(k)))
            {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        addEntry(key, value, hashValue, i);
        return null;
    }

    @Override
    public Object get(Object key) {
        //get value by hashCode
        int hashValue = hash(key);
        //by hash and size Node get index put position
        int i = indexFor(hashValue, table.length);
        for (Node node = table[i]; node != null; node = node.next)
        {
            if (node.key.equals(key) && hashValue == node.hash) return node.value;
        }
        return null;
    }

}