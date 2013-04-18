class QueueTest {
    public static void main(String[] args) {
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.println(queue.dequeue());
            else queue.enqueue(s);
        }
    }
}
