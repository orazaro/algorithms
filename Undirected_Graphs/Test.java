
public class Test {
    public static void main(String[] args) {
        //In in = new In(args[0]);
        //Graph G = new Graph(in);
        MyGraph G = new MyGraph(3);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(2,1);

        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                StdOut.println(v + "-" + w);
    }
}
