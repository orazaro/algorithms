public class Heap
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int N0 = N;

        /* from unordered array to heap */
        for (int k = N/2; k >= 1; k--)
            sink(a, k, N);
        
        /* remove sequentally elements from heap top */
        while (N > 1)
        {
            exch(a, 1, N);
            sink(a, 1, --N);
        }
    }
    
    private static void sink(Comparable[] a, int k, int N)
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(a, j, j+1)) j++;  // children of node k are 2k and 2k+1
                                                // select max of them
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/

    private static boolean less(Comparable[] a, int i, int j)
    {
        Comparable v = a[i-1], w  = a[j-1];
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable swap = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = swap;
    }
}
