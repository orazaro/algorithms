abstract public class UF {
    public int[] id;

    public UF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    abstract public boolean connected(int p, int q); 

    abstract public void unioN(int p, int q);
}
