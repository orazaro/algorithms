public class UnorderedMaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;    // pq[i] = ith element on pq
    private int N;       // number of elements in pq

    public UnorderedMaxPQ(int capacity)
    { pq = (Key[]) new Comparable[capacity]; }

    public boolean isEmpty()
    { return N == 0; }

    public void insert(Key x)
    { pq[N++] = x; }

    public Key delMax()
    {
        int max = 0;
        for (int i = 1; i < N; i++)
            if (less(max, i)) max = i;
        exch(max, N-1);
        return pq[--N];
    }
   
   
   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/

    private boolean less(int v, int w)
    { return pq[v].compareTo(pq[w]) < 0; }

    private void exch(int i, int j)
    {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
