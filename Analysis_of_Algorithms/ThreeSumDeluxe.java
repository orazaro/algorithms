import java.util.Arrays;


public class ThreeSumDeluxe {
    public static int bsearch(int[] a, int key) {
        int lo = 0, hi = a.length-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) hi= mid - 1;
            else if(key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        Arrays.sort(a);
        for(int i = 0; i < N; i++)
            for(int j = i+1; j < N; j++) {
                int ai = a[i]; int aj = a[j];
                if(ai < aj) {
                    int k = bsearch(a,-(ai+aj));
                    if(k >= 0 && aj < a[k]) {
                        count++;
                        //StdOut.printf("%d %d %d\n",ai,aj,a[k]);
                    }
                }
            }
        return count;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(a));
        double time = stopwatch.elapsedTime();
        StdOut.println(time);
    }
}


