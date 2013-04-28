
/****
    java -ea MyProgram      // enable assertions
    java -da MyProgram      // disable assertions (default)
*/

public class Experiment
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        UnorderedMaxPQ<Double> pq = new UnorderedMaxPQ<Double>(1000);
        for (int i = 0; i < N; i++)
        {
           Double a = StdRandom.uniform();
           pq.insert(a);
        }
        Stopwatch stopwatch = new Stopwatch();
        double time = stopwatch.elapsedTime();
        StdOut.println(time);
        if (true)
            for(int i = 0; i < N; i++)
                StdOut.println(pq.delMax());
    }
}
