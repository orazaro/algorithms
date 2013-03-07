class StackTest {
    public static void main(String[] args) {
        StackOfStrings stack = new LinkedStackOfStrings();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.println(stack.pop());
            else stack.push(s);
        }
    }
}
