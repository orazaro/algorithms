import java.util.regex.*;

public class Crawler
{
    public static void main(String[] args)
    {
        Queue<String> queue = new Queue<String>();  // queue of websites
        SET<String> discovered = new SET<String>(); // discovered websites

        //String root = "http://www.princeton.edu";
        String root = "http://www.rambler.ru";
        queue.enqueue(root);    // start crawling from root site
        discovered.add(root);

        while(!queue.isEmpty())
        {
            String v = queue.dequeue();
            StdOut.println(v);  // read in raw html from next web site
            String input;
            try {
                In in = new In(v);
                input = in.readAll();
            } 
            catch (Exception e)
            {
                input = "";
            }

            if (input == null)
                input = "";

            String regexp = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find())
            {
                String w = matcher.group();
                //StdOut.println(w);
                if (!discovered.contains(w))
                {
                    discovered.add(w);
                    queue.enqueue(w);
                }
            }
        }
    }
}
