
public class HashTest 
{
    public static int Horner(String s)
    {
        int hash = 0;
        for (int i = 0; i < s.length(); i++)
            hash = s.charAt(i) + (31 * hash);
        return hash;
    }

    public static void main(String[] args)
    {
        Boolean b = true;   StdOut.println(b.hashCode());
        b = false;          StdOut.println(b.hashCode());
        Integer i = 12345;  StdOut.println(i.hashCode());
    
        String s = "TestHornerMethod";
        StdOut.printf("%d %d\n", s.hashCode(), Horner(s));
    }
}
