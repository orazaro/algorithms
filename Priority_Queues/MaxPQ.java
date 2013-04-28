public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;    // pq[i] = ith element on pq
    private int N;       // number of elements in pq

    public MaxPQ(int capacity)
    { pq = (Key[]) new Comparable[capacity+1]; }

    public boolean isEmpty()
    { return N == 0; }

    public void insert(Key x)
    {
        pq[++N] = x;
        swim(N);
    }

    public Key delMax()
    {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null; // preventing loitering
        return max;
    }

    private void swim(int k)
    {
        while (k > 1 && less(k/2, k))
        {
            exch(k, k/2);
            k = k/2;        // parent of node k is at k/2
        }
    }
   
    private void sink(int k)
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++; // children of node k are 2k and 2k+1
                                            // select max of them
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
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
