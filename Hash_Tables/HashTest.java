
public class HashTest 
{
    public static int Horner(String s)
    {
        int hash = 0;
        for (int i = 0; i < s.length(); i++)
            hash = s.charAt(i) + (31 * hash);
        return hash;
    }

    public static int hash(String key)
    { return (key.hashCode() & 0x7fffffff) % 1025; }

    public static void main(String[] args)
    {
        Boolean b = true;   StdOut.println(b.hashCode());
        b = false;          StdOut.println(b.hashCode());
        Integer i = 12345;  StdOut.println(i.hashCode());
    
        String s = "TestHornerMethod";
        StdOut.printf("%d %d\n", s.hashCode(), Horner(s));
        s = "polygenelubricants";
        StdOut.printf("%d %d\n", s.hashCode(), Horner(s));
        StdOut.printf("%s %x %d\n", s, s.hashCode(), hash(s));
    }
}
