
/****
    java -ea MyProgram      // enable assertions
    java -da MyProgram      // disable assertions (default)
*/

public class Experiment
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Stopwatch stopwatch = new Stopwatch();
        //Merge.sort(a);
        Quick.sort(a);
        double time = stopwatch.elapsedTime();
        StdOut.println(time);
        if (false)
            for(int i = 0; i < N; i++)
                StdOut.println(a[i]);
    }
}
