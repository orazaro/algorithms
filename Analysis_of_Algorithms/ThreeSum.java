public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        for(int i = 0; i < N; i++)
            for(int j = i+1; j < N; j++)
                for(int k = j+1; k < N; k++)
                    if(a[i] + a[j] + a[k] == 0) {
                        count++;
                        //StdOut.printf("%d %d %d\n",a[i],a[j],a[k]);
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


