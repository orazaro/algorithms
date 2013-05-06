
public class FrequencyCounter
{
    public static void main(String[] args)
    {
        //SeparateChainingHashST<String, Integer> st = 
        //    new SeparateChainingHashST<String, Integer>();
        LinearProbingHashST<String, Integer> st = 
            new LinearProbingHashST<String, Integer>();
        while (!StdIn.isEmpty())
        {
            String word = StdIn.readString();
            if (!st.contains(word)) st.put(word, 1);
            else                    st.put(word, st.get(word) + 1);
        }
        StdOut.println("return=" + st.get("return"));
        StdOut.println("public=" + st.get("public"));
    }
}
