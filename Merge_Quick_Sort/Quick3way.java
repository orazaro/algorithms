public class Quick3way
{
    // Dijkstra 3-way partitioning
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0)   exch(a, lt++, i++);
            else if (cmp > 0)   exch(a, i, gt--);
            else                i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/

    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

   /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
}
