class UnionFind {
    public static void main(String[] args) {
        //System.out.println(args.length+args[0]);
        int N = StdIn.readInt();
        UF uf;
        if(args.length>0 && args[0].equals("qu")) {
            System.out.println("QuickUnion");
            uf = new QuickUnionUF(N);
        }
        else if(args.length>0 && args[0].equals("wqu")) {
            System.out.println("WeightedQuickUnion");
            uf = new WeightedQuickUnionUF(N);
        }
        else {
            System.out.println("QuickFind");
            uf = new QuickFindUF(N);
        }
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            if (p < 0) {
                p = -p;
                StdOut.print(""+p);
                for (int i = 0; i < N; i++)
                    if (i != p && uf.connected(p, i))
                        StdOut.print("<->"+i);
                StdOut.println();
                continue;
            }
            int q = StdIn.readInt();
            if (!uf.connected(p,q)) {
                uf.unioN(p, q);
                StdOut.println(p + "<->" + q);
            }
        }
        for(int i = 0; i < N; i++){
            StdOut.print(uf.id[i]+" ");
        }
        StdOut.println();
    }
}
