import java.io.File;
import java.util.Date;
public class FileSorter
{
    public static void main(String[] args)
    {
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        Insertion.sort(files);
        for(int i = 0; i < files.length; i++)
            StdOut.println(files[i].getName());

        Date d1 = new Date(2011,12,15);
        Date d2 = new Date(2011,12,14);
        StdOut.println(d1.compareTo(d2));
    }
}
