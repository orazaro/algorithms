
public class HashTest 
{
    public static void main(String[] args)
    {
        Boolean b = true;   StdOut.println(b.hashCode());
        b = false;          StdOut.println(b.hashCode());
        Integer i = 12345;  StdOut.println(i.hashCode());
    }
}
