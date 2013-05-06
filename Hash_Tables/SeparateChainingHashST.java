
public class SeparateChainingHashST<Key, Value>
{
    private int M = 97;                 // number of chains
    private Node[] st = new Node[M];    // array of chains

    private static class Node
    {
        private Object key;
        private Object val;
        private Node next;
        private Node(Object _key, Object _val, Node _next)
        {
            key = _key; val = _val;
            next = _next;
        }
        private void print()
        {
            StdOut.printf("node: %s %d %x\n", key,val,next);
        }
    }

    private int hash(Key key)
    { return (key.hashCode() & 0x7fffffff) % M; }

    public Value get(Key key) 
    {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next)
            if (key.equals(x.key)) return (Value) x.val;
        return null;
    }

    public boolean contains(Key key)
    { return get(key) != null; }

    public void put(Key key, Value val)
    {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next)
            if (key.equals(x.key)) {x.val = val; return;}
        st[i] = new Node(key, val, st[i]);
    }

}
