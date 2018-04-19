package source.lvl4.p20;
import java.util.*;
class Source {
    /* ********************************************************************* */
    private static boolean isBalanced(String input) {return isBalanced(input, "");}
    private static boolean isBalanced(String input, String stack) {
        if(input.isEmpty()) return stack.isEmpty();
        else if(isOpen(input.charAt(0)))
            return isBalanced(input.substring(1), input.charAt(0) + stack);
        else if(isClose(input.charAt(0)))
            return (!stack.isEmpty() && 
                    isMatching(stack.charAt(0), input.charAt(0)) && 
                    isBalanced(input.substring(1), stack.substring(1)));
        return isBalanced(input.substring(1), stack);
    }
    private static boolean isOpen(char ch) {return "([<{".indexOf(ch) != -1;}
    private static boolean isClose(char ch) {return ")]>}".indexOf(ch) != -1;}
    private static boolean isMatching(char chOpen, char chClose) {
        return "([<{".indexOf(chOpen) == ")]>}".indexOf(chClose);
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(isBalanced(args[0]));
    }
}
//        System.out.println(input);
//        if(input == null || input.equals("") || input.length() == 1) return true;
//        if(input.charAt(0) != input.charAt(input.length()-1)) return false;
//        return isBalanced(input.substring(1, input.length()-1));
