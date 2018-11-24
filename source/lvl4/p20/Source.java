package source.lvl4.p20;

class Source {
    static boolean isBalanced(final String input) {return isBalanced(input, "");}
    private static boolean isBalanced(final String input, final String stack) {
        if(input.isEmpty()) return stack.isEmpty();
        else if(isOpen(input.charAt(0)))
            return isBalanced(input.substring(1), input.charAt(0) + stack);
        else if(isClose(input.charAt(0)))
            return (!stack.isEmpty() && 
                    isMatching(stack.charAt(0), input.charAt(0)) && 
                    isBalanced(input.substring(1), stack.substring(1)));
        return isBalanced(input.substring(1), stack);
    }
    private static boolean isOpen(final char ch) {return "([<{".indexOf(ch) != -1;}
    private static boolean isClose(final char ch) {return ")]>}".indexOf(ch) != -1;}
    private static boolean isMatching(final char chOpen, final char chClose) {
        return "([<{".indexOf(chOpen) == ")]>}".indexOf(chClose);
    }
}
