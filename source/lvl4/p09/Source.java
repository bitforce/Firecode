package source.lvl4.p09;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class Source {
    static ArrayList<String> getStringsFromNums(final String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        final HashMap<Integer, String> map = new HashMap<>();
        final ArrayList<String> list = new ArrayList<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        assist(new ArrayList<>(), digits, map, list);
        return list;
    }
    private static void assist(
            final ArrayList<Character> temp,
            final String digits,
            final HashMap<Integer, String> map,
            final ArrayList<String> list) {
        if(digits.length() == 0) {
            char[] carr = new char[temp.size()];
            for(int i = 0; i < temp.size(); i++)
                carr[i] = temp.get(i);
            list.add(String.valueOf(carr));
            return;
        }
        final Integer curr = Integer.valueOf(digits.substring(0, 1));
        final String letters = map.get(curr);
        for(int i = 0; i < letters.length(); i++) {
            temp.add(letters.charAt(i));
            assist(temp, digits.substring(1), map, list);
            temp.remove(temp.size()-1);
        }
    }
    /* ********************************************************************* */
    static ArrayList<String> getStringsFromNums2(String digits) {
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
}
