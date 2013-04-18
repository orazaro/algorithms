import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;

    public Stack() {
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        if(N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;    // to free unused memory
        if(N > 0 && N == s.length/4)    // if 1/4 of capacity
            resize(s.length/2);         // shrink to 1/2 of capacity
        return item;
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext()    { return i > 0;         }
        public void remove()         { /* not supported */   }
        public Item next()          { return s[--i];        }
    }
}
