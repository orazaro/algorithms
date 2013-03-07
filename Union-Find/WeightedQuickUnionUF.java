public class WeightedQuickUnionUF extends UF  {
    private int[] sz;
    public WeightedQuickUnionUF(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    private int root(int i) {
        while(i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void unioN(int p, int q) {
        int i = root(p);
        int j = root(q);
        if(sz[i] < sz[j])   { id[i] = j; sz[j] += sz[i];}
        else                { id[j] = i; sz[i] += sz[j];}
    }
}
