
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
        Merge.sort(a);
        for(int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}
