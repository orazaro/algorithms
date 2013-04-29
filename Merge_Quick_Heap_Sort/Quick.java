public class Quick
{
    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
            while (less(a[++i], a[lo])) // find item from left which is great then lo 
                if (i == hi) break;

            while (less(a[lo], a[--j])) // find item from right which is less then lo
                if (j == lo) break;

            if (i >= j) break;          // check if pointers cross
            exch(a, i, j);              // swap wrong positioned items
        }

        exch(a, lo, j);                 // swap lo with parthioning item (pivot)
        return j;                       // return index of item on place:
                                        // on left - less
                                        // pn right = greater
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /* find k-th element in array: min, max, median etc */
    public static Comparable select(Comparable[] a, int k)
    {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if      (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else            return a[k];
        }
        return a[k];
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
