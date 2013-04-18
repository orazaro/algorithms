class StackTest {
    public static void main(String[] args) {
        //StackOfStrings stack = new LinkedStackOfStrings();
        //StackOfStrings stack = new FixedCapacityStackOfStrings(100);
        //StackOfStrings stack = new ResizingArrayStackOfStrings();
        //LinkedStack stack = new LinkedStack<String>();
        Stack stack = new Stack<String>();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.println(stack.pop());
            else stack.push(s);
        }
    }
}
