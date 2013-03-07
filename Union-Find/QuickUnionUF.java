public class QuickUnionUF extends UF  {
    public QuickUnionUF(int N) {
        super(N);
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
        id[i] = j;
    }
}
