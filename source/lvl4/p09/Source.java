package source.lvl4.p09;
import java.util.*;
class Source {
    /* ********************************************************************* */
    /*
     * Note that if the digits in the string are unique, you should have a 
     * returned array of 3^N, where N is the number of digits; however, 
     * if the string contains same numbers, you may want to watch out 
     * and use a Set<> approach.
     */
    private static ArrayList<String> getStringsFromNums(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        assist(new ArrayList<Character>(), digits, map, list);
        return list;
    }
    private static void assist(ArrayList<Character> temp, String digits, 
                        HashMap<Integer, String> map, ArrayList<String> list) {
        if(digits.length() == 0) {
            char[] carr = new char[temp.size()];
            for(int i = 0; i < temp.size(); i++)
                carr[i] = temp.get(i);
            list.add(String.valueOf(carr));
            return;
        }
        Integer curr = Integer.valueOf(digits.substring(0, 1));
        String letters = map.get(curr);
        for(int i = 0; i < letters.length(); i++) {
            temp.add(letters.charAt(i));
            assist(temp, digits.substring(1), map, list);
            temp.remove(temp.size()-1);
        }
    }
    /* ********************************************************************* */
    public static ArrayList<String> getStringsFromNums2(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        class PhoneNode {
            String word;
            int count;
            PhoneNode(String w, int c){
                word = w;
                count = c;
            }
        }
        ArrayList<String> out = new ArrayList<>();
        Deque<PhoneNode> stack = new LinkedList<>();
        for(Character c: map.get(digits.charAt(0)).toCharArray())
            stack.addFirst(new PhoneNode(String.valueOf(c), 1));
        while(!stack.isEmpty()){
            PhoneNode node = stack.removeFirst();
            if(node.count == digits.length()) out.add(node.word);
            else for(Character c: 
                    map.get(digits.charAt(node.count)).toCharArray())
                    stack.addFirst(new PhoneNode(node.word + c, node.count+1));
        }
        return out;
    }
    /* ********************************************************************* */
    public static void main(String[] args) {
        System.out.println(Source.getStringsFromNums(args[0]));
        System.out.println(Source.getStringsFromNums2(args[0]));
    }
}
