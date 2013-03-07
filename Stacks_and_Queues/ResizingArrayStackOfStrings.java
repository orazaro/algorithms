public class ResizingArrayStackOfStrings extends StackOfStrings {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        if(N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for(int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;    // to free unused memory
        if(N > 0 && N == s.length/4)    // if 1/4 of capacity
            resize(s.length/2);         // shrink to 1/2 of capacity
        return item;
    }
}
